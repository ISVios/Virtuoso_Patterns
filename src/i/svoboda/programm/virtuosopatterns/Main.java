package i.svoboda.programm.virtuosopatterns;

import i.svoboda.programm.virtuosopatterns.bnf.BNF;

public class Main {

	public static void main(String[] args) {
		
		// test
		BNF bnf = new BNF();
		bnf.setText("a=5+4");
		bnf.parse();
		//test//

	}

}
