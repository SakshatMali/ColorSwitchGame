package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class VideoPlayerController implements Initializable {
	
	@FXML
    private MediaView media;
	
	@FXML
    private ImageView back;

	MediaPlayer mediaPlayer;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Media sound = new Media(getClass().getResource("/Colour Sounds/addfilm.mp4").toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setAutoPlay(true);
        mediaPlayer.setStopTime(Duration.seconds(11));
		mediaPlayer.play();
		media.setMediaPlayer(mediaPlayer);	

	}
	
	public void back(MouseEvent event) throws IOException {
		
		 Parent tableViewParent = FXMLLoader.load(getClass().getResource("GameOverBox.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        tableViewScene.setFill(Color.BLACK);
	        
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        tableViewParent.setStyle("-fx-background-color: #000000;");
	        window.setScene(tableViewScene);
	        window.show();
	        mediaPlayer.stop();
	}
	

    @FXML
    void glowImage(MouseEvent event) throws IOException {
//		System.out.println("On Image");
        Glow glow=new Glow();
        Node source = (Node) event.getSource();
        source.setEffect(glow);
        glow.setLevel(0.4);
        
        Tooltip tool = new Tooltip("Back");
        tool.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 24));
        Tooltip.install(back, tool);
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
