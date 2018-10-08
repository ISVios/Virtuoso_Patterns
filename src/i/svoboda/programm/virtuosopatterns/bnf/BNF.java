package i.svoboda.programm.virtuosopatterns.bnf;

import java.util.ArrayList;
import java.util.HashMap;

public class BNF {
	///
	private int position = 0;
	private int offset = 0;
	private String text;
	private ArrayList<String> terminal;
	private final HashMap<String, Double> vars; // local var

	///
	public BNF() {

		vars = new HashMap<>();

	}

	///
	public void setText(String text) {

		this.text = text;

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

		position += 1;

		return stringBuilder.toString();

	}

	///
	public String nextToken() {

		String next = nextTerminal();

		terminal.add(next);

		return next;
	}

	///
	private String currentTerminal() throws BNFException {

		if (position > terminal.size()) {

			throw new BNFException(getOffset(), currentTerminal().length(), -1, "");
		}

		return terminal.get(position - 1);
	}

	///
	public int getOffset() {

		return offset;

	}

	///
	public double getVar(String varName) {

		return (double) vars.get(varName).doubleValue();

	}

	///

	public void parse() {

		for (int i = 0; i < 10; i++) {
			System.out.println(nextTerminal());
		}

		parseYazik();
	}

	///
	private void parseYazik() {

		

	}
	
	void parseElement() {
		
	}
	
	///
	private String isVar(String var) throws BNFException{
		
		if(!isChar(var.charAt(0)+"")) {
			
			throw new BNFException(getOffset(), var.length(), 15, var);
		}
		
		int i = 1;
		while (i < var.length()) {

			if (!(isNumb((var.charAt(i)+"")) || isChar(var.charAt(i)+""))) {
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
		case "à":
		case "á":
		case "â":
		case "ã":
		case "ä":
		case "å":
		case "¸":
		case "æ":
		case "ç":
		case "è":
		case "é":
		case "ê":
		case "ë":
		case "ì":
		case "í":
		case "î":
		case "ï":
		case "ð":
		case "ñ":
		case "ò":
		case "ó":
		case "ô":
		case "õ":
		case "ö":
		case "÷":
		case "ø":
		case "ù":
		case "ú":
		case "û":
		case "ü":
		case "þ":
		case "ÿ":
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
	
}
