package i.svoboda.programm.virtuosopatterns.area;

import java.util.ArrayList;
import java.util.Random;

import javafx.geometry.Point2D;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class FindArea {
	
	public static double getArea(Shape shape, double step) {
		
		ArrayList<Point2D> points = new ArrayList<>();
		
		if(shape == null || step <= 0)
			return -1;
		
		double shot = 0;
		double inject = 0;
		
		double boundArea = shape.getBoundsInParent().getHeight() * shape.getBoundsInParent().getWidth();
		
		Rectangle point = new Rectangle(1, 1);
		/*
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
		*/
		
		
		Point2D p;
		
		for(int i = 0; i <= step; i ++) {
			
			shot ++;
			
			//do {
				//System.out.println(-5+(new Random().nextInt(10)));
				p = new Point2D(
						(shape.getBoundsInParent().getMinX()+(new Random().nextInt((int)shape.getBoundsInParent().getMaxX()))),
						(shape.getBoundsInParent().getMinY()+(new Random().nextInt((int)shape.getBoundsInParent().getMaxY())))
						);
			//}while(points.contains(p));
			
			points.add(p);
		
			
			point.setX(p.getX());
			point.setY(p.getY());
			if(((Path)Shape.intersect(shape, point)).getElements().size() > 0) {
				
				inject ++;
				
			}
			
		}
		
		if(shot <= 0)
			return -1;
		
		return boundArea * (inject/shot) ;
		
	}
}
