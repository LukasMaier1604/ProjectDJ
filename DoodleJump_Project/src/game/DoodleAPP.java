package game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;

public class DoodleAPP extends JFrame{
	
	private JPanel contentPane;
	private Overlay myOverlay;
	private DoodleBackground umgebung;
	private ArrayList<DoodleObject> objects;
	private ArrayList<DoodleObject> objectsActive = new ArrayList<>(); 
	private Engine engine;
	private int score = 20;
	private int speed = -128;
	private Timer timer;
	
	

	
	public DoodleAPP() {
		
		umgebung = new DoodleBackground(400, 800);								// OPEN TO DO

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 350, 500);
		
		
		myOverlay = new Overlay(umgebung);								//ähnlich dem Canvas, funktioniert hier noch nicht. bin noch 
		panel_1.add(myOverlay);											//nich sicher ob, dass bei den Plattformen helfen kann.
																		// dazu: Klasse App kann noch nicht gestartet werden. IMG müsste da sein
		this.objects = umgebung.getObjects();
//		for(int i =0; i<= objects.size(); i++) {
//			objectsActive.add(objects.get(i));
//		}
		
		
//		objectsActive = (ArrayList<DoodleObject>) objects.clone();
		
//		objectsActive.addAll(objects);
		
		
		setEngine();
		
		
		for(int i =0; i<1;i++) {
			umgebung.generateStartingPlatform();
		}
		
//		umgebung.getConsoleObjects();
		
//		umgebung.newPlayerPoint(umgebung.newPlayerMoveUp(speed));
		
		
		
//		addPlatform();
		
		
		
	}


	public DoodleBackground getUmgebung() {
		return umgebung;
	}
	public void setMainFrame() {
		setTitle("Doodle Jump");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
	
	public void movePlayer() {
		if (engine.checkCollision(objectsActive)) {
			addPlatform();
//			Beschleunigung des Spielers
			
		}
		
	}
	
	public void addPlatform() {
		umgebung.generateRadomPlatform(score);
		System.out.println(engine.platformActive(this.objectsActive, umgebung.getObjects()));
	}
	
	public ArrayList<DoodleObject> getObjects(){
		return objects;
	}
	public void setEngine() {
		engine = new Engine (this);
		
	}
	
	public void updateList() {
		this.objects = umgebung.getObjects();
	}
	
	
	
	
	
	
	

}
