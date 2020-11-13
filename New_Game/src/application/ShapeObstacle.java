package application;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;

public abstract class ShapeObstacle extends Shape {
	private double height;
	private double width;
	private double xpos;
	private double ypos;
	private List<Shape> list_shape = new ArrayList<>();
	Color clr_arr[]= {Color.RED , Color.BLUE , Color.PURPLE , Color.YELLOW};
	
	public ShapeObstacle(double height, double width, double xpos, double ypos) {
		super();
		this.height = height;
		this.width = width;
		this.xpos = xpos;
		this.ypos = ypos;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getXpos() {
		return xpos;
	}
	public void setXpos(double xpos) {
		this.xpos = xpos;
	}
	public double getYpos() {
		return ypos;
	}
	public void setYpos(double ypos) {
		this.ypos = ypos;
	}
	public List<Shape> getList_shape() {
		return list_shape;
	}
	public void setList_shape(List<Shape> list_shape) {
		this.list_shape = list_shape;
	}
	public abstract void makeShape();
	public Rotate makeRotate(List<Shape> list) {
	    Rotate rotate = new Rotate();    
        rotate.setAngle(0);  
        rotate.setPivotX(xpos);  
        rotate.setPivotY(ypos);
        for (int i = 0; i < 4; i++) {
			list.get(i).getTransforms().add(rotate);
		}
        return rotate;
	}
}
