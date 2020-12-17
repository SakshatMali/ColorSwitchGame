package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ShopMenuController {
	
	@FXML 
	private ImageView home;
	
	@FXML
	private Label success;
	
	public void home(MouseEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        tableViewScene.getStylesheets().add(getClass().getResource("big-check-box.css").toExternalForm());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
	}
	
	@FXML
    void glowImageHome(MouseEvent event) throws IOException {
        Glow glow=new Glow();
        Node source = (Node) event.getSource();
        source.setEffect(glow);
        glow.setLevel(0.4);
        Tooltip tool = new Tooltip("Home");
        tool.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 24));
        Tooltip.install(home, tool);
    }
	
	@FXML
    void glowImage(MouseEvent event) throws IOException {
        Glow glow=new Glow();
        Node source = (Node) event.getSource();
        source.setEffect(glow);
        glow.setLevel(0.4);
    }
	
	@FXML
    void stopGlowing(MouseEvent event) throws IOException {
        Node source= (Node) event.getSource();
        Glow glow=(Glow) source.getEffect();
        source.setEffect(glow);
        glow.setLevel(0.0);
    }
	 
	 public void circleball(MouseEvent event) {
		 
		 if (Main.ballshape==0) {
			success.setText("Ball is Already Circle");
		}
		 
		else {
			 Main.ballshape=0;
			 success.setText("Ball Changed to Circle");
		}
	}
	 
	 public void squareball(MouseEvent event) {
		 
			DataTable dt = new DataTable(0,0,0,0,0,0,0,0,0,0,0);
			DataTable temp = new DataTable(0,0,0,0,0,0,0,0,0,0,0);
			temp = dt.deserialize_max_scr();
			
			if (Main.ballshape==1) {
				success.setText("Ball is Already Square");
			}
			
			else {
				
				if (temp.getTotal_stars()>=5) {
					temp.setTotal_stars(temp.getTotal_stars()-5);
					temp.serialize_max_scr();
					Main.ballshape=1;
					success.setText("Ball Changed to Square"); 
				} 
				
				else {
					success.setText("Not Enough Stars");
				}
			}
	 }
	 
	 public void triangleball(MouseEvent event) {
		 
			DataTable dt = new DataTable(0,0,0,0,0,0,0,0,0,0,0);
			DataTable temp = new DataTable(0,0,0,0,0,0,0,0,0,0,0);
			temp = dt.deserialize_max_scr();
			
			if (Main.ballshape==2) {
				success.setText("Ball is Already Triangle");
			}
			
			else {
			
				if (temp.getTotal_stars()>=10) {
					temp.setTotal_stars(temp.getTotal_stars()-10);
					temp.serialize_max_scr();
					Main.ballshape=2;
					success.setText("Ball Changed to Triangle"); 
				} 
				else {
					success.setText("Not Enough Stars");
				}
			}
	 }
	 
	 public void lineball(MouseEvent event) {

			DataTable dt = new DataTable(0,0,0,0,0,0,0,0,0,0,0);
			DataTable temp = new DataTable(0,0,0,0,0,0,0,0,0,0,0);
			temp = dt.deserialize_max_scr();
			
			if (Main.ballshape==3) {
				success.setText("Ball is Already Line");
			}
			
			else {
			
				if (temp.getTotal_stars()>=20) {
					temp.setTotal_stars(temp.getTotal_stars()-20);
					temp.serialize_max_scr();
					Main.ballshape=3;
					success.setText("Ball Changed to Line"); 
				} 
				else {
					success.setText("Not Enough Stars");
				}
			}
	 }
	 
	 public void plusball(MouseEvent event) {

			DataTable dt = new DataTable(0,0,0,0,0,0,0,0,0,0,0);
			DataTable temp = new DataTable(0,0,0,0,0,0,0,0,0,0,0);
			temp = dt.deserialize_max_scr();
			
			if (Main.ballshape==4) {
				success.setText("Ball is Already Plus");
			}
			
			else {
			
				if (temp.getTotal_stars()>=30) {
					temp.setTotal_stars(temp.getTotal_stars()-30);
					temp.serialize_max_scr();
					Main.ballshape=4;
					success.setText("Ball Changed to Plus"); 
				} 
				else {
					success.setText("Not Enough Stars");
				}
			}
	 }
	 
	 public void starball(MouseEvent event) {

			DataTable dt = new DataTable(0,0,0,0,0,0,0,0,0,0,0);
			DataTable temp = new DataTable(0,0,0,0,0,0,0,0,0,0,0);
			temp = dt.deserialize_max_scr();
			
			if (Main.ballshape==5) {
				success.setText("Ball is Already Square");
			}
			
			else {
			
				if (temp.getTotal_stars()>=50) {
					temp.setTotal_stars(temp.getTotal_stars()-50);
					temp.serialize_max_scr();
					Main.ballshape=5;
					success.setText("Ball Changed to Star"); 
				} 
				else {
					success.setText("Not Enough Stars");
				}
			}
	 }
}
