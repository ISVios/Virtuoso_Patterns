package i.svoboda.programm.virtuosopatterns;

import i.svoboda.programm.virtuosopatterns.bnf.BNF;
import i.svoboda.programm.virtuosopatterns.bnf.BNFException;

public class Main {

	public static void main(String[] args) throws BNFException {
		
		// test
		BNF bnf = new BNF();
		bnf.setText("a=5+4");
		bnf.parse();
		bnf.setText("b=a+4"); // edit setText to addEquation
		bnf.parse();
		System.out.println(bnf.getVar("b"));
		//test//

	}

}
