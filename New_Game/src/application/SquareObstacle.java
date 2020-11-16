package application;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;

public class SquareObstacle extends ShapeObstacle{
	public SquareObstacle(double height, double width, double xpos, double ypos, int rotate){
		super(height, width, xpos, ypos,rotate);
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
