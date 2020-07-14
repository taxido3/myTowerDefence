package dataclasses;



public class MainMonster {

	private int id;
	private int lp;
	private double xKoord;
	private double yKoord;

	
	
	public MainMonster(int id, int lp, double xKoord, double yKoord) {
		super();
		this.id = id;
		this.lp = lp;
		this.xKoord = xKoord;
		this.yKoord = yKoord;
		

	}


	public MainMonster() {}


	public int getId() {return id;}


	public void setId(int id) {this.id = id;}


	public int getLp() {return lp;}


	public void setLp(int lp) {this.lp = lp;}


	public double getxKoord() {return xKoord;}


	public void setxKoord(double xKoord) {this.xKoord = xKoord;}


	public double getyKoord() {return yKoord;}


	public void setyKoord(double yKoord) {this.yKoord = yKoord;}
	
	
	

}
