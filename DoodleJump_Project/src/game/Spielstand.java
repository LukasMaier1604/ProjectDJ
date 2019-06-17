package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Spielstand implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map <String, Integer> highscore = new HashMap<String, Integer>(); 

	public Spielstand() {
		highscore.put("Heinz", 100);
		highscore.put("Lukas", 1);
		highscore.put("Gustav", 5);
		highscore.put("Karli", 1600);
	}
	
	public Map<String, Integer> returnHardCode(){
		return highscore;
	}
	
//	public String getKey(Map<String, Integer> map) {
//		return map.entrySet().;
//	}
	
	public void getEntry() {
//		Map<String, Integer> newbe = new HashMap<>();
		for(Map.Entry<String, Integer> entry : highscore.entrySet()) {
			System.out.println(entry.getKey()+ " - "+ entry.getValue());
//			return newbe..put(entry.getKey(), entry.getValue());
	}}
	
	public void doIt(Map<String, Integer> finalScores) {
		try (FileOutputStream file = new FileOutputStream(new File(System.getProperty("user.home") + "\\ScoreList.ser"));
			ObjectOutputStream objOutputStream = new ObjectOutputStream(file);) {
			objOutputStream.writeObject(finalScores);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public Map<String, Integer> dontDoIt() {
		try (FileInputStream fileInput = new FileInputStream(
				new File(System.getProperty("user.home") + "\\ScoreList.ser"));
				ObjectInputStream objInputstream = new ObjectInputStream(fileInput)) {
			return (Map<String, Integer>)objInputstream.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Map<String, Integer> temp = new HashMap<>();
			temp.put("unknown", 0);
			return temp;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}

	public Map<String, Integer> sortiereHashMap(Map<String, Integer> map){
		
		Object[] files = map.keySet().toArray();
		Map<String, Integer> var= new HashMap<>();
		
		map.values();										//das könnte die lösung sein
		
		
		for(int i=1; i<map.size(); i++) {
			for(int j=0; j<map.size() - 1; j++) {
				if(map.get(files[j])>map.get(files[j+1])) {
					var.put(String.valueOf(files[j]), map.get(files[j]));
					map.remove(String.valueOf(files[j]), map.get(files[j]));
					System.out.println(String.valueOf(files[j]));
					map.putAll(var);
				}
			}
		}
		if(map.size() >5 ) {
			map.remove(String.valueOf(files[5]));
		}
		return map;
	}
}	

