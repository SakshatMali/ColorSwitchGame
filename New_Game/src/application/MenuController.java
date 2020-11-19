package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuController {

	
	public void StartGame(ActionEvent event) throws IOException {
//		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
//		 AnchorPane pane=fxmlLoader.load();
//		mainRoot.getChildren().setAll(pane);
		
		 Parent tableViewParent = FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        tableViewScene.setFill(Color.BLACK);
	        
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        tableViewParent.setStyle("-fx-background-color: #000000;");
	        window.setScene(tableViewScene);
	        window.show();
	}
}
