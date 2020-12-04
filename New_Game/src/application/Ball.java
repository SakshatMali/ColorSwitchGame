package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
//import javafx.scene.shape.circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
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
	public Shape Ball_make() {
		
		Shape circle = null;
		
		if (Main.ballshape==0) {
			circle=new Circle(radius,clr_ball);
			circle.setLayoutX(xpos);
			circle.setLayoutY(ypos);
		}
		else if (Main.ballshape==1) {
			circle=new Rectangle(radius,radius,clr_ball);
			circle.setLayoutX(xpos);
			circle.setLayoutY(ypos);
		}
		
		else if (Main.ballshape==2) {
			int side=15;
			double centroid=side/Math.sqrt(3);
			double[] xpoints = {0,side/2,-side/2};
			double[] ypoints = {centroid,-centroid/2,-centroid/2};
			circle = new Polygon(xpoints[0],ypoints[0],
					xpoints[1],ypoints[1],
					xpoints[2],ypoints[2]);
			circle.relocate(xpos, ypos);
//			circle.setLayoutX(xpos);
//			circle.setLayoutY(ypos);
			circle.setFill(clr_ball);
		}
		
//		else if (Main.ballshape==3) {
//				circle = new Ellipse(radius+10,radius); 
////				circle.setCenterX(50.0f);
////				circle.setCenterY(50.0f);
////				circle.setRadiusX(50.0f);
////				circle.setRadiusY(25.0f);
//				circle.setLayoutX(xpos);
//				circle.setLayoutY(ypos);
//				circle.setFill(clr_ball);
//				
////			circle = new Polygon(xpos-10,ypos-3,xpos-3,ypos-3,xpos-3,ypos-10,xpos+3,
////					ypos-10,xpos+3,ypos-3,xpos+10,ypos-3,xpos+10,ypos+3
////					,xpos+3,ypos+3,xpos+3,ypos+10,xpos-3,ypos+10,xpos-3,
////					ypos+3,xpos-10,ypos+3);
////			
////			
//////			circle.relocate(xpos, ypos);
//////			circle.setLayoutX(xpos-circle.getLayoutBounds().getMinX());
//////			circle.setLayoutY(ypos+circle.getLayoutBounds().getMaxY());
////			circle.setFill(clr_ball);
////			circle.setStroke(clr_ball);
//			
//		}
		
		else if (Main.ballshape==3) {
			circle = new Line(radius,radius+15, radius, radius);
			circle.setLayoutX(xpos);
			circle.setLayoutY(ypos);
			circle.setFill(clr_ball);
			circle.setStrokeWidth(5);
			circle.setStroke(clr_ball);
		}
		
		else if (Main.ballshape==4) {
			circle = new Polygon(radius-10,radius-3,radius-3,radius-3,radius-3,radius-10,radius+3,
					radius-10,radius+3,radius-3,radius+10,radius-3,radius+10,radius+3
					,radius+3,radius+3,radius+3,radius+10,radius-3,radius+10,radius-3,
					radius+3,radius-10,radius+3);
			
//			circle.setLayoutX(xpos);
//			circle.setLayoutX(ypos);
			circle.relocate(xpos, ypos);
			circle.setFill(clr_ball);
		}
		
		else if (Main.ballshape==5) {
			
			double points[] = {5, -10, 20, -60, 35, -10, 0, -40, 40, -40};
			
			circle = new Polygon(points);
			circle.setScaleX(0.6);
			circle.setScaleY(0.6);
			circle.relocate(xpos-15, ypos);
			circle.setFill(clr_ball);

		}
//		Circle circle=new Circle(radius,clr_ball);
//		circle.setLayoutX(xpos);
//		circle.setLayoutY(ypos);
//		circle.setCenterX(xpos); 
//		circle.setCenterY(ypos);
		return circle;
	}
	
//	public Rectangle Ball_make_rec() {
//		Rectangle circle=new Rectangle(radius,radius,clr_ball);
//		circle.setLayoutX(xpos);
//		circle.setLayoutY(ypos);
////		circle.setCenterX(xpos); 
////		circle.setCenterY(ypos);
//		return circle;
//	}
	
}
