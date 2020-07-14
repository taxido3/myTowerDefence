package dataclasses;

public class Highscore {
	private int id;
	private String tag;
	private int wellen;
	
		public Highscore() {
			// TODO Auto-generated constructor stub
		}
		
		public Highscore(int id, String tag,int wellen) {
			this.id = id;
			this.tag = tag;
			this.wellen = wellen;
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTag() {
			return tag;
		}
		public void setTag(String tag) {
			this.tag = tag;
		}
		public int getWellen() {
			return wellen;
		}
		public void setWellen(int wellen) {
			this.wellen = wellen;
		}
	}


