
/// 558 - 10 cm
/// 55,8 - 1 cm
/// 5,58 - 1 mm
/// only to draw
package i.svoboda.programm.virtuosopatterns;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import i.svoboda.programm.virtuosopatterns.area.FindArea;
import i.svoboda.programm.virtuosopatterns.bnf.BNF;
import i.svoboda.programm.virtuosopatterns.bnf.BNFException;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Main {	

	public static void main(String[] args) throws BNFException {
		
		
		BNF bnf = new BNF();
		
		bnf.addEquation("a=5+4");

		bnf.parse();
		
		System.out.println(bnf.getVarList());
		


	}

}
