package application;

import java.util.ArrayList;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
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
public class GamePlayController {
	private Pane canvas;
	private int gameup =0;
	private Timeline loop;
	private int frm_width = 600;
	private int frm_height = 750;
	private int ball_radius=15;
	private int clr_change_radius=13;
	boolean screen_mover = false;
	private double diff_obst = 450;
	private boolean hrzntl_mov=false;
//	private Button pause_button;
	private Ball ball;
	private Player player;
	private Image pause;
	private Text scr;
	private DataTable datatable;
	private ArrayList<ShapeObstacle> Obstacles;
	
//	public GamePlayController(Pane canvas, Timeline loop, Ball ball, Player player, Image pause, Text scr,
//			DataTable datatable, ArrayList<ShapeObstacle> obstacles) {
//		super();
//		this.canvas = canvas;
//		this.loop = loop;
//		this.ball = ball;
//		this.player = player;
//		this.pause = pause;
//		this.scr = scr;
//		this.datatable = datatable;
//		Obstacles = obstacles;
//	}

	
	
	public void play(ActionEvent event) {
		PlayGame(event);
	}
	
	public void PlayGame(ActionEvent event) {
//		canvas = new Pane();
		
//		final Scene scene = new Scene(canvas, frm_width, frm_height);
		try {
		canvas = new Pane();
//		canvas.getChildren().add(backg);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		Scene scene = new Scene(canvas,frm_width,frm_height);
		scene.setFill(Color.BLACK);
		canvas.setStyle("-fx-background-color: #000000;");
	
		primaryStage.setTitle("Byll");
		primaryStage.setScene(scene);
////		scene.setFill(Color.BLACK);
		primaryStage.show();
		
		
		pause = new Image(new FileInputStream("src/Colour Images/Pause.png"));  
//		pause_button = new Button();
	      
	      //Setting the image view 
	    ImageView imageView = new ImageView(pause); 
	    
	    
	    imageView.setX(480);
	    imageView.setY(20);
//	    pause_button.setTranslateX(480);
//	    pause_button.setTranslateY(20);
//	    pause_button.setPrefSize(100, 100);
	    
	    imageView.setFitHeight(100);
	    imageView.setFitWidth(100);
//	    pause_button.setGraphic(imageView);
	    scr = new Text();       
	    scr.setText("0"); 
	    scr.setX(50); 
	    scr.setY(80); 
	    scr.setFill(Color.WHITE);
	    scr.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 60));
	    
	    
	    canvas.getChildren().addAll(imageView,scr);
		scene.setFill(Color.BLACK);
		primaryStage.setTitle("Bouncing Ball");
		primaryStage.setScene(scene);
		primaryStage.show();
		player=new Player(0,0,0);
		ball=new Ball(frm_width/2,frm_height-150,ball_radius,Color.BLUE);
		Circle myBall=ball.Ball_make();
//		canvas.getChildren().add(myBall);

		Obstacles=new ArrayList<>();
//		double[] xpoints = {10, 85, 110, 135, 210, 160,
//		        170, 110, 50, 60};
//		double[] ypoints = {85, 75, 10, 75, 85, 125,
//		        190, 150, 190, 125};
//		double[] xpoints = {4,0,3.5,2,5,4};
//		double[] ypoints = {4,4,1,5,1,4};
		
		
	    ShapeObstacle rng=new Ring(100,100,frm_width/2,300,1);  
	    rng.makeShape();
	    rng.makeStar();
	    rng.make_Clr_chng(diff_obst,clr_change_radius);
	    Obstacles.add(rng);
	    
	    ShapeObstacle sqr_obst=new SquareObstacle(150,150,frm_width/2,Obstacles.get(Obstacles.size()-1).getYpos()-diff_obst,1);
	    sqr_obst.makeShape();
	    sqr_obst.makeStar();
	    sqr_obst.make_Clr_chng(diff_obst,clr_change_radius);
	    Obstacles.add(sqr_obst);

	    ShapeObstacle plus=new Plus(100,100,frm_width/2,Obstacles.get(Obstacles.size()-1).getYpos()-diff_obst,1); 
	    plus.makeShape();
	    plus.makeStar();
	    plus.make_Clr_chng(diff_obst,clr_change_radius);
	    Obstacles.add(plus);
	    
	    ShapeObstacle _line=new LineObstacle(0,100,frm_width/2,Obstacles.get(Obstacles.size()-1).getYpos()-diff_obst,0); 
	    _line.makeShape();
	    _line.makeStar();
	    _line.make_Clr_chng(diff_obst,clr_change_radius);
	    Obstacles.add(_line);
	    
