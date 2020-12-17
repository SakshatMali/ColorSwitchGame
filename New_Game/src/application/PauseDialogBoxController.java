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

public class PauseDialogBoxController implements Serializable, Initializable {
	
	private DataTable datatable;
	private static final long serialVersionUID = 11L;
	private int save_count = deserialize_savecount();
	private transient Scene scene;
	private transient Timeline loop;
	private int frm_width = 600;
	private int frm_height = 750;
	
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
	
	
	void initData(DataTable datatable,Scene scene, Timeline loop) {
		this.datatable=datatable;
		this.scene=scene;
		this.loop=loop;
		SaveController.setSave_counter(save_count);
		datatable.serialize_resume();
	}
	
	public void resume(MouseEvent event) throws IOException {
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		loop.play();
	}
	
	public void restart(MouseEvent event) throws IOException {
		Player p1 = new Player(0,0,0);
		GamePlayController gc = new GamePlayController(p1,0,1,frm_width/2,frm_height-150,300,1,1,1);
		gc.play(event);
	}
	
	public void save(MouseEvent event) throws IOException {
		save_count=deserialize_savecount();
		datatable.serialize();
		save_count++;
		serialize_savecount();
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
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
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
//	            System.out.println("Pause Object has been serialized");
	        } 
	        catch(IOException ex) { 
//	            System.out.println("IOException is caught"); 
	        } 
	}
	public int deserialize_savecount() {
		int temp_save_count;
		 try{    
			 	PauseDialogBoxController savetable=null;
	            FileInputStream file = new FileInputStream("Save_Count.txt"); 
	            ObjectInputStream in = new ObjectInputStream(file); 
	            savetable = (PauseDialogBoxController)in.readObject(); 
	              
	            in.close(); 
	            file.close(); 
	              
//	            System.out.println("Pause Object has been deserialized "); 
	            temp_save_count = savetable.getSave_count();
	        } 
	          
	        catch(IOException ex) { 
	        	serialize_savecount();
//	            System.out.println("IOException is caught"); 
	            temp_save_count = -1;
	        } 
	        catch(ClassNotFoundException ex) { 
//	            System.out.println("ClassNotFoundException is caught");
	            temp_save_count = -1;
	        }
		 
		 return temp_save_count;
	}	
	
	@FXML
    void glowImage(MouseEvent event) throws IOException {
        Glow glow=new Glow();
        Node source = (Node) event.getSource();
        source.setEffect(glow);
        glow.setLevel(0.4);
    }
	
	@FXML
    void stopGlowing(MouseEvent event) throws IOException{
        Node source= (Node) event.getSource();
        Glow glow=(Glow) source.getEffect();
        source.setEffect(glow);
        glow.setLevel(0.0);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<ImageView> img_list = new ArrayList<ImageView>();
		ArrayList<String> name_list = new ArrayList<String>();
		
		img_list.add(resume) ; name_list.add("Resume Game");
		img_list.add(restart) ; name_list.add("Restart Game");
		img_list.add(save) ; name_list.add("Save Game");
		img_list.add(save_exit) ; name_list.add("Save & Exit Game");
		img_list.add(home) ; name_list.add("Home");
		
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
