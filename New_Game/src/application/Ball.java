package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Ball extends Shape{
	private double xpos;
	private double ypos;
	private double radius;
	private Color clr_ball;
	
public Ball(double xpos, double ypos, double radius, Color clr_ball) {
		super();
		this.xpos = xpos;
		this.ypos = ypos;
		this.radius = radius;
		this.clr_ball = clr_ball;
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
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public Color getClr_ball() {
		return clr_ball;
	}
	public void setClr_ball(Color clr_ball) {
		this.clr_ball = clr_ball;
	}
	public Circle Ball_make() {
		Circle circle=new Circle(radius,clr_ball);
		circle.relocate(xpos, ypos);
		return circle;
	}
	
}
