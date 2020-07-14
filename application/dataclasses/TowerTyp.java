package dataclasses;


public class TowerTyp {

	private int typID;
    private int projektilID;
    private String name;
    private int dmg;
    private double attackRadius;
    private double attackSpeed;
    private int preis;
    private String portrait;
    private String inGamImg;
    
    public TowerTyp(int typID, int projektilID, String name, int dmg, double attackRadius,
			double attackSpeed, int preis, String portrait, String inGamImg) {
		super();
		this.typID = typID;
		this.projektilID = projektilID;
		this.name = name;
		this.dmg = dmg;
		this.attackRadius = attackRadius;
		this.attackSpeed = attackSpeed;
		this.preis = preis;
		this.portrait = portrait;
		this.inGamImg = inGamImg;
	}
    
    

    public int getTypID() { return typID; }
    public void setTypID(int value) { this.typID = value; }

    public int getProjektilID() { return projektilID; }
    public void setProjektilID(int value) { this.projektilID = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public int getDmg() { return dmg; }
    public void setDmg(int value) { this.dmg = value; }

    public double getAttackRadius() { return attackRadius; }
    public void setAttackRadius(double value) { this.attackRadius = value; }

    public double getAttackSpeed() { return attackSpeed; }
    public void setAttackSpeed(double value) { this.attackSpeed = value; }

    public int getPreis() { return preis; }
    public void setPreis(int value) { this.preis = value; }

    public String getPortrait() { return portrait; }
    public void setPortrait(String value) { this.portrait = value; }

    public String getInGamImg() { return inGamImg; }
    public void setInGamImg(String value) { this.inGamImg = value; }
}