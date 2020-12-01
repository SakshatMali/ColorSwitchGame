package application;

import java.io.IOException;

import java.io.FileNotFoundException;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SaveController implements Initializable {
	
	@FXML private Button str0;
	@FXML private Button str1;
	@FXML private Button str2;
	@FXML private Button str3;
	@FXML private Button str4;
	@FXML private Button str5;
	@FXML private Button str6;
	
	@FXML ImageView home;
	
	public void home(MouseEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
//        tableViewScene.setFill(Color.BLACK);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        tableViewParent.setStyle("-fx-background-color: #000000;");
        window.setScene(tableViewScene);
        window.show();
	}
	
	@FXML
    void glowImage(MouseEvent event) throws IOException {
//		System.out.println("On Image");
        Glow glow=new Glow();
        Node source = (Node) event.getSource();
        source.setEffect(glow);
        glow.setLevel(0.4);
        Tooltip tool = new Tooltip("Home");
        tool.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 24));
        Tooltip.install(home, tool);
    }
	
	 @FXML
	    void stopGlowing(MouseEvent event) throws IOException {
//		 System.out.println("Out Image");
	        Node source= (Node) event.getSource();
	        Glow glow=(Glow) source.getEffect();
	        source.setEffect(glow);
	        glow.setLevel(0.0);
	    }
//	@FXML private Button str7;
//	@FXML private Button str8;
//	@FXML private Button str9;
//	@FXML private Button str10;
//	DataTab0;
	private static int star_text;
	private static int save_counter;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		ArrayList<Button> ArrText = new ArrayList<Button>();
		

		ArrText.add(str0);
		ArrText.add(str1);
		ArrText.add(str2);
		ArrText.add(str3);
		ArrText.add(str4);
		ArrText.add(str5);
		ArrText.add(str6);
//		ArrText.add(str0);
		
		
//		for (int i=0 ; i<7 ; i++) {
//			ArrText.get(i).setText("");
//		}
		
		ArrText.get(save_counter%7).setText("Game "+star_text);
		
//		System.out.println("hh");
	}
	

	

	public void load(MouseEvent event) throws FileNotFoundException {

		Player p1 = new Player(0,0,0);
		GamePlayController gc = new GamePlayController(p1,4,5);
		gc.play(event);
	}

	public int getStar_text() {
		return star_text;
	}

	public static void setStar_text(int star_text1) {
		star_text = star_text1;
	}

	public static int getSave_counter() {
		return save_counter;
	}

	public static void setSave_counter(int save_counter) {
		SaveController.save_counter = save_counter;
	}

}
