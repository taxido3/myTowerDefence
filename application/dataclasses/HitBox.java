package dataclasses;

public class HitBox {


	private int id;
	private int xKoord;
	private int yKoord;
	private boolean belegt = false;
	private int monsterId;
	private int towerId;
	
    
	public HitBox(int id, int xKoord, int yKoord) {
		super();
		this.id = id;
		this.xKoord = xKoord;
		this.yKoord = yKoord;
	}
	
	public int getMonsterId() {
		return monsterId;
	}

	public void setMonsterId(int monsterId) {
		this.monsterId = monsterId;
	}

	public int getTowerId() {
		return towerId;
	}

	public void setTowerId(int towerId) {
		this.towerId = towerId;
	}

	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
		
	public int getxKoord() {
		return xKoord;
	}

	public void setxKoord(int xKoord) {
		this.xKoord = xKoord;
	}

	public int getyKoord() {
		return yKoord;
	}

	public void setyKoord(int yKoord) {
		this.yKoord = yKoord;
	}

	public boolean isBelegt() {
		return belegt;
	}

	public void setBelegt(boolean belegt) {
		this.belegt = belegt;
	}	    
	    
		
    /*		
	    void createHitBoxes() {
        	int x = 0;
        	int y = 0;

        	for(int i = 0; i < 1221; i++) {
        	
        		x = 0 + (i/15);
        		this.xBoxen[i] = (int)x;		
        	}
        
        	for(int i = 0; i < 506; i++){
        		y = 0 + (i/15);
        		this.yBoxen[i] = (int)y;
        	
        	}
        
        	for(int i = 0; i < 34; i++) {
        		for(int k = 0; k < 81; k++)
        		{
        			this.hitBoxen[i][k]=false; 	
        		}
        	
        	}
        
       
            
    boolean[][] spielfeld = new boolean[34][81];
    		[506][1221];
    [2754] */
    
	}