        ArrayList<Rotate> arr_rotate=new ArrayList<>();
        ArrayList<ShapeObstacle> arr_hrzntl_rotate=new ArrayList<>();
        for (int i = 0; i < Obstacles.size(); i++) {
        		if(Obstacles.get(i).get_rotate()==1) {
        			Rotate rotate1=Obstacles.get(i).makeRotate(Obstacles.get(i).getList_shape());
		 	        arr_rotate.add(rotate1);
        		}
        		else {
//	        		ShapeObsta rotate1=Obstacles.get(i).makeRotate(Obstacles.get(i).getList_shape());
		 	        arr_hrzntl_rotate.add(Obstacles.get(i));	
        		}
//        		Rotate rotate1=Obstacles.get(i).makeRotate(Obstacles.get(i).getList_shape());
//	 	        arr_rotate.add(rotate1);
	 	        
        		Rotate rotate2=Obstacles.get(i).makeRotate_Clr_chng(Obstacles.get(i).getList_shape(),diff_obst);
	 	        arr_rotate.add(rotate2);
	 	        
	 	        Rotate rotate3=Obstacles.get(i).makeRotate_Star(Obstacles.get(i).getList_shape());
	 	        arr_rotate.add(rotate3);
	 	        
	 	        canvas.getChildren().addAll(Obstacles.get(i).getList_shape());
		}
        
        canvas.getChildren().add(myBall);
        loop = new Timeline(new KeyFrame(Duration.millis(10), e -> run(myBall,Obstacles,arr_rotate,arr_hrzntl_rotate)));
        
        imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
        	
            @Override
            public void handle(MouseEvent event) {
////            	pause_button.setCursor(Cursor.HAND); 
//            	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
////            	window.getScene().getRoot().setCursor(Cursor.WAIT);
//
//
////                System.out.println("Tile pressed ");
////                event.consume();
//                Parent tableViewParent = null;
//				try {
//					tableViewParent = FXMLLoader.load(getClass().getResource("PauseDialogBox.fxml"));
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//    	        Scene tableViewScene = new Scene(tableViewParent);
////    	        tableViewScene.setFill(Color.BLACK);
//    	        
//    	        //This line gets the Stage information
//    	        
////    	        tableViewParent.setStyle("-fx-background-color: #000000;");
//    	        window.setScene(tableViewScene);
            	
//    	        window.show();
            	datatable=new DataTable(player.getCurr_scr(),player.getMax_scr(),player.getTotal_stars(),1,2);
            	
            	 FXMLLoader loader = new FXMLLoader(getClass().getResource("PauseDialogBox.fxml"));
            	 Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            	 try {
					window.setScene(new Scene(loader.load()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	 PauseDialogBoxController controller = loader.getController();
            	  controller.initData(datatable);

            	  window.show();
            }
       });
        
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
//        loop.setAutoReverse(true);
        loop.play();
	} catch(Exception e) {
		e.printStackTrace();
	}
}

