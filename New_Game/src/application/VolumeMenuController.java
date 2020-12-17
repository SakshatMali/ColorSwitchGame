package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class VolumeMenuController implements Initializable  {
	
		@FXML
	    private ImageView home;
	    
	    @FXML
	    private Slider slider;
	    
	    
	    public void home(MouseEvent event) throws IOException {
			Parent tableViewParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        window.setScene(tableViewScene);
	        window.show();
		}
	    
	    
	    @FXML
	    void glowImage(MouseEvent event) throws IOException {
	        Glow glow=new Glow();
	        Node source = (Node) event.getSource();
	        source.setEffect(glow);
	        glow.setLevel(0.4);
	        
	        Tooltip tool = new Tooltip("Home");
	        tool.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 24));
	        Tooltip.install(home, tool);
	    }
		
	    @FXML
	    void stopGlowing(MouseEvent event) throws IOException{
	        Node source= (Node) event.getSource();
	        Glow glow=(Glow) source.getEffect();
	        source.setEffect(glow);
	        glow.setLevel(0.0);
	    }
		 
		 public void volumeChange(MouseEvent event) {
			Main.audioPath.stop();
			Main.audioPath.setVolume(slider.getValue()/100);
			Main.audioPath.setCycleCount(AudioClip.INDEFINITE);
	        Main.audioPath.play();
	        Main.slidervalue=slider.getValue();
	        
	        if (slider.getValue()>0) {
	        	Main.playmusicsetting=true;
	        }
	        else {
	        	Main.playmusicsetting=false;
	        }
	        
		 }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			slider.setValue(Main.slidervalue);
		}
}
