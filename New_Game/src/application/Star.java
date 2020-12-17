package application;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Star extends Shape {
	private Polygon _star;
	private ShapeObstacle obstacle;
	private double points[] = {5, -10, 20, -60, 35, -10, 0, -40, 40, -40};
	public Star() {
		_star=new Polygon(points);
	}
	public void _makeStar(int ss) {
		_star.setScaleX(0.6);
		_star.setScaleY(0.6);
		_star.relocate(obstacle.getXpos()-20, obstacle.getYpos()-30);
		if(ss==1) {
			_star.setFill(Color.WHITE);
			_star.setStroke(Color.WHITE);
		}
		else {
			_star.setFill(null);
			_star.setStroke(null);
		}
		obstacle.getList_shape().add(_star);
	}
	public ShapeObstacle getObstacle() {
		return obstacle;
	}
	public void setObstacle(ShapeObstacle obstacle) {
		this.obstacle = obstacle;
	}

}
