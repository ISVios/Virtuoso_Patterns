package a.a.zhemanov.programm.virtuosopatterns.bnf;

import java.util.ArrayList;
import java.util.HashMap;

public class BNF {
	///
	private int position = 0;
	private int length = 0;
	private String text;
	private ArrayList<String> terminal;
	private final HashMap<String, Double> vars;

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

		return null;
	}

	///
	public void parse() {

		parseYazik();
	}

	private void parseYazik() {

		// parseVar();
		// if(currenToken == "="){
		// parsePrpart()
		// }
		// else {error}

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
	public boolean isNumb(String achar) {

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

}
