package application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameOverBoxController {
	
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
	
	
	public void cross(MouseEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        tableViewScene.setFill(Color.BLACK);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        tableViewParent.setStyle("-fx-background-color: #000000;");
        window.setScene(tableViewScene);
        window.show();
	}
//	 MediaPlayer mediaPlayer;
	public void video(MouseEvent event) throws IOException {
//		 	Media sound = new Media(getClass().getResource("/Colour Sounds/addfilm.mp4").toString());
//	        mediaPlayer = new MediaPlayer(sound);
//	        MediaView mediaView = new MediaView(mediaPlayer);
//	        mediaPlayer.setAutoPlay(true);
//	        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
//	        mediaPlayer.setStartTime(Duration.seconds(0));
//	        mediaPlayer.setStopTime(Duration.seconds(50));
//	        mediaPlayer.play();
		DataTable dt = new DataTable(0,0,0,0,0);
		DataTable temp = new DataTable(0,0,0,0,0);
		temp = dt.deserialize_max_scr();
		System.out.println(" Show score in game over  - "+temp.getMax_scr());
	        
	        Parent tableViewParent = FXMLLoader.load(getClass().getResource("VideoPlayer.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        tableViewScene.setFill(Color.BLACK);
	        
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        tableViewParent.setStyle("-fx-background-color: #000000;");
	        window.setScene(tableViewScene);
	        window.show();
	        
//	        GamePlayController.canvas.getChildren().add(mediaView);
		
	}
	
	public static void show_max_score(MouseEvent event) throws IOException{
//		System.out.println("max scr - "+mx_scr);
//		DataTable temp = new DataTable(0,0,0,0,0);
//		temp.deserialize_max_scr();
//		System.out.println(" Show score in game over  - "+temp.getMax_scr());
	}
}
