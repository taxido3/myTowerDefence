package dataclasses;

import java.io.File;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import manager.DataManager;
import tools.MonsterBox;
import tools.MyButton;

public class MainTower {
	
	private int towerId;
	private DataManager dm = new DataManager();
	@FXML
	private ImageView  imgView; 
	private int HitBoxID;
	private double xKoord;
	private double yKoord;
	private Circle attackArea;
	private boolean active;
	private MonsterBox enemy;
	
	
	public MainTower(int towerId, double xKoord, double yKoord, int HitBoxID) {
		this.towerId = towerId;
		this.xKoord = xKoord;
		this.yKoord = yKoord;
		this.HitBoxID = HitBoxID;
		this.enemy = new MonsterBox();
		attackArea = new Circle();
		attackArea.setCenterX(xKoord);
		attackArea.setCenterY(yKoord);
		//attackArea.setRadius(2.0);
		attackArea.setRadius(dm.getTowerTypenAt(towerId).getAttackRadius());		
	}
	
	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public MonsterBox getEnemy() {
		return enemy;
	}


	public void setEnemy(MonsterBox enemy) {
		this.enemy = enemy;
	}

	
	public Circle getAttackArea() {
		return attackArea;
	}

	public void setAttackArea(Circle attackArea) {
		this.attackArea = attackArea;
	}

	public int getHitBoxID() {
		return HitBoxID;
	}

	public void setHitBoxID(int hitBoxID) {
		HitBoxID = hitBoxID;
	}
	public int getTowerId() {
		return towerId;
	}

	public void setTowerId(int towerId) {
		this.towerId = towerId;
	}

	public double getxKoord() {
		return xKoord;
	}

	public void setxKoord(double xKoord) {
		this.xKoord = xKoord;
	}

	public double getyKoord() {
		return yKoord;
	}

	public void setyKoord(double yKoord) {
		this.yKoord = yKoord;
	}
	
	public void activateAnimation(int TowerId, MyButton Tower) {
		switch (TowerId) {		
			case 1:
				fireTowerAnimation(Tower);
				break;
			case 2:
				iceTowerAnimation(Tower);
				break;
			case 3:
				windTowerAnimation(Tower);
				break;
			case 4:
				TeslaTowerAnimation(Tower);
				break;
			default:
				break;
		}
		
		
	}
	  //=========================================
	  //für alle sterbe animationen zusammen -> hauptsterbezeit -> restet ...
	  Timeline shootTime;
	  //zeitleiste zum abspielen von einzelbildern nacheinander
	  Timeline shootFrameTime;
	  //zähler für jedes einzelne bild im array
	  int frameCount = 0;


	  
	  private void fireTowerAnimation(MyButton button) {
		 frameCount = 0;
		//-------------------- 
		 //alle 10ms wird ddas bild gewechselt
		 shootFrameTime = new Timeline(new KeyFrame(Duration.seconds(5), ev -> {			
			   setFireTowerImg(button);
	  	}));
		 shootFrameTime.setCycleCount(Animation.INDEFINITE);
		 shootFrameTime.play();
		  
		 
		  
		//---------------------------  
		  
		//wenn komplette animation der explosion fertig ist  -> 2sec
		 shootTime = new Timeline(new KeyFrame(Duration.seconds(0.4), ev -> {			
  	    	//resetAll();
			 shootTime.stop();
  	    }));		
		//exploTime.setCycleCount(-1);
		 shootTime.play();
		
		//-------------------------
		  
	  }
	  
	  
	  void setFireTowerImg(MyButton button) {
		  if(frameCount<dm.getAllFireShotFramesSize()) {
			  String str = dm.getFireShotFramesAt(frameCount);
			  File file  = new File(str);
			  Image img  = new Image(file.toURI().toString());     
			  BackgroundImage bgi = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
			  Background bgImage = new Background(bgi);
			  button.setBackground(bgImage);
			  button.setOpacity(1.0);
		  }else {

			  shootFrameTime.stop();
		  }
		  //nächste bild
			frameCount++;
	  

	  }
	  
	  
	  private void iceTowerAnimation(MyButton button) {
		 frameCount = 0;
		//-------------------- 
		 //alle 10ms wird ddas bild gewechselt
		 shootFrameTime = new Timeline(new KeyFrame(Duration.seconds(5), ev -> {			
			   setIceTowerImg(button);
	  	}));
		 shootFrameTime.setCycleCount(Animation.INDEFINITE);
		 shootFrameTime.play();
		  
		 
		  
		//---------------------------  
		  
		//wenn komplette animation der explosion fertig ist  -> 2sec
		 shootTime = new Timeline(new KeyFrame(Duration.seconds(0.4), ev -> {			
  	    	//resetAll();
			 shootTime.stop();
  	    }));		
		//exploTime.setCycleCount(-1);
		 shootTime.play();
		
		//-------------------------
		  
	  }
	  
