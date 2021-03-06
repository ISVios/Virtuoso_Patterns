package i.svoboda.programm.virtuosopatterns.bnf;

import java.util.ArrayList;
import java.util.HashMap;

public class BNF {
	///
	private int position = -1;
	private int offset = 0;
	private int currEquation = 0;
	private String text;
	private ArrayList<String> equations;
	private ArrayList<String> terminal;
	private final HashMap<String, Double> vars; // local var

	///
	public BNF() {

		vars = new HashMap<>();
		equations = new ArrayList<>();
		terminal = new ArrayList<>();

	}

	public void addEquation(String equation) {

		this.equations.add(equation);

	}

	///
	private String nextTerminal() {

		char achar;

		boolean space = false;

		StringBuilder stringBuilder = new StringBuilder();

		while (offset < text.length()) {

			achar = text.charAt(offset);

			if (achar == ':' || achar == ',' || achar == '=' || achar == '+' || achar == '-' || achar == '*'
					|| achar == '/' || achar == '^' || achar == '(' || achar == ')') {

				if (space)
					return stringBuilder.toString();

				if (!stringBuilder.toString().isEmpty()) {
					return stringBuilder.toString();
				}

				stringBuilder.append(achar);
				offset++;
				return stringBuilder.toString();
			} else if (achar != ' ' && achar != '\n') {

				if (space)
					return stringBuilder.toString();

				stringBuilder.append(achar);

			} else if (achar == ' ' || achar == '\n') {

				if (!stringBuilder.toString().isEmpty()) {
					space = true;
				}
			}

			offset++;

		}

		return stringBuilder.toString();

	}

	///
	public String nextToken() {

		String next = nextTerminal();

		if (next == null) {

			System.out.println("end");

			return null;

		}

		terminal.add(next);

		position += 1;

		return next;
	}

	///
	private String currentToken() throws BNFException {

		if (position > terminal.size()) {

			throw new BNFException(getOffset(), currentToken().length(), -1, "");
		}

		return terminal.get(position);
	}

	///
	public int getOffset() {

		return offset;

	}

	///
	public double getVar(String varName) {

		return (double) vars.get(varName).doubleValue(); // add error exception

	}

	///
	public void parse() throws BNFException {

		parseYazik();
	}

	///
	private void parseYazik() throws BNFException {

		for (String eq : equations) {
			
			text = eq;
			
			position = -1;
			offset = 0;
			currEquation = 0;
			terminal.clear();
			
			String tok = nextToken();

			if (nextToken().equals("=")) {

				nextToken();
				vars.put(tok, getRightPart());

			}
		}

	}

	///
	private double getRightPart() throws BNFException {

		double minus = 1.0;

		if (currentToken().equals("-")) {

			minus = -1.0;
			nextToken();

		} else if (currentToken().equals("+")) {

			nextToken();

		} else if (isMulSign(currentToken())) {

			throw new BNFException(getOffset(), currentToken().length(), 4, currentToken());

		} else if (currentToken().equals("^")) {

			throw new BNFException(getOffset(), currentToken().length(), 5, currentToken());
		}

		return parsAdiBlock() * minus;
	}

	///
	private double parsAdiBlock() throws BNFException {

		boolean start = false;

		double result = 0;
		double acum = 0;

		do {

			if (!start) {

				result = parseMulBlock();

				start = true;

			} else {

				String com = currentToken();

				nextToken();

				if (isMulSign(currentToken()) || currentToken().charAt(0) == ')') {

					throw new BNFException(getOffset(), currentToken().length(), 20, currentToken());

				}

				acum = parseMulBlock();

				if (com.equals("+")) {

					result += acum;

				} else if (com.equals("-")) {

					result -= acum;

				}

			}

		} while (isAddSign(currentToken()));

		return result;

	}

	///
	private double parseMulBlock() throws BNFException {

		boolean start = false;

		double result = 1.0;
		double acum = 1.0;

		do {

			if (!start) {

				result = parsePowBlock();

				start = true;

			} else {

				String com = currentToken();

				nextToken();
				if (isMulSign(currentToken()) || currentToken().charAt(0) == ')') {

					throw new BNFException(getOffset(), currentToken().length(), 20, currentToken());
				}

				acum = parsePowBlock();

				if (com.equals("*")) {

					result *= acum;

				} else if (com.equals("/")) {

					result /= acum;

				}

			}

		} while (isMulSign(currentToken()));

		return result;

	}

	///
	private double parsePowBlock() throws BNFException {
		boolean start = false;

		double result = 0.0;
		double acum = 0.0;

		do {

			if (!start) {

				result = parseFuncBlock();

				start = true;

			} else {

				nextToken();

				if (currentToken().equals("^")) {

					throw new BNFException(getOffset(), currentToken().length(), 20, currentToken());
				} else if (isMulSign(currentToken()) || currentToken().charAt(0) == ')') {

					throw new BNFException(getOffset(), currentToken().length(), 20, currentToken());
				}
				acum = parseFuncBlock();

				result = Math.pow(result, acum);

			}

		} while (currentToken().equals("^"));

		return result;
	}

