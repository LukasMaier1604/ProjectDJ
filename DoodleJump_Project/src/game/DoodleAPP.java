package game;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;

import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class DoodleAPP extends JFrame{

	private JPanel contentPane;
	private Overlay myOverlay;
	private DoodleBackground umgebung;
	private ArrayList<DoodleObject> objects;
	private ArrayList<DoodleObject> objectsActive = new ArrayList<>();
	private Engine engine;
	private int score = 20;
	private Timer timer;
	private ArrayList<Integer> keysPressed = new ArrayList<>();
	private boolean spielLauft = true;





	public DoodleAPP() {

		umgebung = new DoodleBackground(350, 500);								// OPEN TO DO

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		contentPane.add(panel_1, BorderLayout.CENTER);

		setResizable(false);
		setTitle("DoodleJump");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 10, 350, 500);


		myOverlay = new Overlay(umgebung);								//ï¿½hnlich dem Canvas, funktioniert hier noch nicht. bin noch
		panel_1.add(myOverlay);											//nich sicher ob, dass bei den Plattformen helfen kann.
																		// dazu: Klasse App kann noch nicht gestartet werden. IMG mï¿½sste da sein
		this.objects = umgebung.getObjects();
//		for(int i =0; i<= objects.size(); i++) {
//			objectsActive.add(objects.get(i));
//		}


//		objectsActive = (ArrayList<DoodleObject>) objects.clone();

//		objectsActive.addAll(objects);


		setEngine();


		for(int i =0; i<1;i++) {
			umgebung.generateStartingPlatform();
			for(DoodleObject o: objects) {
				objectsActive.add(o);
			}
			this.keyControl();
			
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}




	public void jump() {
		engine.platformActive(this.objectsActive, umgebung.getObjects());
		if ((engine.checkCollision(objectsActive)) && (umgebung.getPlayer().getSpeed() > 0)) {
//			addPlatform();
			umgebung.getPlayer().setSpeed(-24); 
//			Beschleunigung des Spielers
			finished(umgebung.getPlayer());
//			if (spielLauft == false) dispose();							// hier bin ich dran, das fenster soll ich sich schließen und Rückkehr
																		//zum Hauptmenue

		}

	}

	public void addPlatform() {
		umgebung.generateRadomPlatform(score);
		engine.platformActive(this.objectsActive, this.objects);
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

	public void objektSteuern() {
		keyControl();
	}

	public void keyControl(){

		final int frames =10;
		timer= new Timer (frames, new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e){
				updatePosition(frames);
				umgebung.moveAll();
				jump();

				myOverlay.repaint();
				
				
			}
		});
		timer.start();


		DoodleKeyEventDispatcher playerDispatcher = new DoodleKeyEventDispatcher (keysPressed);
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(playerDispatcher);

	}

	public boolean getStatus() {
		return spielLauft;
	}

	public void updatePosition(int frameTime) {
		for (int key : keysPressed){
			if( key == KeyEvent.VK_LEFT){
				umgebung.getPlayer().moveLeft(frameTime);
//				jump();
//				System.out.println(engine.platformActive(this.objectsActive, this.objects));

			}
			if( key == KeyEvent.VK_RIGHT){
				umgebung.getPlayer().moveRight(frameTime);
//				jump();
				
			}
		}
	}


	public boolean finished(DoodlePlayer player) {
		
		
		if(umgebung.bottomReached(umgebung.getPlayer()))
		{
			JOptionPane.showMessageDialog(null, "Das Spiel ist beendet");
			spielLauft = false;
			return true;
//			System.out.println("ende");
		}
		
		return true;
	}






}
