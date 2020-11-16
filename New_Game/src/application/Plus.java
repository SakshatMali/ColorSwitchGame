package application;

import java.util.List;

import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;

public class Plus extends ShapeObstacle {
	private int shift_plus=100;
	public Plus(double height, double width, double xpos, double ypos,int rotate) {
		super(height, width, xpos, ypos,rotate);
	}

	@Override
	public void makeShape() {
		Line l1 = new Line(getXpos()-shift_plus,getYpos(),getXpos()-shift_plus,getYpos()+getHeight());
		l1.setStroke(clr_arr[0]);
		l1.setStrokeWidth(15);
		Line l2 = new Line(getXpos()-shift_plus,getYpos(),getXpos()-shift_plus,getYpos()-getHeight());
		l2.setStroke(clr_arr[1]);
		l2.setStrokeWidth(15);
		Line l3 = new Line(getXpos()-shift_plus,getYpos(),getXpos()-shift_plus+getWidth(),getYpos());
		l3.setStroke(clr_arr[2]);
		l3.setStrokeWidth(15);
		Line l4 = new Line(getXpos()-shift_plus,getYpos(),getXpos()-shift_plus-getWidth(),getYpos());
		l4.setStroke(clr_arr[3]);
		l4.setStrokeWidth(15);
		
		getList_shape().add(l1);
		getList_shape().add(l2);
		getList_shape().add(l3);
		getList_shape().add(l4);
	}
	
	@Override
	public Rotate makeRotate(List<Shape> list) {
	    Rotate rotate = new Rotate(); 
        rotate.setAngle(0);  
        rotate.setPivotX(getXpos()-shift_plus);  
        rotate.setPivotY(getYpos());
      
        for (int i = 0; i < list.size()-5; i++) {
			list.get(i).getTransforms().add(rotate);
		}
        return rotate;
	}
}
