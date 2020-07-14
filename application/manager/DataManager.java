package manager;


import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dataclasses.Highscore;
import dataclasses.MonsterTyp;
import dataclasses.TowerTyp;

public class DataManager {
	ArrayList<MonsterTyp> monsterTypen = new ArrayList<MonsterTyp>();
	ArrayList<TowerTyp> towerTyps = new ArrayList<TowerTyp>();
	ArrayList<Highscore> allHighscore = new ArrayList<Highscore>();
	ArrayList<String> allFireShotFrames = new ArrayList<String>();
	ArrayList<String> allTeslaShotFrames = new ArrayList<String>();
	ArrayList<String> allWindShotFrames = new ArrayList<String>();
	ArrayList<String> allIceShotFrames = new ArrayList<String>();
		
	StartViewController startView;
	
	public DataManager() {
		
		loadMonsterTypData();
		loadTowerTypData();
		loadFrameData();
	}
	
	public DataManager(StartViewController startView) {
		
		this.startView = startView;
		loadMonsterTypData();
		loadTowerTypData();
		loadFrameData();
	}
	
	
	void loadMonsterTypData() {
		
		MonsterTyp normal = new MonsterTyp(0, "Normal", false, 2, 10, 2, "../img/Enemys/normalPortrait.png", "file:///../img/enemy/normalEnemy.png");
		MonsterTyp flying = new MonsterTyp(1, "Flying", true, 1, 7, 5, "../img/Enemys/flyingPortrait.jpg", "file:///../img/enemy/flyingEnemy.png");
		MonsterTyp fast = new MonsterTyp(2, "Fast", false, 3, 10, 5, "../img/Enemys/fastPortrait.jpeg", "file:///../img/enemy/fastEnemy.png");
		MonsterTyp faster = new MonsterTyp(3, "Faster", false, 5, 9, 5, "../img/Enemys/fasterPortrait.jpeg", "file:///../img/enemy/fasterEnemy.png");
		MonsterTyp slow = new MonsterTyp(4, "Slow", false, 2, 15, 1, "../img/Enemys/slowPortrait.jpeg", "file:///../img/enemy/fastEnemy.png");
		
		monsterTypen.add(normal);
		monsterTypen.add(flying);
		monsterTypen.add(fast);
		monsterTypen.add(faster);
		monsterTypen.add(slow);
		
	}
	
	void loadTowerTypData() {
		
		TowerTyp standard = new TowerTyp(0, 0, "Standard",  1, 2, 1, 10,"file:///../img/Tower/StandardTower.png","file:///../img/Tower/StandardTower.png");
		TowerTyp fire = new TowerTyp(1, 1, "Feuer", 3, 2, 1, 20,"file:///../img/Tower/FireTower_.png","file:///../img/Tower/FireTower_.png");
		TowerTyp ice = new TowerTyp(2, 2, "Eis", 1, 2, 1, 15,"file:///../img/Tower/IceTower_.png","file:///../img/Tower/IceTower_.png");
		TowerTyp wind = new TowerTyp(3, 3, "Wind", 1, 2, 2, 20,"file:///../img/Tower/WindTower_.png","file:///../img/Tower/WindTower_.png");
		TowerTyp tesla = new TowerTyp(4, 4, "Tesla", 1, 2, 2, 20,"file:///../img/Tower/TeslaTower_.png","file:///../img/Tower/TeslaTower_.png");

		towerTyps.add(standard);
		towerTyps.add(fire);
		towerTyps.add(ice);
		towerTyps.add(wind);
		towerTyps.add(tesla);
	}
	