	  void setIceTowerImg(MyButton button) {
		  if(frameCount<dm.getAllIceShotFramesSize()) {
			  String str = dm.getIceShotFramesAt(frameCount);
			  File file  = new File(str);
			  Image img  = new Image(file.toURI().toString());     
			  BackgroundImage bgi = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
			  Background bgImage = new Background(bgi);
			  button.setBackground(bgImage);
			  button.setOpacity(1.0);
		  }else {

			  shootFrameTime.stop();
		  }
		  //nächste bild
			frameCount++;
	  }
	  
	  private void windTowerAnimation(MyButton button) {
		 frameCount = 0;
		//-------------------- 
		 //alle 10ms wird ddas bild gewechselt
		 shootFrameTime = new Timeline(new KeyFrame(Duration.seconds(5), ev -> {			
			   setWindTowerImg(button);
	  	}));
		 shootFrameTime.setCycleCount(Animation.INDEFINITE);
		 shootFrameTime.play();
		  
		 
		  
		//---------------------------  
		  
		//wenn komplette animation der explosion fertig ist  -> 2sec
		 shootTime = new Timeline(new KeyFrame(Duration.seconds(0.4), ev -> {			
  	    	//resetAll();
			 shootTime.stop();
  	    }));		
		//exploTime.setCycleCount(-1);
		 shootTime.play();
		
		//-------------------------
		  
	  }
	  
	  void setWindTowerImg(MyButton button) {
		  if(frameCount<dm.getAllWindShotFramesSize()) {
			  String str = dm.getWindShotFramesAt(frameCount);
			  File file  = new File(str);
			  Image img  = new Image(file.toURI().toString());     
			  BackgroundImage bgi = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
			  Background bgImage = new Background(bgi);
			  button.setBackground(bgImage);
			  button.setOpacity(1.0);
		  }else {

			  shootFrameTime.stop();
		  }
		  //nächste bild
			frameCount++;
	  
	  }

	  private void TeslaTowerAnimation(MyButton button) {
		  frameCount = 0;

		 shootFrameTime = new Timeline(new KeyFrame(Duration.seconds(5), ev -> {			
			   setTeslaTowerImg(button);
	  	
		 }));
		 shootFrameTime.setCycleCount(Animation.INDEFINITE);
		 shootFrameTime.play();
		  
		 

		 shootTime = new Timeline(new KeyFrame(Duration.seconds(0.4), ev -> {			

			 shootTime.stop();
  	    }));		

		 shootTime.play();

		  
	  }
	  
	  void setTeslaTowerImg(MyButton button) {
		  if(frameCount<dm.getAllTeslaShotFramesSize()) {
			  String str = dm.getTeslaShotFramesAt(frameCount);
			  File file  = new File(str);
			  Image img  = new Image(file.toURI().toString());     
			  BackgroundImage bgi = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
			  Background bgImage = new Background(bgi);
			  button.setBackground(bgImage);
			  button.setOpacity(1.0);
		  }else {

			  shootFrameTime.stop();
		  }
		  //nächste bild
			frameCount++;
	  }

}
