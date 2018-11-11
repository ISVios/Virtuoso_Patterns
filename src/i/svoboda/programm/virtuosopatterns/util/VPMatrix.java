package i.svoboda.programm.virtuosopatterns.util;

public class VPMatrix implements Cloneable{ // need test input
	
	private int row;  // final?
	private int col;  // final?
	private double[][] elements;
	
	// zero matrix
	public VPMatrix(int row, int col) {
		
		elements = new double[row][col];
		
		
		
		for(int i = 0; i < row; i++)
			for(int j = 0; j < col; j++)
				elements[i][j] = 0;
		
	}
	
	public VPMatrix(int row, int col, double...element) {
		
		elements = new double[row][col];
		
	}
	
	public VPMatrix(double[][]elements) {
		
		this.elements = elements;
	}

	private VPMatrix(VPMatrix matrix) {   /// maybe clone? i think no
		// TODO Auto-generated constructor stub
	}
	

	@Override
	protected Object clone() throws CloneNotSupportedException {  // neeed?
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	// static metod
	
	private static void add() {}
	private static void sub() {}
	private static void mul() {}
	private static void div() {}
	
}