	void loadFrameData() {
		allFireShotFrames.add("file:///../img/Tower/FireTowerSprite/FireTower_01.png");
		allFireShotFrames.add("file:///../img/Tower/FireTowerSprite/FireTower_02.png");
		allFireShotFrames.add("file:///../img/Tower/FireTowerSprite/FireTower_03.png");
		allFireShotFrames.add("file:///../img/Tower/FireTowerSprite/FireTower_04.png");
		allFireShotFrames.add("file:///../img/Tower/FireTowerSprite/FireTower_05.png");
		allFireShotFrames.add("file:///../img/Tower/FireTowerSprite/FireTower_06.png");
		
		allTeslaShotFrames.add("file:///../img/Tower/TeslaTowerSprite/TeslaTower_01.png");
		allTeslaShotFrames.add("file:///../img/Tower/TeslaTowerSprite/TeslaTower_02.png");
		allTeslaShotFrames.add("file:///../img/Tower/TeslaTowerSprite/TeslaTower_03.png");
		allTeslaShotFrames.add("file:///../img/Tower/TeslaTowerSprite/TeslaTower_04.png");
		allTeslaShotFrames.add("file:///../img/Tower/TeslaTowerSprite/TeslaTower_05.png");
		allTeslaShotFrames.add("file:///../img/Tower/TeslaTowerSprite/TeslaTower_06.png");
		
		allWindShotFrames.add("file:///../img/Tower/WindTowerSprite/WindTower_01.png");
		allWindShotFrames.add("file:///../img/Tower/WindTowerSprite/WindTower_02.png");
		allWindShotFrames.add("file:///../img/Tower/WindTowerSprite/WindTower_03.png");
		allWindShotFrames.add("file:///../img/Tower/WindTowerSprite/WindTower_04.png");
		allWindShotFrames.add("file:///../img/Tower/WindTowerSprite/WindTower_05.png");
		allWindShotFrames.add("file:///../img/Tower/WindTowerSprite/WindTower_06.png");
		
		allIceShotFrames.add("file:///../img/Tower/IceTowerSprite/IceTower_01.png");
		allIceShotFrames.add("file:///../img/Tower/IceTowerSprite/IceTower_02.png");
		allIceShotFrames.add("file:///../img/Tower/IceTowerSprite/IceTower_03.png");
		allIceShotFrames.add("file:///../img/Tower/IceTowerSprite/IceTower_04.png");
		allIceShotFrames.add("file:///../img/Tower/IceTowerSprite/IceTower_05.png");
		allIceShotFrames.add("file:///../img/Tower/IceTowerSprite/IceTower_06.png");				
	}
	
	  public ArrayList<String> getFireShotFrames(){ return allFireShotFrames;}
	  public int getAllFireShotFramesSize(){ return allFireShotFrames.size();}
	  public String getFireShotFramesAt(int index){ return allFireShotFrames.get(index);}
	  
	  public ArrayList<String> getAllTeslaShotFrames(){ return allTeslaShotFrames;}
	  public int getAllTeslaShotFramesSize(){ return allTeslaShotFrames.size();}
	  public String getTeslaShotFramesAt(int index){ return allTeslaShotFrames.get(index);}
	  
	  public ArrayList<String> getAllWindShotFrames(){ return allWindShotFrames;}
	  public int getAllWindShotFramesSize(){ return allWindShotFrames.size();}
	  public String getWindShotFramesAt(int index){ return allWindShotFrames.get(index);}
	  
	  public ArrayList<String> getAllIceShotFrames(){ return allIceShotFrames;}
	  public int getAllIceShotFramesSize(){ return allIceShotFrames.size();}
	  public String getIceShotFramesAt(int index){ return allIceShotFrames.get(index);}
	
	
	HTTPManager httpM = new HTTPManager(this); 
	public void loadData() {
		System.out.println("2. DM:start http");
		httpM.getDataFromHttp();
		
	}
	
	public void sendData(String tag, int wellen) {
		System.out.println("2.2 DM:start http");
		httpM.sendDatatoHttp(tag, wellen);
		
	}
	
	public void finishedLoadData(JsonArray arr) {
		  System.out.println(arr.get(0));
		  
		for(int i=0;i<arr.size();i++) {
			   JsonObject obj =  arr.get(i).getAsJsonObject();			             
			  
			   allHighscore.add(
					   new Highscore(
					         obj.get("id").getAsInt(),
					         obj.get("Tag").getAsString(),
					         obj.get("Wellen").getAsInt()					         
					       )			   
			           );					   
		}  
		  
			
		System.out.println("5. DM:data convert finished ");			
		startView.finishedLoadData();
			
	}
	
	public ArrayList<Highscore> getAllHighscore(){return allHighscore;}
	public int getAllHighscoreCount(){return allHighscore.size();}
	public Highscore getHighscoreAt(int index){return allHighscore.get(index);}
	
	public ArrayList<MonsterTyp> getAllMonsterTypen(){return monsterTypen;}
	public int getAllMonsterTypenCount(){return monsterTypen.size();}
	public MonsterTyp getMonsterTypenAt(int index){return monsterTypen.get(index);}
	
	public ArrayList<TowerTyp> getAllTowerTypen(){return towerTyps;}
	public int getAllTowerTypenCount(){return towerTyps.size();}
	public TowerTyp getTowerTypenAt(int index){return towerTyps.get(index);}
	
}
