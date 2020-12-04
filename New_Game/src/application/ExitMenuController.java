package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ExitMenuController {
	
	
	public void back(MouseEvent event) throws IOException {
		
		 Parent tableViewParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        tableViewScene.setFill(Color.BLACK);
	        
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        tableViewParent.setStyle("-fx-background-color: #000000;");
	        window.setScene(tableViewScene);
	        window.show();
	}
	
	public void exit(MouseEvent event) throws IOException {
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.close();
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

}
