package manager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class HTTPManager {

	DataManager dm;
	
	
	public HTTPManager(DataManager dm) {
		// TODO Auto-generated constructor stub
		
		this.dm = dm;
		
	}
	
	
	public void getDataFromHttp()  {
		JsonArray array = new JsonArray();
		System.out.println("3. HTTP:load from server http");
		// TODO Auto-generated method stub
		
        //1.hole Daten von Http mit Inputstream
		try {
			String jsonString = readUrl("http://127.0.0.1/java/getAllHighscore.php");
		
			JsonParser parser = new JsonParser();
			    array = parser.parse(jsonString).getAsJsonArray(); //wenn [ -KLammer am Beginn der Ausgabe
			    //array = parser.parse(jsonString).getAsJsonObject();//wenn { -KLammer am Beginn der Ausgabe
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2. wandel die Daten in das gegebene Format
		//(XML,Json,Eigenes)
	    //3. sage DataManager bescheid 
		//wenn alles fertig ist
		System.out.println("4. HTTP:load finished");
		dm.finishedLoadData(array);
		
	}
	
	
	public void sendDatatoHttp(String tag, int wellen) {
		// TODO Auto-generated method stub
		try {
			//System.out.println(readUrl("http://127.0.0.1:8080/java/getAllPlaces.php"));
			String str = readUrl("http://127.0.0.1/java/insertIntoHighscore.php?param1="+tag+"&param2="+wellen);
			System.out.println("Antwort:"+str);			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	
	//====================== -Hilfs-Methoden- =====================================
	
	private static String readUrl(String urlString) throws Exception {
	    
		BufferedReader reader = null;
		    try {
		        URL url = new URL(urlString);
		        reader = new BufferedReader(new InputStreamReader(url.openStream()));
		        StringBuffer buffer = new StringBuffer();
		        int read;
		        char[] chars = new char[1024];
		        while ((read = reader.read(chars)) != -1)
		            buffer.append(chars, 0, read); 

		        return buffer.toString();	        
		    } 
		    
		    finally {
		    	if (reader != null)
	            reader.close();
		    }
	}
	
	
	
}