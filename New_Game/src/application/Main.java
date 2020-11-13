package application;
	
import java.util.*;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;


public class Main extends Application {
	
	private static Circle circle;
	private static Pane canvas;
	private int gameup =0;
	private Timeline loop;
	private int frm_width = 600;
	private int frm_height = 750;
	private int ball_radius=15;
	boolean screen_mover = false;
	private ArrayList<ShapeObstacle> Obstacles;
	@Override
	public void start(Stage primaryStage) {
		try {
			
			canvas = new Pane();
			final Scene scene = new Scene(canvas, frm_width, frm_height);
			scene.setFill(Color.BLACK);
			primaryStage.setTitle("Bouncing Ball");
			primaryStage.setScene(scene);
			primaryStage.show();
			Ball ball=new Ball(frm_width/2,frm_height-150,ball_radius,Color.BLUE);
			Circle myBall=ball.Ball_make();
			canvas.getChildren().add(myBall);

			Obstacles=new ArrayList<>();
		    Ring rng=new Ring(100,100,frm_width/2,300);
		    rng.makeShape();
		    
		    
		    SquareObstacle sqr_obst=new SquareObstacle(150,150,frm_width/2,25);
		    sqr_obst.makeShape();
		    
		    Obstacles.add(rng);
		    Obstacles.add(sqr_obst);

	        ArrayList<Rotate> arr_rotate=new ArrayList<>();
	        
	        for (int i = 0; i < Obstacles.size(); i++) {
	        	Rotate rotate1=Obstacles.get(i).makeRotate(Obstacles.get(i).getList_shape());
	 	        arr_rotate.add(rotate1);
	 	        canvas.getChildren().addAll(Obstacles.get(i).getList_shape());
			}
	       
	        
	        loop = new Timeline(new KeyFrame(Duration.millis(10), e -> run(myBall,Obstacles,arr_rotate)));
	        
	        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
	            @Override
	            public void handle(KeyEvent event) {
	                if (event.getCode()== KeyCode.UP ) {
	                	gameup=1;
	                }
	            }
	        });
			
			scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
	            @Override
	            public void handle(KeyEvent event) {
	                if (event.getCode()== KeyCode.UP) {
	                	gameup=-1;
	                }
	            }
	        });
	        
	        loop.setCycleCount(Timeline.INDEFINITE);         
	        loop.play();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run(Circle circle, ArrayList<ShapeObstacle> Obstacles ,ArrayList<Rotate> arr_rotate) {
		
		for (int i = 0; i < arr_rotate.size(); i++) {
			arr_rotate.get(i).setAngle(arr_rotate.get(i).getAngle()+0.5);
		}
		
		if(circle.getLayoutY()<frm_height/2) {
			screen_mover=true;
		}
		
		for (int i = 0; i < Obstacles.size(); i++) {
			for (int j = 0; j < Obstacles.get(i).getList_shape().size(); j++) {
				Shape shape = Shape.intersect(circle, Obstacles.get(i).getList_shape().get(j));
				boolean intersects = shape.getBoundsInLocal().getWidth() != -1;
				if (intersects) {
					
//					System.out.println(Obstacles.get(i).getList_shape().get(j).getStroke());
					circle.setFill(Obstacles.get(i).getList_shape().get(j).getStroke());
//					loop.stop();
				}
			}
		}
		
		if (gameup==1) {
			circle.setLayoutY(circle.getLayoutY() -7);
			for (int i = 0; i < Obstacles.size(); i++) {
				if(screen_mover) {
					Obstacles.get(i).setYpos(Obstacles.get(i).getYpos()+2);
					Obstacles.get(i).makeShape();
//					ShapeObstacle obst
//					canvas.getChildren().addAll(Obstacles.get(i).getList_shape());
				}
			}
			
		}
		else if (gameup==-1) {
			circle.setLayoutY(circle.getLayoutY() +2);
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
