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
	@Override
	public void start(Stage primaryStage) {
		try {
			
			canvas = new Pane();
			final Scene scene = new Scene(canvas, frm_width, frm_height);
			scene.setFill(Color.BLACK);
			primaryStage.setTitle("Bouncing Ball");
			primaryStage.setScene(scene);
			primaryStage.show();
			circle = new Circle(15, Color.BLUE);
			circle.relocate(300, 600);
			canvas.getChildren().add(circle);
//			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			Circle circle;
		    List<Line> lines = new ArrayList<>();
		    List<Arc> arcs = new ArrayList<>();
		    Ring rg = new Ring(100);
		    arcs= rg.give();
		    
//		    Color defaultStroke = Color.GREEN;
//		    Color defaultFill = defaultStroke.deriveColor(1, 1, 1, 0.3);

//		    Color hitStroke = Color.RED;
//		    Color hitFill = hitStroke.deriveColor(1, 1, 1, 0.3);
//		    Group root = new Group();

//	        circle = new Circle(350, 600, 20);
//	        circle.setStroke( defaultStroke);
//	        circle.setFill( defaultFill);

//	        Polygon octagon = new Polygon(500, 50, 1200, 50, 1600, 300, 1600, 800, 1200, 1000, 500, 1000, 100, 800, 100, 300);
	        Polygon octagon = new Polygon(325,100,325,250,475,250,475,100);

	        // create lines out of the octagon
	        Color clr_arr[]= {Color.RED , Color.BLUE , Color.PURPLE , Color.YELLOW};
	        int size = octagon.getPoints().size();
	        int count=0;
	        for (int i = 0; i < size; i += 2) {
	        	
	            double startX = octagon.getPoints().get(i);
	            double startY = octagon.getPoints().get(i + 1);
	            double endX = octagon.getPoints().get((i + 2) % size);
	            double endY = octagon.getPoints().get((i + 3) % size);
	            
	            
	            Line line = new Line(startX, startY, endX, endY);
	            line.setStrokeWidth(10);
	            line.setStroke(clr_arr[count]);
	            count++;

	            lines.add(line);
	        }
	        
	        
	        
	        Rotate rotate = new Rotate();  
	        
	        //setting properties for the rotate object.   
	        rotate.setAngle(0);  
	        rotate.setPivotX(400);  
	        rotate.setPivotY(175); 
	        
	        for (int i = 0; i < 4; i++) {
				lines.get(i).getTransforms().add(rotate);
			}

//	        MouseGestures mg = new MouseGestures();
//	        mg.makeDraggable(circle);
	        
	        canvas.getChildren().addAll(lines);
	        canvas.getChildren().addAll(arcs);
//	        canvas.getChildren().add(circle);
	        
//	        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new
//	       		 EventHandler<ActionEvent>() {
//	       		 double dx = 1;
//	       		 double dy = 1;
//	       		 @Override
//	       		 public void handle(final ActionEvent t) {
//	       		 circle.setLayoutX(circle.getLayoutX() + dx);
//	       		 circle.setLayoutY(circle.getLayoutY() + dy);
//	       		 Bounds bounds = canvas.getBoundsInLocal();
//	       		 System.out.println(circle.getLayoutY()+"    "+(bounds.getMaxY() - circle.getRadius()));
//	       		 System.out.println();
//	       		 if ( circle.getLayoutY() >= bounds.getMaxY() - circle.getRadius() ) {
//	       			 dy = -dy;
////	       			 System.out.println("gf");
//	       		 }
//	       		 
//	       		 
//	       		
//	       		 }
//	       		 }));
	        loop = new Timeline(new KeyFrame(Duration.millis(10), e -> run(circle,lines,rotate)));
	        
	        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
	            @Override
	            public void handle(KeyEvent event) {
	                if (event.getCode()== KeyCode.UP ) {
//	                	System.out.println("hhh");
	                	gameup=1;
	                	
	                	
	                }
	            }
	        });
			
			scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
	            @Override
	            public void handle(KeyEvent event) {
	                if (event.getCode()== KeyCode.UP) {
	              
//	                	System.out.println("yyy");
	                	gameup=-1;
	        
	                }
	            }
	        });
	        
	        loop.setCycleCount(Timeline.INDEFINITE);         
	        loop.play();
//	        primaryStage.setScene(new Scene(canvas, 800, 700));
//	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run(Circle circle, List<Line> lines ,Rotate rotate) {
		
		rotate.setAngle(rotate.getAngle()+0.3);
		
		for (int i =0 ; i<4;i++) {
//			System.out.println(lines.get(i).getBoundsInParent()+"         "+(circle.getBoundsInParent()));
			Shape shape = Shape.intersect(circle, lines.get(i));
			boolean intersects = shape.getBoundsInLocal().getWidth() != -1;
			if (intersects) {
				System.out.println("Touch");
				System.out.println(lines.get(i).getStroke());
				circle.setFill(lines.get(i).getStroke());
//				loop.stop();
			}
//			if(circle.getBoundsInParent().intersects(lines.get(i).getBoundsInLocal())) {
//				System.out.println("Touch");
//				loop.stop();
//			}
		}
		
		if (gameup==1) {
			circle.setLayoutY(circle.getLayoutY() -3);
		}
		else if (gameup==-1) {
			circle.setLayoutY(circle.getLayoutY() +1);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
