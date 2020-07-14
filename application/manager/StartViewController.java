package manager;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StartViewController {
	
	DataManager dm;
	

    @FXML
    private ImageView imgStart;

    @FXML
    private AnchorPane mainBox;

    @FXML
    private Button btStart;

    @FXML
    private ListView<String> lsvHighscores;
    
	public StartViewController() {
		// TODO Auto-generated constructor stub
	}
	
	public void initialize() {
		System.out.println("1. StartVC:start load");
		dm = new DataManager(this);
		dm.loadData();
		
		
	}
    
    
	public void finishedLoadData() {
		setInitFxmlElements();
		createAllListElement();
		System.out.println("6. ListVC:update GFX");
	}
	
	
	
	
	
	
	
	
	
	private void setInitFxmlElements() {		
		btStart.addEventHandler(MouseEvent.MOUSE_RELEASED, startGame);
	}
	

	
	private void createAllListElement() {
		
		for(int i = 0; i < dm.getAllHighscoreCount(); i++) {	//hier könnte man einstellen, wie viele der Top man sich anzeigen lassen will
			String insert = "Tag: "+dm.getHighscoreAt(i).getTag()+"              ||           Wellen: "+Integer.toString(dm.getHighscoreAt(i).getWellen());
			lsvHighscores.getItems().add(insert);
		}

	}
	
	
	
	
	EventHandler<MouseEvent> startGame = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			btStart = (Button) event.getSource();
			
			goToMainScene();
		}
	};
	
	private void goToMainScene() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/GameView.fxml"));
			Stage stage = (Stage) mainBox.getScene().getWindow();
			Scene scene = new Scene(loader.load());
			stage.setScene(scene);
		}
		catch (IOException io) {
			io.printStackTrace();
		}
	}
    
    
}
