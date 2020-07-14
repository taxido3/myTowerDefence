package tools;

import dataclasses.HitBox;
import javafx.scene.control.Button;

public class MyButton extends Button {


		public int index;
		private HitBox HitBox = null;
		public boolean isOn;
		
		public int getIndex() {return index;}

		public void setIndex(int index) {this.index = index;}

		public boolean isOn() {return isOn;}

		public void setOn(boolean isOn) {this.isOn = isOn;}

		
		public HitBox getHitBox() {return HitBox;}

		public void setHitBox(HitBox HitBox) {this.HitBox = HitBox;}

		public MyButton() {isOn = false;}
		
		public MyButton(int index) {
			this.index=index;
			isOn = false;				
		}
	

}
