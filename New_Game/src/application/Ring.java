package application;

import java.util.ArrayList;

import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Shape;

public class Ring extends ShapeObstacle{
	public Ring(double height,double width,double xpos,double ypos) {
		super(height, width, xpos, ypos);
	}
	
	@Override
	public void makeShape(){
		for (int i=0 ; i<4 ; i++) {
			Arc arc = new Arc();
			arc.setCenterX(getXpos());
			arc.setCenterY(getYpos());
			arc.setRadiusX(getWidth());
			arc.setRadiusY(getHeight());
			arc.setStartAngle(90*i);
			arc.setLength(90);
			arc.setStroke(clr_arr[i]);
			arc.setStrokeWidth(10);
			arc.setFill(null);
			arc.setType(ArcType.OPEN);
			getList_shape().add(arc);
		}
	}
}
