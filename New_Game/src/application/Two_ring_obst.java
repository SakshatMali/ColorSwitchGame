package application;

import java.util.List;

import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;

public class Two_ring_obst extends ShapeObstacle{
	
	public Two_ring_obst(double height, double width, double xpos, double ypos, int rotate) {
		super(height, width, xpos, ypos, rotate);
	}

	@Override
	public void makeShape() {
		for (int i=0 ; i<4 ; i++) {
			Arc arc = new Arc();
			arc.setCenterX(getXpos());
			arc.setCenterY(getYpos());
			arc.setRadiusX(getWidth()+60);
			arc.setRadiusY(getHeight()+60);
			arc.setStartAngle(90*i);
			arc.setLength(90);
			arc.setStroke(clr_arr[i]);
			arc.setStrokeWidth(10);
			arc.setFill(null);
			arc.setType(ArcType.OPEN);
			getList_shape().add(arc);
		}
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

	@Override
	public Rotate makeRotate(List<Shape> list) {
		Rotate rotate = new Rotate(); 
        rotate.setAngle(0);  
        rotate.setPivotX(getXpos());  
        rotate.setPivotY(getYpos());
        for (int i = 0; i < list.size()-5; i++) {
			list.get(i).getTransforms().add(rotate);
		}
        return rotate;
	}
	
}
