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
	DataTable datatable;
	private static final long serialVersionUID = 11L;
//	private int save_count = deserialize();
	private static int save_count;
	
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
    private ImageView resume;

    @FXML
    private ImageView restart;

    @FXML
    private ImageView save;

    @FXML
    private ImageView save_exit;

    @FXML
    private ImageView home;
	
	
	void initData(DataTable datatable) {
		this.datatable=datatable;
		SaveController.setSave_counter(save_count);
//		System.out.println("init Pause dialog  "+datatable.getCurr_scr());
	}
	public void resume(MouseEvent event) throws IOException {
		Player p1 = new Player(0,0,0);
		GamePlayController gc = new GamePlayController(p1,4,5);
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
		datatable.deserialize();
		
//		GamePlayController gc = new GamePlayController(canvas,loop,ball,player,pause,scr,datatable,Obstacles);
		Player p1 = new Player(0,0,0);
		GamePlayController gc = new GamePlayController(p1,4,5);
		gc.play(event);
	}
	
	public void save(ActionEvent event) throws IOException {
		save_count=deserialize_savecount();
//		int des = 
//		setSave_count(getSave_count() + 1);
		
		serialize_savecount();
		
		datatable.serialize();
		datatable.deserialize();
		
		
//		datatable.deserialize();
	}
	
	public void save_exit(ActionEvent event) throws IOException {
		
	}

	public void home(ActionEvent event) throws IOException {
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
	            System.out.println("Object has been serialized");
	        } 
	        catch(IOException ex) { 
	            System.out.println("IOException is caught"); 
	        } 
	}
	public int deserialize_savecount() {
		 try{    
	            // Reading the object from a file 
			 	PauseDialogBoxController savetable=null;
	            FileInputStream file = new FileInputStream("Save_Count.txt"); 
	            ObjectInputStream in = new ObjectInputStream(file); 
	            savetable = (PauseDialogBoxController)in.readObject(); 
	              
	            in.close(); 
	            file.close(); 
	              
	            System.out.println("Object has been deserialized "); 
	            System.out.println("Save Count = " + savetable.getSave_count());
	            save_count = savetable.getSave_count();
	            
	            save_count++;
	            serialize_savecount();
	            
//	            setSave_coun:t(getSave_count() + 1);
//	            savetable.setSave_count(savetable.getSave_count()+1);
	        } 
	          
	        catch(IOException ex) { 
	            System.out.println("IOException is caught"); 
	        } 
	        catch(ClassNotFoundException ex) { 
	            System.out.println("ClassNotFoundException is caught"); 
	        }
		 
		 return save_count;
	}
	
	
	
	
//	public void serialize_file() {
//		  try{    
//	            FileOutputStream file = new FileOutputStream("Save_Count"+(save_count%7)+".txt"); 
//	            ObjectOutputStream out = new ObjectOutputStream(file);  
//	            out.writeObject(datatable); 
//	            out.close(); 
//	            file.close();  
//	            System.out.println("Object has been serialized");
//	        } 
//	        catch(IOException ex) { 
//	            System.out.println("IOException is caught"); 
//	        } 
//	}
//	public int deserialize_file() {
//		 try{    
//	            // Reading the object from a file 
//			 	DataTable savetable=null;
//	            FileInputStream file = new FileInputStream("Save_Count"+(save_count%7)+".txt"); 
//	            ObjectInputStream in = new ObjectInputStream(file); 
//	            savetable = (DataTable)in.readObject(); 
//	              
//	            in.close(); 
//	            file.close(); 
//	              
//	            System.out.println("Object has been deserialized "); 
//	            System.out.println("Save Count = " + savetable.);
////	            save_count = savetable.getSave_count();
////	            
////	            save_count++;
////	            serialize_file();
//	            
////	            setSave_coun:t(getSave_count() + 1);
////	            savetable.setSave_count(savetable.getSave_count()+1);
//	        } 
//	          
//	        catch(IOException ex) { 
//	            System.out.println("IOException is caught"); 
//	        } 
//	        catch(ClassNotFoundException ex) { 
//	            System.out.println("ClassNotFoundException is caught"); 
//	        }
//		 
//		 return save_count;
//	}
	
	
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
	
	
	public static int getSave_count() {
		return save_count;
	}
	public void setSave_count(int save_count) {
		this.save_count = save_count;
	}
	
}
