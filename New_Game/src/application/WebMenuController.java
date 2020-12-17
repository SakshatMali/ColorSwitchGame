package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class WebMenuController {
	
	@FXML 
	ImageView home;
	
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
	 
	public void home(MouseEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        tableViewScene.getStylesheets().add(getClass().getResource("big-check-box.css").toExternalForm());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
	}
	 
	@FXML
    void glowImageHome(MouseEvent event) throws IOException {
        Glow glow=new Glow();
        Node source = (Node) event.getSource();
        source.setEffect(glow);
        glow.setLevel(0.4);
        Tooltip tool = new Tooltip("Home");
        tool.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 24));
        Tooltip.install(home, tool);
    }
	 
	 public void insta(MouseEvent event) throws IOException {
	 	Main.webaddress="https://www.instagram.com";
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("Web.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        tableViewScene.getStylesheets().add(getClass().getResource("big-check-box.css").toExternalForm());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
	}
	 
	 public void fb(MouseEvent event) throws IOException {
	 	Main.webaddress="https://www.facebook.com";
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("Web.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        tableViewScene.getStylesheets().add(getClass().getResource("big-check-box.css").toExternalForm());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
	}
}
