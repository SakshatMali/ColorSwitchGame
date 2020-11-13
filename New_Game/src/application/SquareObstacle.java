package application;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public class SquareObstacle extends ShapeObstacle{
	public SquareObstacle(double height, double width, double xpos, double ypos){
		super(height, width, xpos, ypos);
	}
	
	@Override
	public void makeShape() {
		Polygon square = new Polygon(getXpos()-getWidth()/2,getYpos()-getHeight()/2,
									getXpos()-getWidth()/2,getYpos()+getHeight()/2,
									getXpos()+getWidth()/2,getYpos()+getHeight()/2,
									getXpos()+getWidth()/2,getYpos()-getHeight()/2);
		 int size = square.getPoints().size();
	        int count=0;
	        for (int i = 0; i < size; i += 2) {
	        	
	            double startX = square.getPoints().get(i);
	            double startY = square.getPoints().get(i + 1);
	            double endX = square.getPoints().get((i + 2) % size);
	            double endY = square.getPoints().get((i + 3) % size);
	            
	            
	            Line line = new Line(startX, startY, endX, endY);
	            line.setStrokeWidth(10);
	            line.setStroke(clr_arr[count]);
	            count++;
	            getList_shape().add(line);
	        }
	}

}
