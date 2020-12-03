package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PauseDialogBoxController implements Serializable, Initializable{
//	private Pane canvas;
//	private Timeline loop;
//	Ball ball;
//	Player player;
//	private Image pause;
//	private Text scr;
	private DataTable datatable;
	private static final long serialVersionUID = 11L;
//	private int save_count = deserialize();
	private int save_count = deserialize_savecount();
	
//	private ArrayList<ShapeObstacle> Obstacles;

//	void initData(Pane canvas, Timeline loop, Ball ball, Player player, Image pause, Text scr,DataTable datatable,ArrayList<ShapeObstacle> obstacles) {	
//		this.canvas = canvas;
//		this.loop = loop;
//		this.ball = ball;
//		this.player = player;
//		this.pause = pause;
//		this.scr = scr;
//		this.datatable = datatable;
//		Obstacles = obstacles;
//	}
	
	
    @FXML
    private transient ImageView resume;

    @FXML
    private transient ImageView restart;

    @FXML
    private transient ImageView save;

    @FXML
    private transient ImageView save_exit;

    @FXML
    private transient ImageView home;
	
	
	void initData(DataTable datatable) {
		this.datatable=datatable;
//		save_count=deserialize_savecount();
//		System.out.println((save_count+1)+" my bad");
//		save_count++;
////		setSave_count(save_count+1);
//		serialize_savecount();
		
		SaveController.setSave_counter(save_count);
		
//		System.out.println("init Pause dialog  "+datatable.getNum_obst1()+" "+datatable.getNum_obst2());
		datatable.serialize_resume();
	}
	public void resume(MouseEvent event) throws IOException {
		Player p1 = new Player(datatable.getCurr_scr(),datatable.getMax_scr(),datatable.getTotal_stars());
		GamePlayController gc = new GamePlayController(p1,datatable.getNum_obst1(), datatable.getNum_obst2());
		gc.play(event);
	}
	public void restart(MouseEvent event) throws IOException {
//		 	Parent tableViewParent = FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
//	        Scene tableViewScene = new Scene(tableViewParent);
//	        tableViewScene.setFill(Color.BLACK);
//	        
//	        //This line gets the Stage information
//	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//	        tableViewParent.setStyle("-fx-background-color: #000000;");
//	        window.setScene(tableViewScene);
//	        window.show();
//		datatable.serialize();
//		datatable.deserialize();
		
//		GamePlayController gc = new GamePlayController(canvas,loop,ball,player,pause,scr,datatable,Obstacles);
		Player p1 = new Player(0,0,0);
		GamePlayController gc = new GamePlayController(p1,0,1);
		gc.play(event);
	}
	
	public void save(MouseEvent event) throws IOException {
		save_count=deserialize_savecount();
//		SaveController.setSave_counter(save_count);
//		System.out.println((save_count+1)+" my bad");
//		save_count++;
//		setSave_count(save_count+1);
//		serialize_savecount();
		
		datatable.serialize();
		save_count++;
		serialize_savecount();
//		datatable.deserialize();
		
		
//		datatable.deserialize();
	}
	
	public void save_exit(MouseEvent event) throws IOException {
		save_count=deserialize_savecount();
		datatable.serialize();
		save_count++;
		serialize_savecount();
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
	}

	public void home(MouseEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
//        tableViewScene.setFill(Color.BLACK);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        tableViewParent.setStyle("-fx-background-color: #000000;");
        window.setScene(tableViewScene);
        window.show();
	}
	
	public void serialize_savecount() {
		  try{    
	            FileOutputStream file = new FileOutputStream("Save_Count.txt"); 
	            ObjectOutputStream out = new ObjectOutputStream(file); 
	            
	            out.writeObject(this); 
	            out.close(); 
	            file.close();  
//	            System.out.println("ok kkkkkkkkkkkkk");
	            System.out.println("Pause Object has been serialized");
	        } 
	        catch(IOException ex) { 
	            System.out.println("IOException is caught"); 
	        } 
	}
	public int deserialize_savecount() {
		int temp_save_count;
		 try{    
	            // Reading the object from a file 
			 	PauseDialogBoxController savetable=null;
	            FileInputStream file = new FileInputStream("Save_Count.txt"); 
	            ObjectInputStream in = new ObjectInputStream(file); 
	            savetable = (PauseDialogBoxController)in.readObject(); 
	              
	            in.close(); 
	            file.close(); 
	              
	            System.out.println("Pause Object has been deserialized "); 
	            System.out.println("Save Count hu= " + savetable.getSave_count());
	            temp_save_count = savetable.getSave_count();
	            
//	            save_count++;
//	            serialize_savecount();
	            
//	            setSave_coun:t(getSave_count() + 1);
//	            savetable.setSave_count(savetable.getSave_count()+1);
	        } 
	          
	        catch(IOException ex) { 
//	        	System.out.println("am i here");
	        	serialize_savecount();
	            System.out.println("IOException is caught"); 
	            temp_save_count = -1;
	        } 
	        catch(ClassNotFoundException ex) { 
	            System.out.println("ClassNotFoundException is caught");
	            temp_save_count = -1;
	        }
		 
		 return temp_save_count;
	}	
	

	
	
	@FXML
    void glowImage(MouseEvent event) throws IOException {
//		System.out.println("On Image");
        Glow glow=new Glow();
        Node source = (Node) event.getSource();
        source.setEffect(glow);
        glow.setLevel(0.4);
    }
	
	 @FXML
	    void stopGlowing(MouseEvent event) throws IOException{
//		 System.out.println("Out Image");
	        Node source= (Node) event.getSource();
	        Glow glow=(Glow) source.getEffect();
	        source.setEffect(glow);
	        glow.setLevel(0.0);
	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ArrayList<ImageView> img_list = new ArrayList<ImageView>();
		ArrayList<String> name_list = new ArrayList<String>();
		
		img_list.add(resume) ; name_list.add("Resume Game");
		img_list.add(restart) ; name_list.add("Restart Game");
		img_list.add(save) ; name_list.add("Save Game");
		img_list.add(save_exit) ; name_list.add("Save & Exit Game");
		img_list.add(home) ; name_list.add("Home");
//		img_list.add(help) ; name_list.add("Help");
//		img_list.add(reward) ; name_list.add("Rewards");
//		img_list.add(exit) ; name_list.add("Exit Game");
//		
		for (int i = 0; i < img_list.size(); i++) {
			 	Tooltip tool = new Tooltip(name_list.get(i));
		        tool.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 24));
		        Tooltip.install(img_list.get(i), tool);
		}
	}
	
	public int getSave_count() {
		
		return save_count;
	}
	public void setSave_count(int save_count) {
		this.save_count = save_count;
	}
	
}
