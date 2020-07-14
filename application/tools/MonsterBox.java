package tools;

import java.io.File;
import dataclasses.StaticVar;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import manager.DataManager;

public class MonsterBox extends Pane {		
		
		private int index;
		@FXML
		private ImageView  imgView; 
		private String     imgPath;
		private int hp;
		DataManager dm = new DataManager();
		
		public MonsterBox() {}
		
		public MonsterBox(int index, String imgPath, int hp){
			this.index = index;
			this.imgPath = imgPath;
			this.hp = hp;
		}
	
		public int getHp() {
			return hp;
		}
		public void setHp(int hp) {
			this.hp = hp;
		}

		public ImageView getImgView() {return imgView;}

		public void setImgView(ImageView imgView) {this.imgView = imgView;}

		public int getIndex() {return index;}
		public void setIndex(int index) {this.index = index;}
		
		
		public void createImageView() {
				
			
				imgView = new ImageView();
				File f = new File(imgPath);
				Image img = new Image(f.toURI().toString());
			
				//Image img = new Image(imgPath);    
				imgView.setImage(img);				    
				imgView.setX(0);			      
				imgView.setY(0);
				//imgView.setFitHeight(150);
				//imgView.setFitWidth(150);
				imgView.setVisible(true);
				imgView.setOpacity(1.0);
				imgView.getTransforms().add(new Rotate(270, 50, 270));
				this.getChildren().add(imgView);
				System.out.println("Monster erzeugt");

				//setEvent(); //Event, wenn der Tower das Monster gekilled hat (Dennis)
		}
		
		public void setImgSize(double w,double h) {
			 imgView.setFitHeight(h);
		     imgView.setFitWidth(w);
		}
		
		public void setImgSize() {
			 imgView.setFitHeight(this.getPrefWidth());
		     imgView.setFitWidth(this.getPrefHeight());
		}
		
		double xSpeed = 1.0; //pixelversatz pro veränderung
		
		private double xPos;
		 public void moveX(Pane paneGamefield) {
			  //1.alten wert auslesen
			     xPos = getLayoutX();
			  //2. alten wert verÃ¤ndern -> neuer neuer
			     xPos -= xSpeed;
			  //3. neuen wert prüfen
			  //wenn box unten aus der szene gefahren ist
			     if(xPos <= 280) { //wert sicherlich falsch
			    	 StaticVar.player1.loseLeben(1);
			    	 System.out.println(StaticVar.player1.getLeben());
			    	 deleteMonster(paneGamefield);
			     }
			     
			     setLayoutX(xPos);
			     
		  }	
		
		public void monsterDie(Pane paneGamefield) {
			StaticVar.getAllMonster().remove(this);
			paneGamefield.getChildren().remove(this);
			deleteMonster(paneGamefield);
			StaticVar.player1.setGold(StaticVar.player1.getGold()+1);
		  	    	 
		  	     }
		
		public void deleteMonster(Pane paneGamefield) {
			
			paneGamefield.getChildren().remove(this);
			StaticVar.getAllMonster().remove(this);

	
		}
		
		public void loseLife(int dmg, Pane paneGamefield, int TowerId) {
			this.hp = this.hp-dmg;
		}
		

		  		  		  		  		  		  
		  
/*		  private double ySpeed;
		  private double yPos;
		  private void resetAll(){
			     yPos = -100;
			     setLayoutY(yPos);	
		    	 //zufällig speed ändern
		    	 double rdouble = Math.random();
		    	// (rdouble * (max-min))+min
		    	 ySpeed = (rdouble * (20-5))+5;
		    	 //zufällig size ändern
		    	 //zufällig xpos ändern
		    	       rdouble = Math.random();
			    	// (rdouble * (max-min))+min
		    	 setLayoutX( (rdouble * (800-100))+100 );
		    	 //zufällig bild ändern
		    	 changeImg();
		  }
	*/	  
	}

		  	

