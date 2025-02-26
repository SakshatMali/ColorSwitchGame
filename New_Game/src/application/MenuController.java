package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import jdk.nashorn.api.tree.ForInLoopTree;
import javafx.scene.control.Tooltip;

public class MenuController implements Initializable {
	
		private int frm_width = 600;
		private int frm_height = 750;
		
		@FXML
		private AnchorPane mainRoot;
	
	    @FXML
	    private ImageView play;

	    @FXML
	    private ImageView load;

	    @FXML
	    private ImageView achieve;

	    @FXML
	    private ImageView setting;

	    @FXML
	    private ImageView volume;

	    @FXML
	    private ImageView help;

	    @FXML
	    private ImageView social;

	    @FXML
	    private ImageView exit;
	    
	    @FXML
	    private ImageView shop;
	
	public void StartGame(MouseEvent event) throws IOException {
		Player p1 = new Player(0, 0,0);
		GamePlayController gc = new GamePlayController(p1,0,1,frm_width/2,frm_height-150,300,1,1,1);
		gc.play(event);

	}

	public void help(MouseEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("HelpMenu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        tableViewScene.setFill(Color.BLACK);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        tableViewParent.setStyle("-fx-background-color: #000000;");
        window.setScene(tableViewScene);
        window.show();
	}

	public void setting(MouseEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("SettingMenu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        tableViewScene.setFill(Color.BLACK);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        tableViewParent.setStyle("-fx-background-color: #000000;");
        window.setScene(tableViewScene);
        window.show();
	}

	public void achievement(MouseEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("AchievementMenu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        tableViewScene.setFill(Color.BLACK);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        tableViewParent.setStyle("-fx-background-color: #000000;");
        window.setScene(tableViewScene);
        window.show();
	}

	
	public void save(MouseEvent event) throws IOException {
		 AnchorPane pane= FXMLLoader.load(getClass().getResource("SaveMenu.fxml"));
	     mainRoot.getChildren().setAll(pane);
	}
	
	public void volume(MouseEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("VolumeMenu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        tableViewScene.setFill(Color.BLACK);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        tableViewParent.setStyle("-fx-background-color: #000000;");
        window.setScene(tableViewScene);
        window.show();
	}
	
	public void social(MouseEvent event) throws IOException {
		 Parent tableViewParent = FXMLLoader.load(getClass().getResource("WebMenu.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        tableViewScene.setFill(Color.BLACK);
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        tableViewParent.setStyle("-fx-background-color: #000000;");
	        window.setScene(tableViewScene);
	        window.show();
	}
	
	public void exit(MouseEvent event) throws IOException {
		 Parent tableViewParent = FXMLLoader.load(getClass().getResource("ExitMenu.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        tableViewScene.setFill(Color.BLACK);
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        tableViewParent.setStyle("-fx-background-color: #000000;");
	        window.setScene(tableViewScene);
	        window.show();
	}
	
	public void shop(MouseEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("ShopMenu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        tableViewScene.setFill(Color.BLACK);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        tableViewParent.setStyle("-fx-background-color: #000000;");
        window.setScene(tableViewScene);
        window.show();
	}
	
	@FXML
    void glowImage(MouseEvent event) throws IOException {
        Glow glow=new Glow();
        Node source = (Node) event.getSource();
        source.setEffect(glow);
        glow.setLevel(0.4);
    }
	
	 @FXML
	    void stopGlowing(MouseEvent event) throws IOException{
	        Node source= (Node) event.getSource();
	        Glow glow=(Glow) source.getEffect();
	        source.setEffect(glow);
	        glow.setLevel(0.0);
	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<ImageView> img_list = new ArrayList<ImageView>();
		ArrayList<String> name_list = new ArrayList<String>();
		
		img_list.add(play) ; name_list.add("Play Game");
		img_list.add(load) ; name_list.add("Load Game");
		img_list.add(achieve) ; name_list.add("Achievements");
		img_list.add(setting) ; name_list.add("Settings");
		img_list.add(volume) ; name_list.add("Volume");
		img_list.add(help) ; name_list.add("Help");
		img_list.add(social) ; name_list.add("Social");
		img_list.add(exit) ; name_list.add("Exit Game");
		img_list.add(shop) ; name_list.add("Shop");
		
		for (int i = 0; i < img_list.size(); i++) {
			 	Tooltip tool = new Tooltip(name_list.get(i));
		        tool.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 24));
		        Tooltip.install(img_list.get(i), tool);
		}
	}
}
