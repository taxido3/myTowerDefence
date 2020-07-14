package dataclasses;


public class Spielstatistik {

	private int wellenCounter;
    private int gold;
    private int leben;
    private int wellenCountdown;
    
    public Spielstatistik(int wellenCounter, int gold, int leben, int wellenCountdown) {
		super();
		this.wellenCounter = wellenCounter;
		this.gold = gold;
		this.leben = leben;
		this.wellenCountdown = wellenCountdown;
	}

    public int getWellenCounter() { return wellenCounter; }
    public void setWellenCounter(int value) { this.wellenCounter = value; }

    public int getGold() { return gold; }
    public void setGold(int value) { this.gold = value; }

    public int getLeben() { return leben; }
    public void setLeben(int value) { this.leben = value; }
    
    public void loseLeben(int value) { this.leben = this.leben-value; };

    public int getWellenCountdown() { return wellenCountdown; }
    public void setWellenCountdown(int value) { this.wellenCountdown = value; }
}