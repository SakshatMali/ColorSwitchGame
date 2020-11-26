package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuController implements Serializable {
	
	/**
	 * 
	 */
	@FXML
	private AnchorPane mainRoot;
	
	
	
//	private static final long serialVersionUID = 11L;
//	private int save_count=0;
	DataTable dt;
	
	
	public void StartGame(ActionEvent event) throws IOException {
//		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
//		 AnchorPane pane=fxmlLoader.load();
//		mainRoot.getChildren().setAll(pane);
//		GamePlayController gc=new GamePlayController();
//		gc.play(event);

//		 Parent tableViewParent = FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
//	        Scene tableViewScene = new Scene(tableViewParent);
//	        tableViewScene.setFill(Color.BLACK);
//	        
//	        //This line gets the Stage information
//	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//	        tableViewParent.setStyle("-fx-background-color: #000000;");
//	        window.setScene(tableViewScene);
//	        window.show();
//		dt=dt.deserialize();			//doubt
		Player p1 = new Player(0, 0,0);
		GamePlayController gc = new GamePlayController(p1,4,5);
		gc.play(event);

	}
	
	public void help(ActionEvent event) throws IOException {
		
		 AnchorPane pane= FXMLLoader.load(getClass().getResource("HelpMenu.fxml"));
	     mainRoot.getChildren().setAll(pane);
		
		
		
//		Parent tableViewParent = FXMLLoader.load(getClass().getResource("HelpMenu.fxml"));
//        Scene tableViewScene = new Scene(tableViewParent);
//        tableViewScene.setFill(Color.BLACK);
//        
//        //This line gets the Stage information
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        tableViewParent.setStyle("-fx-background-color: #000000;");
//        window.setScene(tableViewScene);
//        window.show();
	}
	
	public void setting(ActionEvent event) throws IOException {
		
		
		 AnchorPane pane= FXMLLoader.load(getClass().getResource("SettingMenu.fxml"));
	     mainRoot.getChildren().setAll(pane);
		
		
//		Parent tableViewParent = FXMLLoader.load(getClass().getResource("SettingMenu.fxml"));
//        Scene tableViewScene = new Scene(tableViewParent);
//        tableViewScene.setFill(Color.BLACK);
//        
//        //This line gets the Stage information
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        tableViewParent.setStyle("-fx-background-color: #000000;");
//        window.setScene(tableViewScene);
//        window.show();
	}
	
	public void achievement(ActionEvent event) throws IOException {
		
		
		 AnchorPane pane= FXMLLoader.load(getClass().getResource("AchievementMenu.fxml"));
	     mainRoot.getChildren().setAll(pane);
		
		
//		Parent tableViewParent = FXMLLoader.load(getClass().getResource("AchievementMenu.fxml"));
//        Scene tableViewScene = new Scene(tableViewParent);
//        tableViewScene.setFill(Color.BLACK);
//        
//        //This line gets the Stage information
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        tableViewParent.setStyle("-fx-background-color: #000000;");
//        window.setScene(tableViewScene);
//        window.show();
	}
	
	public void save(ActionEvent event) throws IOException {
//		setSave_count(getSave_count() + 1);
		
		
		 AnchorPane pane= FXMLLoader.load(getClass().getResource("SaveMenu.fxml"));
	     mainRoot.getChildren().setAll(pane);
		
		
//		Parent tableViewParent = FXMLLoader.load(getClass().getResource("SaveMenu.fxml"));
//        Scene tableViewScene = new Scene(tableViewParent);
//        tableViewScene.setFill(Color.BLACK);
//        
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        tableViewParent.setStyle("-fx-background-color: #000000;");
//        window.setScene(tableViewScene);
//        window.show();
	}
	
	public void volume(MouseEvent event) {
		System.out.println("Volume");
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
