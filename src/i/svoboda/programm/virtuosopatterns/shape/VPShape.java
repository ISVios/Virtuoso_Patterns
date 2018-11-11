package i.svoboda.programm.virtuosopatterns.shape;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

public class VPShape {

	private Shape shape;
	private String idName;
	private long id;

	private long ID = 0;

	public VPShape() {
		id = ID++;
	}
	
	public void setIdName(String idName) {
		this.idName = idName;
	}
	
	public long getId() {
		return id;
	} 
	
	
	public String getIdName() {
		return idName;
	}

	public Paint getStorke() {

		return shape.getStroke();

	}

	public double getStorkeWidth() {

		return shape.getStrokeWidth();

	}

	public static VPShape union(VPShape shape1, VPShape shape2) {
		
		// find union point

		VPShape shape = new VPShape();

		return shape;

	}

	public static VPShape subtract(VPShape shape1, VPShape shape2) {

		
		// add union point + shape1
		// remove shape2
		
		VPShape vpshape = new VPShape();

		return vpshape;

	}

	public static VPShape intersect(VPShape shape1, VPShape shape2) {

		// add union point = shape
		// remove shape1
		// remove shape2
		
		VPShape vpshape = new VPShape();

		return vpshape;

	}

}
