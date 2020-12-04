package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;

public abstract class ShapeObstacle extends Shape {
	private double height;
	private double width;
	private double xpos;
	private double ypos;
	private int _rotate=0;
	private List<Shape> list_shape = new ArrayList<>();
	private Star star;
	private ColorChange clr_chng;
	private int side=35;
	private double centroid=side/Math.sqrt(3);
	private double[] xpoints = {0,side/2,-side/2};
	private double[] ypoints = {centroid,-centroid/2,-centroid/2};
	private Image star_new;
	
	Color clr_arr[]= {Color.RED, Color.BLUE , Color.PURPLE , Color.YELLOW};
//	Color clr_arr[]= {Color.rgb(250, 22, 151), Color.CYAN , Color.PURPLE , Color.YELLOW};
	public ShapeObstacle(double height, double width, double xpos, double ypos, int rotate) {
		super();
		this.height = height;
		this.width = width;
		this.xpos = xpos;
		this.ypos = ypos;
		_rotate=rotate;
//		star_new = new Image(new FileInputStream("src/Colour Images/star.png")); 
		star=new Star();
//		clr_chng=new ColorChange(size_clr_change);
	
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
	public Star getStar() {
		return star;
	}
	public void setStar(Star star) {
		this.star = star;
	}
	public ColorChange getClr_chng() {
		return clr_chng;
	}
	public void setClr_chng(ColorChange clr_chng) {
		this.clr_chng = clr_chng;
	}
	public abstract void makeShape();

	public abstract Rotate makeRotate(List<Shape> list);
	
	public Rotate makeRotate_Clr_chng(List<Shape> list,double diff) {
		Rotate clr_chng_rotate =new Rotate();
		clr_chng_rotate.setAngle(0);  
	    clr_chng_rotate.setPivotX(xpos);  
	    clr_chng_rotate.setPivotY(ypos-(diff/2));
        for (int i = list.size()-4; i < list.size(); i++) {
        	list.get(i).getTransforms().add(clr_chng_rotate);
		}
        return clr_chng_rotate;
	}
	public Rotate makeRotate_Star(List<Shape> list) {
		Rotate star_rotate =new Rotate();
		star_rotate.setAngle(0);  
	    star_rotate.setPivotX(xpos);  
	    star_rotate.setPivotY(ypos);
	    list.get(list.size()-5).getTransforms().add(star_rotate);
        return star_rotate;
	}
	public void makeStar() {
		double points[] = {5, -10, 20, -60, 35, -10, 0, -40, 40, -40};
		
		Polygon _star = new Polygon(points);
		_star.setScaleX(0.6);
		_star.setScaleY(0.6);
//		Polygon _star = new Polygon(xpos+xpoints[0],ypos+ypoints[0],
//				xpos+xpoints[1],ypos+ypoints[1],
//				xpos+xpoints[2],ypos+ypoints[2]);
//				xpoints[3],ypoints[3],
//				xpoints[4],ypoints[4],
//				xpoints[5],ypoints[5]);
//				xpoints[6],ypoints[6]);
//				xpoints[7],ypoints[7],
//				xpoints[8],ypoints[8],
//				xpoints[9],ypoints[9]);
				_star.relocate(xpos-20,ypos - 30);
				_star.setFill(Color.WHITE);
				_star.setStroke(Color.WHITE);
				
//				ImageView imageView = new ImageView(star_new); 
//				imageView.setFitHeight(46);
//			    imageView.setFitWidth(48);
				
//				Rotate rotate = new Rotate();    
//		        rotate.setAngle(0);  
//		        rotate.setPivotX(xpos);  
//		        rotate.setPivotY(ypos);
//		        _star.getTransforms().add(rotate);
		        getList_shape().add(_star);
		}
	public void make_Clr_chng(double diff,double clr_change_radius) {
		for (int i=0 ; i<4 ; i++) {
			Arc arc = new Arc();
			arc.setCenterX(xpos);
			arc.setCenterY(ypos-diff/2);
			arc.setRadiusX(clr_change_radius);
			arc.setRadiusY(clr_change_radius);
			arc.setStartAngle(90*i);
			arc.setLength(90);
			arc.setStroke(clr_arr[i]);
//			arc.setStrokeWidth(5);
			arc.setFill(clr_arr[i]);
			arc.setType(ArcType.ROUND);
			getList_shape().add(arc);
		}
		
	}
	public int get_rotate() {
		return _rotate;
	}
	public void set_rotate(int _rotate) {
		this._rotate = _rotate;
	}
}