public void run(Circle circle, ArrayList<ShapeObstacle> Obstacles ,ArrayList<Rotate> arr_rotate,ArrayList<ShapeObstacle> arr_hrzntl_rotate) {
	
	for (int i = 0; i < arr_rotate.size(); i++) {
//		if(arr)
		arr_rotate.get(i).setAngle(arr_rotate.get(i).getAngle()+1);
	}
	for (int i = 0; i < arr_hrzntl_rotate.size(); i++) {
//		for (int j = 0; j < arr_hrzntl_rotate.get(i).getList_shape().size(); j++) {
//			(arr_hrzntl_rotate.get(i).getList_shape().get(j)).setLayoutX(arr_hrzntl_rotate.get(i).getList_shape().get(j).getLayoutX()+.5);
			if(arr_hrzntl_rotate.get(i).getList_shape().get(0).getLayoutX()>=-300 && hrzntl_mov==false){
				for (int j = 0; j < arr_hrzntl_rotate.get(i).getList_shape().size(); j++) {
					(arr_hrzntl_rotate.get(i).getList_shape().get(j)).setLayoutX(arr_hrzntl_rotate.get(i).getList_shape().get(j).getLayoutX()-1);
				}
				if(arr_hrzntl_rotate.get(i).getList_shape().get(0).getLayoutX()==-300)hrzntl_mov=true;
				
			}
			else if(hrzntl_mov==true){
				for (int j = 0; j < arr_hrzntl_rotate.get(i).getList_shape().size(); j++) {
					(arr_hrzntl_rotate.get(i).getList_shape().get(j)).setLayoutX(arr_hrzntl_rotate.get(i).getList_shape().get(j).getLayoutX()+1);
				}
				if(arr_hrzntl_rotate.get(i).getList_shape().get(0).getLayoutX()>=300) {
					hrzntl_mov=false;
				}
			}
//			if(!hrzntl_mov) {
//				(arr_hrzntl_rotate.get(i).getList_shape().get(j)).setLayoutX(arr_hrzntl_rotate.get(i).getList_shape().get(j).getLayoutX()+.5);
//			}
//			else {
//				(arr_hrzntl_rotate.get(i).getList_shape().get(j)).setLayoutX(arr_hrzntl_rotate.get(i).getList_shape().get(j).getLayoutX()-1);
//			}
//			hrzntl_mov=!hrzntl_mov;
//		}
//		for (int j = 0; j < 4; j++) {
//			(arr_hrzntl_rotate.get(i).getList_shape().get(j)).setLayoutX(arr_hrzntl_rotate.get(i).getList_shape().get(j).getLayoutX()-1);
//		}
//		arr_hrzntl_rotate.get(i).setLayoutX(arr_hrzntl_rotate.get(i).getLayoutX()+2);
	}
	if(circle.getLayoutY()<frm_height/2) {
		screen_mover=true;
	}
	else {
		screen_mover=false;
	}
	
	for (int i = 0; i < Obstacles.size(); i++) {
		for (int j = 0; j < Obstacles.get(i).getList_shape().size()-5; j++) {
			Shape shape = Shape.intersect(circle, Obstacles.get(i).getList_shape().get(j));
			boolean intersects = shape.getBoundsInLocal().getWidth() != -1;
			if (intersects) {
				if(circle.getFill()==Obstacles.get(i).getList_shape().get(j).getStroke()) {
					continue;
				}
				else {
//					loop.stop();
				}
//				circle.setFill(Obstacles.get(i).getList_shape().get(j).getStroke());
			}
		}
	}
	
	for (int i = 0; i < Obstacles.size(); i++) {
		Shape newshape = Shape.intersect(circle, Obstacles.get(i).getList_shape().get(Obstacles.get(i).getList_shape().size()-5));
		boolean intersects = newshape.getBoundsInLocal().getWidth() != -1;
		if (intersects) {
			player.setCurr_scr(player.getCurr_scr()+1);
			player.setMax_scr(Math.max(player.getCurr_scr(), player.getMax_scr()));
			player.setTotal_stars(player.getTotal_stars()+1);
			Obstacles.get(i).getList_shape().get(Obstacles.get(i).getList_shape().size()-5).setFill(null);
			Obstacles.get(i).getList_shape().get(Obstacles.get(i).getList_shape().size()-5).setStroke(null);
			scr.setText(Integer.toString(player.getCurr_scr()));
		}
	}
	
	for (int i = 0; i <Obstacles.size(); i++) {
		for (int j =Obstacles.get(i).getList_shape().size()-4 ; j < Obstacles.get(i).getList_shape().size(); j++) {
			Shape newshape = Shape.intersect(circle, Obstacles.get(i).getList_shape().get(j));
			boolean intersects = newshape.getBoundsInLocal().getWidth() != -1;
			if (intersects) {
				circle.setFill(Obstacles.get(i).getList_shape().get(j).getStroke());
				for (int k =Obstacles.get(i).getList_shape().size()-4 ; k < Obstacles.get(i).getList_shape().size(); k++) {
					Obstacles.get(i).getList_shape().get(k).setFill(null);
					Obstacles.get(i).getList_shape().get(k).setStroke(null);
				}
				break;
			}	
		}
	}
	
	
	if (gameup==1) {
		circle.setLayoutY(circle.getLayoutY() -7);
		ball.setYpos(ball.getYpos()-7);
		
		if(screen_mover ) {
			for (int i = 0; i < Obstacles.size(); i++) {
				for (int j = 0; j < Obstacles.get(i).getList_shape().size(); j++) {
					Obstacles.get(i).getList_shape().get(j).setLayoutY(Obstacles.get(i).getList_shape().get(j).getLayoutY()+3);
				}
			}
			frm_height+=3;
		}
	}
	
	else if (gameup==-1) {
		circle.setLayoutY(circle.getLayoutY() +2);
		ball.setYpos(ball.getYpos()+2);
	}
	}

}
