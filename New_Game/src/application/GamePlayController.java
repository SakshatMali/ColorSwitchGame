package application;

import java.util.ArrayList;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
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
import java.io.FileNotFoundException;
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
	private int ball_radius=12;
	private int clr_change_radius=13;
	private boolean screen_mover = false;
	private double diff_obst = 450;
	private boolean hrzntl_mov=false;
	private Shape circle;
	private Ball ball;
	private Player player;
	private Image pause;
	private Text scr;
	private DataTable datatable;
	private ArrayList<ShapeObstacle> Obstacles;
	private ArrayList<Circle> explosion_list;
	private int obst1;
	private int obst2;
	private int dir=1;
	private ArrayList<ShapeObstacle> arr_copy_obst;
	private boolean gameover=false;
	private boolean playmusic=false;
	static AudioClip audiopath1 = new AudioClip("file:src/Colour%20Sounds/points.mp3");
	static AudioClip audiopath2 = new AudioClip("file:src/Colour%20Sounds/ballbounce.mp3");
	static AudioClip audiopath3 = new AudioClip("file:src/Colour%20Sounds/Explode.mp3");
	private int lst_cnt = 0;
	Color clr_arr[]= {Color.RED , Color.BLUE , Color.PURPLE , Color.YELLOW};
	private ArrayList<Integer> obst_order = new ArrayList<>();	
	private double ball_x;
	private double ball_y;
	private double obst_y;
	private int star_present;
	private int clr_present;
	private int ball_clr;
	private double speed;
	
	public GamePlayController(Player player, int obst1, int obst2,double ball_x,double ball_y, double obst_y,int star_present,int clr_present, int ball_clr) throws FileNotFoundException {
		super();
		canvas = new Pane();
		this.player = player;
		this.setObst1(obst1);
		this.setObst2(obst2);
		this.ball_x=ball_x;
		this.ball_y=ball_y;
		this.obst_y=obst_y;
		this.star_present = star_present;
		this.clr_present=clr_present;
		this.ball_clr=ball_clr;
		pause = new Image(new FileInputStream("src/Colour Images/Pause.png")); 
		scr = new Text();
	}
	
	public ShapeObstacle check_instance(int ind) {
		ShapeObstacle newobst;
		if (Obstacles.get(ind) instanceof Ring) {
			 newobst = new Ring(Obstacles.get(ind).getHeight(),Obstacles.get(ind).getWidth(),
					Obstacles.get(ind).getXpos(),Obstacles.get(ind).getYpos(),Obstacles.get(ind).get_rotate()); 
		} 
		else if (Obstacles.get(ind) instanceof SquareObstacle) {
			 newobst = new SquareObstacle(Obstacles.get(ind).getHeight(),Obstacles.get(ind).getWidth(),
					Obstacles.get(ind).getXpos(),Obstacles.get(ind).getYpos(),Obstacles.get(ind).get_rotate()); 
		} 
		else if (Obstacles.get(ind) instanceof Plus) {
			 newobst = new Plus(Obstacles.get(ind).getHeight(),Obstacles.get(ind).getWidth(),
					Obstacles.get(ind).getXpos(),Obstacles.get(ind).getYpos(),Obstacles.get(ind).get_rotate()); 
		} 
		else if (Obstacles.get(ind) instanceof LineObstacle) {
			 newobst = new LineObstacle(Obstacles.get(ind).getHeight(),Obstacles.get(ind).getWidth(),
					Obstacles.get(ind).getXpos(),Obstacles.get(ind).getYpos(),Obstacles.get(ind).get_rotate()); 
		} 
		else if (Obstacles.get(ind) instanceof VerticalObstacle) {
			 newobst = new VerticalObstacle(Obstacles.get(ind).getHeight(),Obstacles.get(ind).getWidth(),
					Obstacles.get(ind).getXpos(),Obstacles.get(ind).getYpos(),Obstacles.get(ind).get_rotate()); 
		} 
		else if (Obstacles.get(ind) instanceof DotObstacle) {
			 newobst = new DotObstacle(Obstacles.get(ind).getHeight(),Obstacles.get(ind).getWidth(),
					Obstacles.get(ind).getXpos(),Obstacles.get(ind).getYpos(),Obstacles.get(ind).get_rotate()); 
		} 
		else if (Obstacles.get(ind) instanceof DiagonalObstacle) {
			 newobst = new DiagonalObstacle(Obstacles.get(ind).getHeight(),Obstacles.get(ind).getWidth(),
					Obstacles.get(ind).getXpos(),Obstacles.get(ind).getYpos(),Obstacles.get(ind).get_rotate()); 
		} 
		else if (Obstacles.get(ind) instanceof Two_ring_obst) {
			 newobst = new Two_ring_obst(Obstacles.get(ind).getHeight(),Obstacles.get(ind).getWidth(),
					Obstacles.get(ind).getXpos(),Obstacles.get(ind).getYpos(),Obstacles.get(ind).get_rotate()); 
		} 
		else {
			 newobst = new Rotating_Ring_Obst(Obstacles.get(ind).getHeight(),Obstacles.get(ind).getWidth(),
					Obstacles.get(ind).getXpos(),Obstacles.get(ind).getYpos(),Obstacles.get(ind).get_rotate()); 
		} 
		return newobst;
	}
	
	public void play(MouseEvent event) {
		PlayGame(event);
	}
	
	public void PlayGame(MouseEvent event) {
		try {
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(canvas,frm_width,frm_height);
		canvas.setStyle("-fx-background-color: #000000;");
		primaryStage.setTitle("Byll");
		primaryStage.setScene(scene);
		primaryStage.show();
	    ImageView imageView = new ImageView(pause); 
	    imageView.setX(480);
	    imageView.setY(20);
	    imageView.setFitHeight(100);
	    imageView.setFitWidth(100);
	    
	    imageView.setCursor(Cursor.HAND);
	    imageView.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				Glow glow=new Glow(); 
			    imageView.setEffect(glow);
			    glow.setLevel(0.4);
			}
	    	
	    });
	    
	    imageView.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				Glow glow=new Glow(); 
			    imageView.setEffect(glow);
			    glow.setLevel(0);
			}
	    	
	    });
	 
	    Tooltip tool = new Tooltip("Pause");
	    tool.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 24));
	    Tooltip.install(imageView, tool);
	    scr.setText(Integer.toString(player.getCurr_scr()));
	    scr.setX(50); 
	    scr.setY(80); 
	    scr.setFill(Color.WHITE);
	    scr.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 60));
	    
	    canvas.getChildren().addAll(imageView,scr);
		scene.setFill(Color.BLACK);
		primaryStage.setTitle("Bouncing Ball");
		primaryStage.setScene(scene);
		primaryStage.show();

		Obstacles=new ArrayList<>();
		arr_copy_obst = new ArrayList<>();

	    ShapeObstacle rng=new Ring(100,100,frm_width/2,300,1);  
	    rng.makeShape();
	    rng.makeStar(1);
	    rng.make_Clr_chng(diff_obst,clr_change_radius,1);
	    Obstacles.add(rng);
	    
	    ShapeObstacle sqr_obst=new SquareObstacle(170,170,frm_width/2,Obstacles.get(Obstacles.size()-1).getYpos()-diff_obst,1);
	    sqr_obst.makeShape();
	    sqr_obst.makeStar(1);
	    sqr_obst.make_Clr_chng(diff_obst,clr_change_radius,1);
	    Obstacles.add(sqr_obst);

	    ShapeObstacle plus=new Plus(100,100,frm_width/2,Obstacles.get(Obstacles.size()-1).getYpos()-diff_obst,1); 
	    plus.makeShape();
	    plus.makeStar(1);
	    plus.make_Clr_chng(diff_obst,clr_change_radius,1);
	    Obstacles.add(plus);
	    
	    ShapeObstacle _line=new LineObstacle(0,100,frm_width/2,Obstacles.get(Obstacles.size()-1).getYpos()-diff_obst,0); 
	    _line.makeShape();
	    _line.makeStar(1);
	    _line.make_Clr_chng(diff_obst,clr_change_radius,1);
	    Obstacles.add(_line);
	    
	    ShapeObstacle vert_line=new VerticalObstacle(0,100,frm_width/2,Obstacles.get(Obstacles.size()-1).getYpos()-diff_obst,0); 
	    vert_line.makeShape();
	    vert_line.makeStar(1);
	    vert_line.make_Clr_chng(diff_obst,clr_change_radius,1);
	    Obstacles.add(vert_line);
	    
	    ShapeObstacle dot_obst=new DotObstacle(0,100,frm_width/2,Obstacles.get(Obstacles.size()-1).getYpos()-diff_obst,0); 
	    dot_obst.makeShape();
	    dot_obst.makeStar(1);
	    dot_obst.make_Clr_chng(diff_obst,clr_change_radius,1);
	    Obstacles.add(dot_obst);
	    
	    ShapeObstacle diag_obst=new DiagonalObstacle(0,100,frm_width/2,Obstacles.get(Obstacles.size()-1).getYpos()-diff_obst,0); 
	    diag_obst.makeShape();
	    diag_obst.makeStar(1);
	    diag_obst.make_Clr_chng(diff_obst,clr_change_radius,1);
	    Obstacles.add(diag_obst);
	    
	    ShapeObstacle two_ring_obst=new Two_ring_obst(100,100,frm_width/2,Obstacles.get(Obstacles.size()-1).getYpos()-diff_obst,1); 
	    two_ring_obst.makeShape();
	    two_ring_obst.makeStar(1);
	    two_ring_obst.make_Clr_chng(diff_obst,clr_change_radius,1);
	    Obstacles.add(two_ring_obst);
	    
	    ShapeObstacle rotating_ring_obst=new Rotating_Ring_Obst(130,130,frm_width/2,Obstacles.get(Obstacles.size()-1).getYpos()-diff_obst,1); 
	    rotating_ring_obst.makeShape();
	    rotating_ring_obst.makeStar(1);
	    rotating_ring_obst.make_Clr_chng(diff_obst,clr_change_radius,1);
	    Obstacles.add(rotating_ring_obst);
	    
	    ball=new Ball(ball_x,ball_y,ball_radius,clr_arr[ball_clr]);
		circle=ball.Ball_make(); 
		
	    ShapeObstacle neww1 = check_instance(obst1);
	    ShapeObstacle neww2 = check_instance(obst2);
	    obst_order.add(obst1);
	    obst_order.add(obst2);
	    
	    arr_copy_obst.add(neww1);
	    arr_copy_obst.add(neww2);

	    for (int i = 0; i < 50; i++) {
			Random rd = new Random();
			int p =rd.nextInt(9);
			ShapeObstacle neww = check_instance(p);
			arr_copy_obst.add(neww);
			obst_order.add(p);
		}
	    
        ArrayList<Rotate> arr_rotate=new ArrayList<>();
        ArrayList<ShapeObstacle> arr_hrzntl_rotate=new ArrayList<>();
        explosion_list = new ArrayList<>();
        
        for (int i = 0; i < arr_copy_obst.size(); i++) {
        	Star star = new Star();
        	star.setObstacle(arr_copy_obst.get(i));
        	ColorChange clr_chng = new ColorChange();
        	clr_chng.setObstacle(arr_copy_obst.get(i));
        	if (i==0) {
        		arr_copy_obst.get(0).setYpos(obst_y);
        		arr_copy_obst.get(i).makeShape();
        		star._makeStar(star_present);
        		clr_chng.make_Clr_chng(diff_obst,clr_change_radius,clr_present);
        	} 
        	
        	else {
        		arr_copy_obst.get(i).setYpos(arr_copy_obst.get(i-1).getYpos()-diff_obst);
        	}
        	
        	if(i>=1)arr_copy_obst.get(i).makeShape();
        	if(i>=1)star._makeStar(1);
        	if(i>=1)clr_chng.make_Clr_chng(diff_obst,clr_change_radius,1);
        	if(arr_copy_obst.get(i).get_rotate()==1) {
    			Rotate rotate1=arr_copy_obst.get(i).makeRotate(arr_copy_obst.get(i).getList_shape());
	 	        arr_rotate.add(rotate1);
    		}
    		else {
	 	        arr_hrzntl_rotate.add(arr_copy_obst.get(i));	
    		}
 	        
    		Rotate rotate2=arr_copy_obst.get(i).makeRotate_Clr_chng(arr_copy_obst.get(i).getList_shape(),diff_obst);
 	        arr_rotate.add(rotate2);
 	        canvas.getChildren().addAll(arr_copy_obst.get(i).getList_shape());
 	        
		}
        
        canvas.getChildren().add(circle);
        loop = new Timeline(new KeyFrame(Duration.millis(9), e -> run(arr_copy_obst,arr_rotate,arr_hrzntl_rotate,scene,imageView)));
        
        imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
        	
            @Override
            public void handle(MouseEvent event) {
            	datatable=new DataTable(player.getCurr_scr(),player.getMax_scr(),player.getTotal_stars(),obst1,obst2,circle.getLayoutX(),circle.getLayoutY(),obst_y,star_present,clr_present,ball_clr);
            	DataTable dt = new DataTable(0,0,0,0,0,0,0,0,0,0,0);
            	DataTable temp = new DataTable(0,0,0,0,0,0,0,0,0,0,0); 
         	
            	try {
            		temp = dt.deserialize_max_scr();
            		int temp_max = Math.max(player.getCurr_scr(), temp.getMax_scr());
            		int total_str = temp.getTotal_stars() + player.getCurr_scr();
            		dt.setMax_scr(temp_max);
            		dt.setCurr_scr(player.getCurr_scr());
            		dt.setTotal_stars(total_str);
            		dt.setNum_obst1(obst1);
            		dt.setNum_obst2(obst2);
            		dt.serialize_max_scr();
            	}
            	catch(Exception e) {
            		dt.serialize_max_scr();
            		temp = dt.deserialize_max_scr();
            		int temp_max = Math.max(player.getCurr_scr(), temp.getMax_scr());
            		int total_str = temp.getTotal_stars() + player.getCurr_scr();
            		dt.setMax_scr(temp_max);
            		dt.setCurr_scr(player.getCurr_scr());
            		dt.setTotal_stars(total_str);
            		dt.setNum_obst1(obst1);
            		dt.setNum_obst2(obst2);
            		dt.serialize_max_scr();
            	}
        	
            	 FXMLLoader loader = new FXMLLoader(getClass().getResource("PauseDialogBox.fxml"));
            	 Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            	 try {
					window.setScene(new Scene(loader.load()));
				} catch (IOException e) {
					e.printStackTrace();
				}
            	 PauseDialogBoxController controller = loader.getController();
            	  controller.initData(datatable,scene,loop);
            	  window.show();
            	  loop.pause();
            }
       });
        
        
        loop.setCycleCount(Timeline.INDEFINITE); 
        loop.play();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void run(ArrayList<ShapeObstacle> Obstacles ,ArrayList<Rotate> arr_rotate,ArrayList<ShapeObstacle> arr_hrzntl_rotate,Scene scene, ImageView imageView) {

		if (gameover) {

			if (playmusic) {
				audiopath3.setVolume(0.3);
				if (SettingMenuController.soundcheck) {
		        audiopath3.play();
				}
		        playmusic=false;
				
			}
				explosion_list.get(0).setLayoutX(explosion_list.get(0).getLayoutX()+(2*dir));
				explosion_list.get(0).setLayoutY(explosion_list.get(0).getLayoutY()-2);
				
				explosion_list.get(1).setLayoutX(explosion_list.get(1).getLayoutX()-(2*dir));
				explosion_list.get(1).setLayoutY(explosion_list.get(1).getLayoutY()-2);
				
				explosion_list.get(2).setLayoutX(explosion_list.get(2).getLayoutX()-(2*dir));
				explosion_list.get(2).setLayoutY(explosion_list.get(2).getLayoutY()+0.5);
				
				explosion_list.get(3).setLayoutX(explosion_list.get(3).getLayoutX()+(2*dir));
				explosion_list.get(3).setLayoutY(explosion_list.get(3).getLayoutY()+0.5);
				
				explosion_list.get(4).setLayoutX(explosion_list.get(4).getLayoutX()+(2*dir));
				explosion_list.get(4).setLayoutY(explosion_list.get(4).getLayoutY()-1);
				
				explosion_list.get(5).setLayoutX(explosion_list.get(5).getLayoutX()-(2*dir));
				explosion_list.get(5).setLayoutY(explosion_list.get(5).getLayoutY()-1);
				
				explosion_list.get(6).setLayoutX(explosion_list.get(6).getLayoutX()-(2*dir));
				explosion_list.get(6).setLayoutY(explosion_list.get(6).getLayoutY()+2.5);
				
				explosion_list.get(7).setLayoutX(explosion_list.get(7).getLayoutX()+(2*dir));
				explosion_list.get(7).setLayoutY(explosion_list.get(7).getLayoutY()+1);
				
				explosion_list.get(8).setLayoutX(explosion_list.get(8).getLayoutX()+(2*dir));
				explosion_list.get(8).setLayoutY(explosion_list.get(8).getLayoutY()-3);
				
				explosion_list.get(9).setLayoutX(explosion_list.get(9).getLayoutX()-(2*dir));
				explosion_list.get(9).setLayoutY(explosion_list.get(9).getLayoutY()-2.5);
				
				explosion_list.get(10).setLayoutX(explosion_list.get(10).getLayoutX()-(2*dir));
				explosion_list.get(10).setLayoutY(explosion_list.get(10).getLayoutY()+1);
				
				explosion_list.get(11).setLayoutX(explosion_list.get(11).getLayoutX()+(2*dir));
				explosion_list.get(11).setLayoutY(explosion_list.get(11).getLayoutY()+2);
				
				explosion_list.get(12).setLayoutX(explosion_list.get(12).getLayoutX()+(2*dir));
				explosion_list.get(12).setLayoutY(explosion_list.get(12).getLayoutY()-2.5);
				
				explosion_list.get(13).setLayoutX(explosion_list.get(13).getLayoutX()-(2*dir));
				explosion_list.get(13).setLayoutY(explosion_list.get(13).getLayoutY()-1);
				
				explosion_list.get(14).setLayoutX(explosion_list.get(14).getLayoutX()-(2*dir));
				explosion_list.get(14).setLayoutY(explosion_list.get(14).getLayoutY()+1);
				
				explosion_list.get(15).setLayoutX(explosion_list.get(15).getLayoutX()+(2*dir));
				explosion_list.get(15).setLayoutY(explosion_list.get(15).getLayoutY()+3);
				
				
				if (explosion_list.get(0).getLayoutX()>600 || explosion_list.get(0).getLayoutX()<0) {
					dir = dir*(-1);
				}
				
				if(lst_cnt == 0) {
		          	DataTable dt = new DataTable(0,0,0,0,0,0,0,0,0,0,0);
	            	DataTable temp = new DataTable(0,0,0,0,0,0,0,0,0,0,0); 
	         	
	            	try {
	            		temp = dt.deserialize_max_scr();
	            		int temp_max = Math.max(player.getCurr_scr(), temp.getMax_scr());
	            		int total_str = temp.getTotal_stars() + player.getCurr_scr();
	            		dt.setMax_scr(temp_max);
	            		dt.setCurr_scr(player.getCurr_scr());
	            		dt.setTotal_stars(total_str);
	            		dt.setNum_obst1(obst1);
	            		dt.setNum_obst2(obst2);
	            		dt.serialize_max_scr();
	            	}
	            	
	            	catch(Exception e) {
	            		dt.serialize_max_scr();
	            		temp = dt.deserialize_max_scr();
	            		int temp_max = Math.max(player.getCurr_scr(), temp.getMax_scr());
	            		int total_str = temp.getTotal_stars() + player.getCurr_scr();
	            		dt.setMax_scr(temp_max);
	            		dt.setCurr_scr(player.getCurr_scr());
	            		dt.setTotal_stars(total_str);
	            		dt.setNum_obst1(obst1);
	            		dt.setNum_obst2(obst2);
	            		dt.serialize_max_scr();
	            	}
	            	
	            	lst_cnt=1;
				}
				
				for (int i = 0; i < explosion_list.size(); i++) {
					if (explosion_list.get(i).getLayoutY()>1500) {
						Parent tableViewParent = null;
						try {
							tableViewParent = FXMLLoader.load(getClass().getResource("GameOverBox.fxml"));
						} catch (IOException e) {
							e.printStackTrace();
						}
				        Scene tableViewScene = new Scene(tableViewParent);
				        tableViewScene.setFill(Color.BLACK);
				        Stage window = (Stage)circle.getScene().getWindow();
				        tableViewParent.setStyle("-fx-background-color: #000000;");
				        window.setScene(tableViewScene);
				        window.show();
		            	loop.pause();
		            	break;
					}
		
				}
			}
		
		else {
		
			int cnt=0;
			for (int i = 0; i <obst_order.size(); i++) {
				if(Obstacles.get(i).getYpos() - (Obstacles.get(i).getHeight()/2)<=750){
					cnt++;
					if(cnt==1) {
						obst1 = obst_order.get(i);
						obst_y = Obstacles.get(i).getYpos();
						if(Obstacles.get(i).getList_shape().get(Obstacles.get(i).getList_shape().size()-5).getFill()==null) {
							star_present=0;
						}
						else {
							star_present=1;
						}
						if(Obstacles.get(i).getList_shape().get(Obstacles.get(i).getList_shape().size()-4).getFill()==null) {
							clr_present=0;
						}
						else {
							clr_present=1;
						}
					}
					if(cnt==2) {
						obst2 = obst_order.get(i);
						break;
					}
				}
			}
			
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

				if ( circle.getLayoutY() >= 750 + 20 ) {
					gameover=true;
					playmusic=true;
					circle.setStroke(null);
					circle.setFill(null);
					
					 for (int k = 0; k < 16; k++) {
						 
						 ExplosionBalls eball=null;
						 
						 if (k%2==0) {
							 eball = new ExplosionBalls(circle.getLayoutX(),circle.getLayoutY(),5,clr_arr[k%4]);
						 } 
						 
						 else {
							eball = new ExplosionBalls(circle.getLayoutX(),circle.getLayoutY(),7,clr_arr[k%4]);
						 }
							Circle exball = eball.Ball_make();
							explosion_list.add(exball);
							canvas.getChildren().add(exball);
					}
				}
				
			for (int i = 0; i < arr_rotate.size(); i++) {
				arr_rotate.get(i).setAngle(arr_rotate.get(i).getAngle()+0.7+speed);
			}
			
			for (int i = 0; i < arr_hrzntl_rotate.size(); i++) {
					if(arr_hrzntl_rotate.get(i).getList_shape().get(0).getLayoutX()>=-300 && hrzntl_mov==false){
						for (int j = 0; j < arr_hrzntl_rotate.get(i).getList_shape().size()-5; j++) {
							(arr_hrzntl_rotate.get(i).getList_shape().get(j)).setLayoutX(arr_hrzntl_rotate.get(i).getList_shape().get(j).getLayoutX()-2);
						}
						
						if(arr_hrzntl_rotate.get(i).getList_shape().get(0).getLayoutX()==-300)hrzntl_mov=true;
						
					}
					
					else if(hrzntl_mov==true){
						for (int j = 0; j < arr_hrzntl_rotate.get(i).getList_shape().size()-5; j++) {
							(arr_hrzntl_rotate.get(i).getList_shape().get(j)).setLayoutX(arr_hrzntl_rotate.get(i).getList_shape().get(j).getLayoutX()+2);
						}
						
						if(arr_hrzntl_rotate.get(i).getList_shape().get(0).getLayoutX()>=300) {
							hrzntl_mov=false;
						}
					}
			}
			
			for (int i = 0; i < Obstacles.size(); i++) {
				if(Obstacles.get(i).getYpos()<=-750 || Obstacles.get(i).getYpos()>=750){
					continue;
				}
				for (int j = 0; j < Obstacles.get(i).getList_shape().size()-5; j++) {
					Shape shape = Shape.intersect(circle, Obstacles.get(i).getList_shape().get(j));
					boolean intersects = shape.getBoundsInLocal().getWidth() != -1;     //changed to parent
					if (intersects) {
						if(circle.getFill()==Obstacles.get(i).getList_shape().get(j).getStroke()) {
							continue;
						}
						
						else {
							gameover=true;
							playmusic=true;
							circle.setStroke(null);
							circle.setFill(null);
							
							 for (int k = 0; k < 16; k++) {
								 
								 ExplosionBalls eball=null;
								 
								 if (k%2==0) {
									 eball = new ExplosionBalls(circle.getLayoutX(),circle.getLayoutY(),5,clr_arr[k%4]);
								 } 
								 
								 else {
									eball = new ExplosionBalls(circle.getLayoutX(),circle.getLayoutY(),7,clr_arr[k%4]);
								 }
									Circle exball = eball.Ball_make();
									explosion_list.add(exball);
									canvas.getChildren().add(exball);
							}
						}
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
					audiopath1.setVolume(0.5);
					if(player.getCurr_scr()%2==0)speed+=0.2;
					if (SettingMenuController.soundcheck) {
				        audiopath1.play();
					}
				}
			}

			for (int i = 0; i <Obstacles.size(); i++) {
				if(Obstacles.get(i).getYpos()<=-750 || Obstacles.get(i).getYpos()>=750){
					continue;
				}
				
				for (int j =Obstacles.get(i).getList_shape().size()-4 ; j < Obstacles.get(i).getList_shape().size(); j++) {
					Shape newshape = Shape.intersect(circle, Obstacles.get(i).getList_shape().get(j));
					boolean intersects = newshape.getBoundsInLocal().getWidth() != -1;
					if (intersects) {
						audiopath2.setVolume(1);
						if (SettingMenuController.soundcheck) {
					        audiopath2.play();
							}
						
						circle.setFill(Obstacles.get(i).getList_shape().get(j).getStroke());
						for (int l = 0; l < clr_arr.length; l++) {
							if(circle.getFill()==clr_arr[l]) {
								ball_clr=l;
							}
						}
						
						for (int k =Obstacles.get(i).getList_shape().size()-4 ; k < Obstacles.get(i).getList_shape().size(); k++) {
							Obstacles.get(i).getList_shape().get(k).setFill(null);
							Obstacles.get(i).getList_shape().get(k).setStroke(null);
						}
						break;
					}	
				}
			}
			
			if(circle.getLayoutY() <= frm_height/1.5) {
				screen_mover=true;
			}
			else {
				screen_mover=false;
			}
	
			if (gameup==1) {
				
				circle.setLayoutY(circle.getLayoutY() -7);
				ball.setYpos(ball.getYpos()-7);
				if(screen_mover ) {
					for (int i = 0; i < Obstacles.size(); i++) {
						Obstacles.get(i).setYpos(Obstacles.get(i).getYpos()+5);
						for (int j = 0; j < Obstacles.get(i).getList_shape().size(); j++) {
							Obstacles.get(i).getList_shape().get(j).setLayoutY(Obstacles.get(i).getList_shape().get(j).getLayoutY()+5);
						}
					}
				}
			}
			
			else if (gameup==-1) {
//				circle.setLayoutY(circle.getLayoutY() +2*(1.0*(player.getCurr_scr()+5)/8));
//				ball.setYpos(ball.getYpos()+2*(1.0*(player.getCurr_scr()+5)/8));
				circle.setLayoutY(circle.getLayoutY() +1.4);
				ball.setYpos(ball.getYpos()+1.4);
			}
		
		}
	}


	public int getObst1() {
		return obst1;
	}
	
	public void setObst1(int obst1) {
		this.obst1 = obst1;
	}

	
	public int getObst2() {
		return obst2;

	}
	
	public void setObst2(int obst2) {
		this.obst2 = obst2;
	}
	
	public ArrayList<ShapeObstacle> getArr_copy_obst() {
		return arr_copy_obst;
	}
	
	public void setArr_copy_obst(ArrayList<ShapeObstacle> arr_copy_obst) {
		this.arr_copy_obst = arr_copy_obst;
	}

	public int getStar_present() {
		return star_present;
	}

	public void setStar_present(int star_present) {
		this.star_present = star_present;
	}

	public int getClr_present() {
		return clr_present;
	}

	public void setClr_present(int clr_present) {
		this.clr_present = clr_present;
	}

}
