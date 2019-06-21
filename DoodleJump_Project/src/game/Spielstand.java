package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Spielstand implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map <String, Integer> highscore = new HashMap<String, Integer>(); 

	public Spielstand() {
	}
	
	public Map<String, Integer> returnHardCode(){
		return highscore;
	}

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

//	public void sortiereHashMap(String s, int score){
//	}

}	

