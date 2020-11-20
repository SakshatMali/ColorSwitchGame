package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PauseDialogBoxController {
	
	public void resume(ActionEvent event) throws IOException {
		
	}
	
	public void restart(ActionEvent event) throws IOException {
//		 	Parent tableViewParent = FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
//	        Scene tableViewScene = new Scene(tableViewParent);
//	        tableViewScene.setFill(Color.BLACK);
//	        
//	        //This line gets the Stage information
//	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//	        tableViewParent.setStyle("-fx-background-color: #000000;");
//	        window.setScene(tableViewScene);
//	        window.show();
		GamePlayController gc = new GamePlayController();
		gc.play(event);
	}
	
	public void save(ActionEvent event) throws IOException {
		
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
	
	
}
