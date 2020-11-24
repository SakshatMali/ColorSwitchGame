package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PauseDialogBoxController {
//	private Pane canvas;
//	private Timeline loop;
//	Ball ball;
//	Player player;
//	private Image pause;
//	private Text scr;
	DataTable datatable;
//	private ArrayList<ShapeObstacle> Obstacles;

//	void initData(Pane canvas, Timeline loop, Ball ball, Player player, Image pause, Text scr,DataTable datatable,ArrayList<ShapeObstacle> obstacles) {	
//		this.canvas = canvas;
//		this.loop = loop;
//		this.ball = ball;
//		this.player = player;
//		this.pause = pause;
//		this.scr = scr;
//		this.datatable = datatable;
//		Obstacles = obstacles;
//	}
	
	void initData(DataTable datatable) {
		this.datatable=datatable;
	}
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
//		datatable.serialize();
		datatable.deserialize();
		
//		GamePlayController gc = new GamePlayController(canvas,loop,ball,player,pause,scr,datatable,Obstacles);
		GamePlayController gc = new GamePlayController();
		gc.play(event);
	}
	
	public void save(ActionEvent event) throws IOException {
		datatable.serialize();
//		datatable.deserialize();
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
