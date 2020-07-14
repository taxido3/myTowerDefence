package dataclasses;


public class ProjektilTyp {
    private int projektilID;
    private String inGameimg;
    private double dmg;
    private String effekt;

    public int getProjektilID() { return projektilID; }
    public void setProjektilID(int value) { this.projektilID = value; }

    public String getInGameint() { return inGameimg; }
    public void setInGameint(String value) { this.inGameimg = value; }

    public double getDmg() { return dmg; }
    public void setDmg(double value) { this.dmg = value; }

    public String getEffekt() { return effekt; }
    public void setEffekt(String value) { this.effekt = value; }
}