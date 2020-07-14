package tools;

import java.io.File;
import java.util.ArrayList;
import dataclasses.HitBox;
import dataclasses.MainTower;
import dataclasses.StaticVar;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import manager.DataManager;


public class ViewGenerator {
	static boolean buildModus = false;
	static int selectedTowerId = 0;
	static MonsterBox mbox;
	static DataManager dm = new DataManager();
	@FXML
	ImageView imgView = new ImageView();
    public ArrayList<String> sfData = new ArrayList<String>();
    public ArrayList<MyButton> sfAllBtns = new ArrayList<MyButton>();
	public ArrayList<String> tsData = new ArrayList<String>();
	public ArrayList<MyButton> tsAllBtns = new ArrayList<MyButton>();
	public ArrayList<MyLabel> mgAllLbl = new ArrayList<MyLabel>();

	public ViewGenerator() {}
	
	public ArrayList<MyButton> getAllSfButtons(){return sfAllBtns;}
	public int getAllSfButtonsCount(){return sfAllBtns.size();}
	public MyButton getSfButtonAt(int index){return sfAllBtns.get(index);}
	
	public ArrayList<MyButton> getAllTsButtons(){return tsAllBtns;}
	public int getAllTsButtonsCount(){return tsAllBtns.size();}
	public MyButton getTsButtonsAt(int index){return tsAllBtns.get(index);}
	
