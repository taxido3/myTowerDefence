package manager;



import java.io.IOException;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import dataclasses.Spielstatistik;
import dataclasses.StaticVar;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import tools.MonsterBox;
import tools.ViewGenerator;
import javafx.scene.paint.Color;


public class GameViewController {
 	
    @FXML
    private AnchorPane mainBox;
	
	@FXML
    private Pane paneTowerSelect;

    @FXML
    private Label lbGold;

    @FXML
    private Label lbLeben;

    @FXML
    private Label lbCounter;

    @FXML
    private ImageView imgManagement;

    @FXML
    private Pane paneManagement;

    @FXML
    private ImageView imgTower4;

    @FXML
    private ImageView imgTower5;

    @FXML
    private ImageView imgTower2;

    @FXML
    private ImageView imgTower3;

    @FXML
    private ImageView imgTower1;

    @FXML
    private Label lbZeit;

    @FXML
    private Pane paneGamefield;
    
    
    private DataManager dm = new DataManager();
    private MonsterBox mbox;
    private Timeline lifeline;
	private boolean finished = false;
	private ViewGenerator ViewGenerator = new ViewGenerator();
		
    
	public GameViewController() {
		System.out.println("init");		
	}
	
	public void initialize() {
		System.out.println("gfx is ready");
		generateView();
		setAllGameParams();	      
	}
	
    void generateView(){       	
			showGameStat();
			ViewGenerator.generateTowerSelect(paneTowerSelect, paneManagement);
			ViewGenerator.generateLayout(paneTowerSelect, paneGamefield, paneManagement);
			ViewGenerator.generateHitBoxGrid(paneGamefield);       	
        }    
    	
