package tools;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MyLabel extends Label{
	private int index;	
	
	public MyLabel(int index) { 
		this.index = index;	
		setPrefSize(134, 40);
		setFont(Font.font("Arial", FontWeight.BOLD, 24));
		setTextFill(Color.web("#0076a3"));
	
	
	
	
	}
	
	
	public int getIndex() {	return index;	}
	public void setIndex(int index) { this.index = index;	} 
}