	public ArrayList<MyLabel> getAllMgLblTypen(){return mgAllLbl;}
	public int getAllMgLblCount(){return mgAllLbl.size();}
	public MyLabel getMgLblAt(int index){return mgAllLbl.get(index);}
	
	
	EventHandler<MouseEvent> preview = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
		
			
		if(buildModus) {
			
		
			MyButton btnB = sfAllBtns.get(0);
			btnB = (MyButton) event.getSource();
			if(!btnB.getHitBox().isBelegt()) {
				Image Tower = new Image(dm.getTowerTypenAt(selectedTowerId).getInGamImg());
				BackgroundImage bgi= new BackgroundImage(Tower, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
				Background bgImage = new Background(bgi);
				btnB.setBackground(bgImage);
			
			
				sfAllBtns.get(btnB.getIndex()).setBackground(bgImage);
				sfAllBtns.get(btnB.getIndex()).setText("");
				sfAllBtns.get(btnB.getIndex()).setOpacity(1.0);
			}
		}
		}
		
	};
	
	
	EventHandler<MouseEvent> previewOut = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {					
		if(buildModus) {					
			MyButton btnB = sfAllBtns.get(1);
			btnB = (MyButton) event.getSource();
			
			if(!btnB.getHitBox().isBelegt()) {
			sfAllBtns.get(btnB.getIndex()).setOpacity(0.0);
			}		
		}
		}
		
	};
	
		
	EventHandler<MouseEvent> hit = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {						
			if(buildModus) {
				MyButton btnB = sfAllBtns.get(1);
				btnB = (MyButton) event.getSource();
				if(StaticVar.player1.getGold() >= dm.getTowerTypenAt(selectedTowerId).getPreis()) {
				Image Tower = new Image(dm.getTowerTypenAt(selectedTowerId).getInGamImg());
				BackgroundImage bgi= new BackgroundImage(Tower, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
				Background bgImage = new Background(bgi);
				btnB.setBackground(bgImage);
				
				sfAllBtns.get(btnB.getIndex()).setBackground(bgImage);
				sfAllBtns.get(btnB.getIndex()).setOpacity(1.0);
				sfAllBtns.get(btnB.getIndex()).setText("");
				sfAllBtns.get(btnB.getIndex()).getHitBox().setBelegt(true);
				sfAllBtns.get(btnB.getIndex()).getHitBox().setTowerId(selectedTowerId);
				
				MainTower mTower = new MainTower(selectedTowerId, btnB.getLayoutX(), btnB.getLayoutY(), btnB.getIndex());

				
				StaticVar.allTowers.add(mTower);
				
				StaticVar.player1.setGold(StaticVar.player1.getGold()-dm.getTowerTypenAt(selectedTowerId).getPreis());
				
				}
				else {
					buildModus = false;
					sfAllBtns.get(btnB.getIndex()).setOpacity(0.0);
				}								
			}			
		}
	};
	
	
    EventHandler<MouseEvent> getEventtowerSelect(Pane paneManagement){
    	return new EventHandler<MouseEvent>() {
    		
    		public void handle(MouseEvent event) {
    			
    			MyButton btnB = (MyButton) event.getSource();
    			
    			paneManagement.getChildren().removeAll(mgAllLbl);
    			
    			buildModus = true;
    			
    			selectedTowerId = tsAllBtns.get(btnB.getIndex()).getIndex();
    			
    			generateBuildManagemant(selectedTowerId, paneManagement);
    		}
    	};
    }
	

    public void generateTowerSelect(Pane paneTowerSelect, Pane paneManagement) {
    	

		int xKoord = 0;
		int yKoord = 0;

		
		
		for(int i=0; i<=4;i++) {
			tsData.add(Integer.toString(i));	
			
		}
		
		for(int i=0; i<tsData.size(); i++) {
			
			

						
			MyButton btnButton = new MyButton(i);
					 btnButton.setLayoutX(20+(i*170));
					 btnButton.setLayoutY(14);
					 btnButton.setPrefWidth(150);
					 btnButton.setPrefHeight(150);
					 //btnButton.setText(tsData.get(i));
					 btnButton.setHitBox(new HitBox(i, xKoord, yKoord));
					 btnButton.addEventHandler(MouseEvent.MOUSE_RELEASED, getEventtowerSelect(paneManagement));
					 

					 
			paneTowerSelect.getChildren().add(btnButton);
			tsAllBtns.add(btnButton);
			
			xKoord++;
			
			 if(xKoord == 21) {
				 xKoord = 0;
				 yKoord++;
			 }
			 
					 
		}
		
		Image Tower = new Image("file:///../img/Tower/StandardTower2.gif");
    	BackgroundImage bgi= new BackgroundImage(Tower, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background bgImage = new Background(bgi);
    	tsAllBtns.get(0).setBackground(bgImage);
    	
		Tower = new Image("file:///../img/Tower/FireTower.jpg");
    	bgi= new BackgroundImage(Tower, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		bgImage = new Background(bgi);
    	tsAllBtns.get(1).setBackground(bgImage);
    	
		Tower = new Image("file:///../img/Tower/TeslaTower.png");
    	bgi= new BackgroundImage(Tower, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		bgImage = new Background(bgi);
    	tsAllBtns.get(2).setBackground(bgImage);
    	
		Tower = new Image("file:///../img/Tower/LaserTower.jpg");
    	bgi= new BackgroundImage(Tower, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		bgImage = new Background(bgi);
    	tsAllBtns.get(3).setBackground(bgImage);
    	
		Tower = new Image("file:///../img/Tower/WindTower.gif");
    	bgi= new BackgroundImage(Tower, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		bgImage = new Background(bgi);
    	tsAllBtns.get(4).setBackground(bgImage);
    		
    }

    public void generateHitBoxGrid(Pane paneGamefield) {
		
		double xversatz =0;
		double yversatz =0;
		int xKoord = 0;
		int yKoord = 0;
		int spalten =22;
		
		
		for(int i=0; i<=197;i++) {
			sfData.add(Integer.toString(i));	
			
		}
		
		for(int i=0; i<sfData.size(); i++) {
			
			
			if(i % spalten == 0 && i != 0) {
				
				xversatz +=(55*spalten);
				yversatz +=55;
					
			}
						
			MyButton btnButton = new MyButton(i);
					 btnButton.setLayoutX(5+(55*i)-xversatz);
					 btnButton.setLayoutY(10+yversatz);
					 btnButton.setPrefWidth(50);
					 btnButton.setPrefHeight(50);
					 btnButton.setText(sfData.get(i));
					 btnButton.setHitBox(new HitBox(i, xKoord, yKoord));
					 btnButton.setOpacity(0.0);
					 btnButton.addEventHandler(MouseEvent.MOUSE_RELEASED, hit);
					 btnButton.addEventHandler(MouseEvent.MOUSE_ENTERED, preview);
					 btnButton.addEventHandler(MouseEvent.MOUSE_EXITED, previewOut);
					 
			paneGamefield.getChildren().add(btnButton);
			sfAllBtns.add(btnButton);
			
			xKoord++;
			
			 if(xKoord == 21) {
				 xKoord = 0;
				 yKoord++;
			 }
			 
					 
		}
		
	}
	
    
    public void generateLayout(Pane paneTowerSelect, Pane paneGamefield, Pane paneManagement) {
    	
		Image img = new Image("file:///../img/gras_template.jpg");
    	
    	BackgroundImage bgi = new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    	
    	Background bg = new Background(bgi);
    	
    	paneGamefield.setBackground(bg);
    	
    	
    	
    	
    	img = new Image("file:///../img/grayBricks.jpg");
    	
    	bgi = new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    	
    	bg = new Background(bgi);
    	
    	paneTowerSelect.setBackground(bg);
    	
    	
    	
    	
    	img = new Image("file:///../img/grayBricks.gif");
    	
    	bgi = new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    	
    	bg = new Background(bgi);
    	
    	paneManagement.setBackground(bg);
    }
  


    void generateBuildManagemant(int id, Pane paneManagement) {  

		
		mgAllLbl.clear();
		paneManagement.getChildren().clear();
		int lo = 0;    	

		MyLabel lb = new MyLabel(0);
		lb.setId("lbName");
		lb.setText("Name: "+dm.getTowerTypenAt(id).getName());
		mgAllLbl.add(lb);
		
		lb = new MyLabel(1);
		lb.setId("lbDmg");
		lb.setText ("Dmg.: "+Double.toString(dm.getTowerTypenAt(id).getDmg()));
		mgAllLbl.add(lb);
		
		lb = new MyLabel(2);
		lb.setId("lbPreis");
		lb.setText("Preis: "+Double.toString(dm.getTowerTypenAt(id).getPreis()));
		mgAllLbl.add(lb);
		
		lb = new MyLabel(3);
		lb.setId("lbAttRad");
		lb.setText("Att. Radius: "+Double.toString(dm.getTowerTypenAt(id).getAttackRadius()));
		mgAllLbl.add(lb);
		
		lb = new MyLabel(4);
		lb.setId("lbAttSpeed");
		lb.setText("Att. Speed: "+Double.toString(dm.getTowerTypenAt(id).getAttackSpeed()));
		mgAllLbl.add(lb);
		
		
		
		for(int i = 0; i < 5; i++) {
			mgAllLbl.get(i).setLayoutX(20);
			mgAllLbl.get(i).setLayoutY(lo+(i*30));
			mgAllLbl.get(i).setFont(Font.font("Comic Sans MS", 16));
			paneManagement.getChildren().add(mgAllLbl.get(i));
		}
		
		
		imgView = new ImageView();
		File f = new File(dm.getTowerTypenAt(id).getPortrait());
		Image img = new Image(f.toURI().toString());
	
		//Image img = new Image(imgPath);    
		imgView.setImage(img);				    
		imgView.setX(159);			      
		imgView.setY(20);
		imgView.setFitHeight(143);
		imgView.setFitWidth(134);
		imgView.setOpacity(1.0);
		paneManagement.getChildren().add(imgView);
		
}
    
    void generateMonsterManagemant(Pane paneManagement) {  //wird noch parametrisiert, damit die Daten eines spezifischen Monsters angezeigt werden
 	   
    	for (int i = 0; i <= 2; i++)
    	{
    		
    		MyLabel lb = new MyLabel(i);
    		
    		lb.setText("Hier ne Funktion, die aus n Array abruft");
    		lb.setLayoutX(20);
    		lb.setLayoutY(20+((25+10)*i));
    		lb.setPrefSize(134, 40);
    		lb.setFont(new Font("Arial", 10));
    		lb.setTextFill(Color.web("#0076a3"));
    		
    		paneManagement.getChildren().add(lb);
    		
    	}
   	
}
    


}