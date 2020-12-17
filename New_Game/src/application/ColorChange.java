package application;

import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class ColorChange {
	private ShapeObstacle obstacle;
	private Color clr_arr[]= {Color.RED, Color.BLUE , Color.PURPLE , Color.YELLOW};
	private Random rand = new Random();
	
	public void make_Clr_chng(double diff,double clr_change_radius,int cc) {
		
		for (int i=0 ; i<4 ; i++) {
			Arc arc = new Arc();
			arc.setCenterX(obstacle.getXpos());
			arc.setCenterY(obstacle.getYpos()-diff/2);
			arc.setRadiusX(clr_change_radius);
			arc.setRadiusY(clr_change_radius);
			arc.setStartAngle(90*i);
			arc.setLength(90);
		
			if(cc==1) {
				arc.setStroke(clr_arr[i]);
				arc.setFill(clr_arr[i]);
			}
			else {
				arc.setStroke(null);
				arc.setFill(null);
			}
			
			arc.setType(ArcType.ROUND);
			obstacle.getList_shape().add(arc);
		}
		rand.nextInt();
		
	}
	
	public ShapeObstacle getObstacle() {
		return obstacle;
	}
	public void setObstacle(ShapeObstacle obstacle) {
		this.obstacle = obstacle;
	}
	
}
