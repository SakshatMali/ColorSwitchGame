package application;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Shape;

public class Ring extends Shape{
	double radius;
	Color clr_arr[]= {Color.RED , Color.BLUE , Color.PURPLE , Color.YELLOW};
	public Ring(double radius) {
		this.radius=radius;
	}
	
	public List<Arc> give(){
		
		List<Arc> arrc = new ArrayList<>();
		
		for (int i=0 ; i<4 ; i++) {
			
			Arc arc = new Arc();
			arc.setCenterX(300);
			arc.setCenterY(300);
			arc.setRadiusX(radius);
			arc.setRadiusY(radius);
			arc.setStartAngle(90*i);
			arc.setLength(90);
			arc.setStroke(clr_arr[i]);
			arc.setStrokeWidth(10);
			arc.setFill(null);
			arc.setType(ArcType.OPEN);
			arrc.add(arc);
		}
		System.out.println("coll");
		return arrc;
	}
}
