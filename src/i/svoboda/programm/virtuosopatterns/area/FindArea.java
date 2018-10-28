package i.svoboda.programm.virtuosopatterns.area;

import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class FindArea {
	
	public static double getArea(Shape shape, double step) {
		
		if(shape == null || step <= 0)
			return -1;
		
		double shot = 0;
		double inject = 0;
		
		double boundArea = shape.getBoundsInParent().getHeight() * shape.getBoundsInParent().getWidth();
		
		Rectangle point = new Rectangle(step, step);
		
		for(double x = shape.getBoundsInParent().getMinX(); x <= shape.getBoundsInParent().getMaxX(); x += step) {
			
			for(double y = shape.getBoundsInParent().getMinY(); y <= shape.getBoundsInParent().getMaxY(); y += step) {
				
				shot ++;
				
				point.setX(x);
				point.setY(y);
				
				if(((Path)Shape.intersect(shape, point)).getElements().size() > 0) {
					
					inject ++;
					
				}
				
			}
			
		}
		
		if(shot <= 0)
			return -1;
		
		return boundArea * (inject/shot) ;
		
	}
}
