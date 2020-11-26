package application;
	
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;


public class Main extends Application {
	private int frm_width = 600;
	private int frm_height = 750;
//	MediaPlayer mediaPlayer;
	private PauseDialogBoxController pdc = new PauseDialogBoxController();
	@Override
	public void start(Stage primaryStage) throws IOException {

		
		
		//MUSIC
		AudioClip audioPath = new AudioClip("file:src/Colour%20Sounds/BackSound.wav");
		audioPath.setVolume(0.05);
        audioPath.play();
        audioPath.setCycleCount(AudioClip.INDEFINITE);

		Parent mainRoot=FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(mainRoot,frm_width,frm_height);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        scene.setFill(Color.BLACK);
        mainRoot.setStyle("-fx-background-color: #000000;");
        primaryStage.setTitle("Bouncing Ball");
        
        primaryStage.setScene(scene);
//        scene.setFill(Color.BLACK);
//        new File(path).toURI().toString()
//        "/src/Game Sounds/BackSound.mp3"
        primaryStage.show();
//        mediaPlayer.play();
//        mediaPlayer.setAutoPlay(true);
        
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
