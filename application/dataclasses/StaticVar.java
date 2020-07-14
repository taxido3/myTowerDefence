package dataclasses;

import java.util.ArrayList;

import tools.MonsterBox;

public class StaticVar {

	public static Spielstatistik player1 = new Spielstatistik(0, 20, 2, 20);
	public static ArrayList<MonsterBox> allMonster = new ArrayList<MonsterBox>();
	public static ArrayList<MainTower> allTowers = new ArrayList<MainTower>();

	public static ArrayList<MonsterBox> getAllMonster(){return allMonster;}
	public static int getMonsterCount(){return allMonster.size();}
	public static MonsterBox getMonsterAt(int index){return allMonster.get(index);}
	
	public static ArrayList<MainTower> getAllTower(){return allTowers;}
	public static int getTowerCount(){return allTowers.size();}
	public static MainTower getTowerAt(int index){return allTowers.get(index);}

}