	public void goToEndScene() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/EndView.fxml"));
			Stage stage = (Stage) mainBox.getScene().getWindow();
			Scene scene = new Scene(loader.load(), 1280, 800);
			stage.setScene(scene);
		}
		catch (IOException io) {
			io.printStackTrace();
		}
	}
    
	
	       
    	
	public void showGameStat() {
    		lbGold.setText("Gold: "+Integer.toString(StaticVar.player1.getGold()));
    		lbGold.setPrefSize(134, 40);
    		lbGold.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
    		lbGold.setTextFill(Color.web("#0076a3"));
    		
    		lbLeben.setText("Leben: "+Integer.toString(StaticVar.player1.getLeben()));
    		lbLeben.setPrefSize(134, 40);
    		lbLeben.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
    		lbLeben.setTextFill(Color.web("#0076a3"));
    		
    		lbCounter.setText("Nächste Welle in: "+Integer.toString(StaticVar.player1.getWellenCountdown()));
    		lbCounter.setPrefSize(200, 40);
    		lbCounter.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
    		lbCounter.setTextFill(Color.web("#0076a3"));
    		    		
    		lbZeit.setText("Wellen abgewehrt: "+Integer.toString(StaticVar.player1.getWellenCounter()));
    		lbZeit.setPrefSize(200, 40);
    		lbZeit.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));
    		lbZeit.setTextFill(Color.web("#0076a3"));
    		
    	}
	


	
   public void anvisieren(int t) {	   
	   
	   for(int m = 0; m < StaticVar.getMonsterCount(); m++) {
		  if(StaticVar.getTowerAt(t).getAttackArea().getBoundsInParent().intersects(StaticVar.getMonsterAt(m).getBoundsInParent()) && StaticVar.getTowerAt(t).isActive()==false) {
			  StaticVar.getTowerAt(t).setActive(true);			  
			  StaticVar.getTowerAt(t).setEnemy(StaticVar.getMonsterAt(m));
		   }
		}
	   
   
   	}	

   
   
   public void schiessen(int t)  {
	   
	   for(int m = 0; m < StaticVar.getMonsterCount(); m++) {
		   if(StaticVar.getTowerAt(t).isActive()) {
			  StaticVar.getTowerAt(t).activateAnimation(StaticVar.getTowerAt(t).getTowerId(), ViewGenerator.getSfButtonAt(StaticVar.getTowerAt(t).getHitBoxID()));				
	    	  StaticVar.getTowerAt(t).getEnemy().loseLife(dm.getTowerTypenAt(StaticVar.getTowerAt(t).getTowerId()).getDmg(), paneGamefield, StaticVar.getTowerAt(t).getTowerId());			   
	    	  StaticVar.getMonsterAt(m).loseLife(dm.getTowerTypenAt(StaticVar.getTowerAt(t).getTowerId()).getDmg(), paneGamefield, StaticVar.getTowerAt(t).getTowerId());				   			   
				   

		   		//if(StaticVar.getTowerAt(m).getEnemy().getHp() <= 0 ) {StaticVar.getTowerAt(m).getEnemy().monsterDie(paneGamefield);}
		   		if(StaticVar.getMonsterAt(m).getHp() <= 0) {
		   			StaticVar.getMonsterAt(m).monsterDie(paneGamefield); 
		   			StaticVar.getTowerAt(t).setActive(false);
		   			}
		   }
	      
		   if(!StaticVar.getTowerAt(t).getAttackArea().getBoundsInParent().intersects(StaticVar.getTowerAt(t).getEnemy().getBoundsInParent())) {
			   StaticVar.getTowerAt(t).setActive(false);
			   StaticVar.getTowerAt(t).setEnemy(new MonsterBox());
		   }
	   }			   
	   
   }
	   
   
  

    void createMonsterSlow(int id) {
    	
    	mbox = new MonsterBox(id,dm.getMonsterTypenAt(4).getInGamImg(), dm.getMonsterTypenAt(4).getHP());    	
    	mbox.setLayoutX(1220);
    	mbox.setLayoutY(200-(45*id));      	
    	mbox.setPrefWidth(150.0);
    	mbox.setPrefHeight(150.0);     	
    	mbox.createImageView();
    	mbox.setImgSize();
  	    //mainBox.getChildren().add(mbox);
  	    paneGamefield.getChildren().add(mbox);
  	    StaticVar.allMonster.add(mbox);
  	    

  	    
  }
    
    void setAllGameParams()  {  	    	    

           	
    	generalActiv();
    	
    		
    }    

    public void generalActiv() {
  	
  	    lifeline = new Timeline(new KeyFrame(Duration.seconds(0.02), ev -> {	        

  	  	    standardAblauf();
    	      //Update der Spielstatistik
    	      showGameStat();
    	      
      	      //Tower Aktivität
    	      for (int t = 0; t < StaticVar.getTowerCount(); t++) {
    	      anvisieren(t);
    	      schiessen(t);
    	      welleAblauf();
    	      }
   				
      	      
  	    }));
  	    lifeline.setCycleCount(Animation.INDEFINITE);
  	    

  	    lifeline.play();
  	    
  	    
  	}    
  
    void standardAblauf() {
	    
	    //SpielEndBedingung	   	    	   
    	if(StaticVar.player1.getLeben() <= 0) {
	    		   lifeline.stop();
	    		   ViewGenerator.sfData.clear();
	    		   ViewGenerator.sfAllBtns.clear();
	    		   ViewGenerator.tsData.clear();
	    		   ViewGenerator.tsAllBtns.clear();
	    		   ViewGenerator.mgAllLbl.clear();
	    		   StaticVar.allTowers.clear();
	    		   StaticVar.allMonster.clear();
	    		   StaticVar.player1 = new Spielstatistik(0, 20, 2, 20);
	    		   goToEndScene();
  	      }
    	
    	
  	      //Bewegung aller Monster
  	      for(int i = 0; i < StaticVar.getMonsterCount(); i++) {  			
  			StaticVar.getMonsterAt(i).moveX(paneGamefield);
  			
  	      }


				
  	      }		

  	      
  	      
    

    
 /*   public void welle() {
    	
  	    lifeline = new Timeline(new KeyFrame(Duration.seconds(0.02), ev -> {	        
  			
  	    welleAblauf();
  	    }));
  	    lifeline.setCycleCount(Animation.INDEFINITE);
  	    

  	    lifeline.play();
    	
    	
    }*/
    void welleAblauf() {
    	if(StaticVar.getAllMonster().isEmpty()) {finished=true;}
    	if(finished) {
 		   //StaticVar.allMonster.clear();
    		
		for(int i = 0; i < 8; i++) {
		      createMonsterSlow(i);
		      StaticVar.getMonsterAt(i).setHp(StaticVar.getMonsterAt(i).getHp()+(100*StaticVar.player1.getWellenCounter()));
		      finished = false;
		      }
		StaticVar.player1.setWellenCounter(StaticVar.player1.getWellenCounter()+1);
    	}
	    	   	    	   
	    	   
    }
}


