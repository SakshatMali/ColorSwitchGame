package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class SaveController implements Initializable {
	
	@FXML private Button str0;
	@FXML private Button str1;
	@FXML private Button str2;
	@FXML private Button str3;
	@FXML private Button str4;
	@FXML private Button str5;
	@FXML private Button str6;
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
	
	public void load(ActionEvent event) {
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