	///
	private double parseFuncBlock() throws BNFException {

		double result = 0;

		if (parseFunc(currentToken())) {

			String func = currentToken();

			nextToken();

			if (!currentToken().equals("(")) {
				throw new BNFException(getOffset(), currentToken().length(), 9, currentToken());
			}

			nextToken();

			switch (func) {
			case "abs":
				result = Math.abs(getRightPart());
				break;
			case "sin":
				result = Math.sin(getRightPart());
				break;
			case "cos":
				result = Math.cos(getRightPart());
				break;
			case "ln":
				result = Math.log(getRightPart());
				break;
			case "sqrt":
				result = Math.sqrt(getRightPart());
				break;
			}

			if (!currentToken().equals(")")) {
				throw new BNFException(getOffset(), currentToken().length(), 10, currentToken());
			}

			nextToken();

			return result;

		}

		result = parseElemBlock();

		return result;

	}

	///
	private double parseElemBlock() throws BNFException {

		double elm = 0;
		if (Character.isLetter(currentToken().charAt(0))) {

			if (!isChar(currentToken())) {
				throw new BNFException(getOffset(), currentToken().length(), 15, currentToken());
			}
			if (isVar(currentToken()) != null) {
				elm = vars.get(currentToken());
			}
		} else if (isSteloe(currentToken())) {

			for (int i = 0; i < currentToken().length(); i++) {

				if (!isNumb(currentToken().charAt(i) + "")) {
					throw new BNFException(getOffset(), currentToken().length(), 11, currentToken());
				}
			}
			elm = parseSteloe(currentToken());

		} else if (currentToken().equals("")) {

			while (currentToken().equals(""))
				nextToken();

		} else {

			boolean open = false;
			int pos = -1;

			if (currentToken().equals("(")) {
				open = true;
				pos = getOffset();

				nextToken();
			}
			double result = getRightPart();

			if (currentToken().equals(")")) {
				if (!open) {
					throw new BNFException(pos + getOffset(), getOffset(), 12, ")");

				}

				pos = getOffset();

				nextToken();

				open = false;

			}

			if (open) {

				throw new BNFException(pos + getOffset(), getOffset(), 13, "(");

			}

			return result;

		}

		nextToken();

		return elm;

	}

	///
	private double parseSteloe(String currentToken) {

		int sel = 0;

		try {

			sel = Integer.parseInt(currentToken, 8);

		} catch (Exception e) {
			System.out.println("is not sel");
		}

		return sel;

	}

	///
	private boolean isSteloe(String currentToken) {

		try {

			Integer.parseInt(currentToken);
			// return true;

		} catch (Exception e) {

			return false;

		}

		return true;

	}

	///
	private boolean parseFunc(String func) {
		switch (func) {
		case "abs":
		case "sin":
		case "cos":
		case "ln":
		case "sqrt":
			return true;
		default:
			return false;
		}
	}

	///
	void parseElement() {

	}

	///
	private String isVar(String var) throws BNFException {

		if (!isChar(var.charAt(0) + "")) {

			throw new BNFException(getOffset(), var.length(), 15, var);
		}

		int i = 1;
		while (i < var.length()) {

			if (!(isNumb((var.charAt(i) + "")) || isChar(var.charAt(i) + ""))) {
				throw new BNFException(getOffset(), var.length(), 16, var);
			}

			i++;
		}

		return var;
	}

	///
	public double solution() {

		return 0;

	}

	///
	public boolean isChar(String achar) {

		switch (achar.trim().toLowerCase()) {

		case "a":
		case "b":
		case "c":
		case "d":
		case "e":
		case "f":
		case "g":
		case "h":
		case "i":
		case "j":
		case "k":
		case "l":
		case "m":
		case "n":
		case "o":
		case "p":
		case "q":
		case "r":
		case "s":
		case "t":
		case "u":
		case "v":
		case "w":
		case "x":
		case "y":
		case "z":

		case "а":
		case "б":
		case "в":
		case "г":
		case "д":
		case "е":
		case "ё":
		case "ж":
		case "з":
		case "и":
		case "й":
		case "к":
		case "л":
		case "м":
		case "н":
		case "о":
		case "п":
		case "р":
		case "с":
		case "т":
		case "у":
		case "ф":
		case "х":
		case "ц":
		case "ч":
		case "ш":
		case "щ":
		case "ъ":
		case "ы":
		case "ь":
		case "э":
		case "ю":
		case "я":
			return true;
		default:
			return false;

		}

	}

	///
	private boolean isNumb(String achar) {

		switch (achar.trim().toLowerCase()) {

		case "0":
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
			return true;

		default:
			return false;
		}

	}

	///
	private boolean isMulSign(String sign) {

		switch (sign) {
		case "*":
		case "/":
			return true;
		default:
			return false;
		}

	}

	///
	private boolean isAddSign(String sign) {

		switch (sign) {
		case "+":
		case "-":
			return true;
		default:
			return false;
		}

	}

	///
	public String getVarList() {

		StringBuilder out = new StringBuilder();

		for (String key : vars.keySet()) {

			out.append(key).append("=");
			out.append(vars.get(key));
			out.append("\n");

		}

		return out.toString();

	}

}
