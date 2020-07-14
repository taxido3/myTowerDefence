package manager;

import java.io.IOException;

import dataclasses.StaticVar;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EndViewController {
	DataManager dm;
	
    @FXML
    private ImageView imgHighScore;

    @FXML
    private TextField txfTag;

    @FXML
    private Button btnRestart;

    @FXML
    private Button btnEndGame;
    
    @FXML
    private AnchorPane mainBox;

    @FXML
    private ImageView imgGameOver;

    @FXML
    private TextField txfWellen;
    
    
    
	public EndViewController() {
		// TODO Auto-generated constructor stub
		}
    
	public void initialize() {
		setInitFxmlElements();
		txfWellen.setEditable(false);
		
	}
    
	
	private void setInitFxmlElements() {		
		btnRestart.addEventHandler(MouseEvent.MOUSE_RELEASED, tryagain);
		btnEndGame.addEventHandler(MouseEvent.MOUSE_RELEASED, beenden);
		txfWellen.setText(Integer.toString(StaticVar.player1.getWellenCounter()));
	}
    
	
	
	EventHandler<MouseEvent> beenden = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			btnEndGame = (Button) event.getSource();		
			sendElement();
			System.exit(0);
			
		}
	};
	
	
	
	EventHandler<MouseEvent> tryagain = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			btnRestart = (Button) event.getSource();		
			sendElement();
			goToStartScene();
			
		}
	};
	
	private void sendElement() {
		
		dm = new DataManager();
		dm.sendData(txfTag.getText(), StaticVar.player1.getWellenCounter());
		

	}
	
	public void goToStartScene() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/StartView.fxml"));
			Stage stage = (Stage) mainBox.getScene().getWindow();
			Scene scene = new Scene(loader.load(),1280,800);
			stage.setScene(scene);
		}
		catch (IOException io) {
			io.printStackTrace();
		}
	}

}
