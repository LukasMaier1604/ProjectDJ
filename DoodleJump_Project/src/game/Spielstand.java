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
		highscore.put("Rüdiger", 1600);
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

	public Map<String, Integer> dontDoIt() {
		try (FileInputStream fileInput = new FileInputStream(
				new File(System.getProperty("user.home") + "\\Desktop\\ScoreList.ser"));
				ObjectInputStream objInputstream = new ObjectInputStream(fileInput)) {
			return (Map<String, Integer>)objInputstream.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return highscore;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}
} 	 

