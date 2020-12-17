package application;

import java.util.List;

import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;

public class DiagonalObstacle extends ShapeObstacle{
	private int quarter_frm = 80;
	public DiagonalObstacle(double height, double width, double xpos, double ypos, int rotate) {
		super(height, width, xpos, ypos, rotate);
	
	}

	@Override
	public void makeShape() {
		
		Line l1 = new Line(getXpos()-2*quarter_frm,getYpos()-50,getXpos()-2*quarter_frm+quarter_frm,getYpos());
		l1.setStroke(clr_arr[0]);
		l1.setStrokeWidth(15);
		Line l2 = new Line(getXpos()-quarter_frm,getYpos(),getXpos()-quarter_frm+quarter_frm,getYpos()-50);
		l2.setStroke(clr_arr[1]);
		l2.setStrokeWidth(15);
		Line l3 = new Line(getXpos(),getYpos()-50,getXpos()+quarter_frm,getYpos());
		l3.setStroke(clr_arr[2]);
		l3.setStrokeWidth(15);
		Line l4 = new Line(getXpos()+quarter_frm,getYpos(),getXpos()+quarter_frm+quarter_frm,getYpos()-50);
		l4.setStroke(clr_arr[3]);
		l4.setStrokeWidth(15);
		Line l5 = new Line(getXpos()-2*quarter_frm-4*quarter_frm,getYpos()-50,getXpos()-2*quarter_frm-4*quarter_frm+quarter_frm,getYpos());
		l5.setStroke(clr_arr[0]);
		l5.setStrokeWidth(15);
		Line l6 = new Line(getXpos()-2*quarter_frm-4*quarter_frm+quarter_frm,getYpos(),getXpos()-2*quarter_frm-4*quarter_frm+2*quarter_frm,getYpos()-50	);
		l6.setStroke(clr_arr[1]);
		l6.setStrokeWidth(15);
		Line l7 = new Line(getXpos()-4*quarter_frm,getYpos()-50,getXpos()-4*quarter_frm+quarter_frm,getYpos());
		l7.setStroke(clr_arr[2]);
		l7.setStrokeWidth(15);
		Line l8 = new Line(getXpos()-4*quarter_frm+quarter_frm,getYpos(),getXpos()-4*quarter_frm+2*quarter_frm,getYpos()-50);
		l8.setStroke(clr_arr[3]);
		l8.setStrokeWidth(15);
		Line l9 = new Line(getXpos()-2*quarter_frm+4*quarter_frm,getYpos()-50,getXpos()-2*quarter_frm+4*quarter_frm+quarter_frm,getYpos());
		l9.setStroke(clr_arr[0]);
		l9.setStrokeWidth(15);
		Line l10 = new Line(getXpos()-2*quarter_frm+4*quarter_frm+quarter_frm,getYpos(),getXpos()-2*quarter_frm+4*quarter_frm+2*quarter_frm,getYpos()-50);
		l10.setStroke(clr_arr[1]);
		l10.setStrokeWidth(15);
		Line l11 = new Line(getXpos()+4*quarter_frm,getYpos()-50,getXpos()+4*quarter_frm+quarter_frm,getYpos());
		l11.setStroke(clr_arr[2]);
		l11.setStrokeWidth(15);
		Line l12 = new Line(getXpos()+4*quarter_frm+quarter_frm,getYpos(),getXpos()+4*quarter_frm+2*quarter_frm,getYpos()-50);
		l12.setStroke(clr_arr[3]);
		l12.setStrokeWidth(15);
		
		getList_shape().add(l1);
		getList_shape().add(l2);
		getList_shape().add(l3);
		getList_shape().add(l4);
		getList_shape().add(l5);
		getList_shape().add(l6);
		getList_shape().add(l7);
		getList_shape().add(l8);
		getList_shape().add(l9);
		getList_shape().add(l10);
		getList_shape().add(l11);
		getList_shape().add(l12);
		
	}

	@Override
	public Rotate makeRotate(List<Shape> list) {
	
		return null;
	}
}
