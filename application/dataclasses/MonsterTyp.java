package dataclasses;


public class MonsterTyp {

	private int typID;
    private String name;
    private boolean flying;
    private int goldLoot;
    private int hp;
    private double movSpeed;
    private String portrait;
    private String inGamImg;
    
    public MonsterTyp(int typID, String name, boolean flying, int goldLoot, int hp, double movSpeed,
			String portrait, String inGamImg) {
		super();
		this.typID = typID;
		this.name = name;
		this.flying = flying;
		this.goldLoot = goldLoot;
		this.hp = hp;
		this.movSpeed = movSpeed;
		this.portrait = portrait;
		this.inGamImg = inGamImg;
	}

    public int getTypID() { return typID; }
    public void setTypID(int value) { this.typID = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public boolean getFlying() { return flying; }
    public void setFlying(boolean value) { this.flying = value; }

    public int getGoldLoot() { return goldLoot; }
    public void setGoldLoot(int value) { this.goldLoot = value; }

    public int getHP() { return hp; }
    public void setHP(int value) { this.hp = value; }

    public double getMOVSpeed() { return movSpeed; }
    public void setMOVSpeed(double value) { this.movSpeed = value; }

    public String getPortrait() { return portrait; }
    public void setPortrait(String value) { this.portrait = value; }

    public String getInGamImg() { return inGamImg; }
    public void setInGamImg(String value) { this.inGamImg = value; }
}