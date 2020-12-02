package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SettingMenuController implements Initializable {
	
@FXML ImageView home;
@FXML CheckBox music;
	
	public void home(MouseEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        tableViewScene.getStylesheets().add(getClass().getResource("big-check-box.css").toExternalForm());
//        tableViewScene.setFill(Color.BLACK);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        tableViewParent.setStyle("-fx-background-color: #000000;");
        window.setScene(tableViewScene);
        window.show();
	}
	
	@FXML
    void glowImage(MouseEvent event) throws IOException {
//		System.out.println("On Image");
        Glow glow=new Glow();
        Node source = (Node) event.getSource();
        source.setEffect(glow);
        glow.setLevel(0.4);
        Tooltip tool = new Tooltip("Home");
        tool.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 24));
        Tooltip.install(home, tool);
    }
	
	 @FXML
	    void stopGlowing(MouseEvent event) throws IOException {
//		 System.out.println("Out Image");
	        Node source= (Node) event.getSource();
	        Glow glow=(Glow) source.getEffect();
	        source.setEffect(glow);
	        glow.setLevel(0.0);
	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
//		music.setStyle("-fx-padding: 5em 5em 6em 6em;");
//		music.getStyleClass().add("big-check-box");
		
	}

	
	public void playmusic(ActionEvent event) {
		if (music.isSelected()) {
			Main.audioPath.play();
		} else {
			Main.audioPath.stop();
		}
	}
}
