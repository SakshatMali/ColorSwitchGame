package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GameOverBoxController implements Initializable {
	
	  	@FXML
	  	private ImageView cross;
	  
	  	@FXML
	    private Label curr;

	    @FXML
	    private Label max;

	    @FXML
	    private Label total;
	
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
	
	@FXML
    void glowImage_cross(MouseEvent event) throws IOException {
//		System.out.println("On Image");
        Glow glow=new Glow();
        Node source = (Node) event.getSource();
        source.setEffect(glow);
        glow.setLevel(0.4);
        
        Tooltip tool = new Tooltip("Home");
        tool.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 24));
        Tooltip.install(cross, tool);
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
//		DataTable dt = new DataTable(0,0,0,0,0);
//		DataTable temp = new DataTable(0,0,0,0,0);
//		temp = dt.deserialize_max_scr();
//		System.out.println(" Show score in game over  - "+temp.getMax_scr());
	        
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
	
	public void star(MouseEvent event) throws IOException{
		
		System.out.println("Star");
		
		DataTable dt = new DataTable(0,0,0,0,0);
		DataTable temp = new DataTable(0,0,0,0,0);
		temp = dt.deserialize_max_scr();
		
		temp.setTotal_stars(temp.getTotal_stars()-5);
		temp.serialize_max_scr();
		Player p1 = new Player(temp.getCurr_scr(),temp.getMax_scr(),temp.getTotal_stars());
		GamePlayController gc = new GamePlayController(p1,temp.getNum_obst1(), temp.getNum_obst2());
		gc.play(event);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		DataTable dt = new DataTable(0,0,0,0,0);
		DataTable temp = new DataTable(0,0,0,0,0);
		temp = dt.deserialize_max_scr();
		
		curr.setText(temp.getCurr_scr()+"");
		curr.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 32));
		curr.setAlignment(Pos.CENTER);
		
		max.setText(temp.getMax_scr()+"");
		max.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 32));
		max.setAlignment(Pos.CENTER);
		
		
		total.setText(temp.getTotal_stars()+"");
		total.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 32));
		total.setAlignment(Pos.CENTER);
		
	}
}
