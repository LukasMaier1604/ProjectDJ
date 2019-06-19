package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;

import javax.swing.border.EmptyBorder;

import controller.DoodleKeyEventDispatcher;
import controller.Engine;
import game.Closingclass;
import game.Spielstand;
import game.StartMenue;
import models.DoodleObject;
import models.DoodlePlayer;

import java.awt.GridLayout;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.TreeSet;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.io.*;
import java.net.*;


public class DoodleAPP extends JFrame implements Comparable{

	private JPanel contentPane;
	private Overlay myOverlay;
	private DoodleBackground umgebung;
	private ArrayList<DoodleObject> objects;
	private ArrayList<DoodleObject> objectsActive = new ArrayList<>();
	private Engine engine;
	private int score = 0;
	private Timer timer;
	private ArrayList<Integer> keysPressed = new ArrayList<>();
	private boolean spielLaeuft = true;
	private Closingclass cc;
	private int closeCommand;
	private StartMenue menue;
	private int ausgangSpeed;
	private int scorePosition = 1000;
	private JPanel panel;
	private JLabel scoreLabel;
	private JLabel lblScore;
	private Spielstand spielstand;

	public DoodleAPP(StartMenue menue) {
		this();
		this.menue = menue;
	}

	public DoodleAPP() {

		umgebung = new DoodleBackground(350, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setBackground(Color.WHITE);
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		contentPane.add(panel_1, BorderLayout.CENTER);

		setResizable(false);
		setTitle("DoodleJump");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 10, umgebung.getWidth(), umgebung.getHeight());


		myOverlay = new Overlay(umgebung);								//�hnlich dem Canvas, funktioniert hier noch nicht. bin noch
		panel_1.add(myOverlay);											//nich sicher ob, dass bei den Plattformen helfen kann.

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		lblScore = new JLabel("Score:  ");
		panel.add(lblScore);

		scoreLabel = new JLabel("New label");
		panel.add(scoreLabel);
																		// dazu: Klasse App kann noch nicht gestartet werden. IMG m�sste da sein
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
			this.keyControl();


//		umgebung.getConsoleObjects();

//		umgebung.newPlayerPoint(umgebung.newPlayerMoveUp(speed));



//		addPlatform();



	}
	public int getScore() {
		return score;
	}

	public Spielstand getSpielstand() {
		Spielstand spielen = new Spielstand();
		return spielen;
	}

	public DoodleBackground getUmgebung() {
		return umgebung;
	}
	public void setMainFrame() {
		setTitle("Doodle Jump");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}




	public boolean jump() {

		if ((engine.checkCollision(objects)) && (umgebung.getPlayer().getSpeed() > 0)) {
			umgebung.getPlayer().setSpeed(-14);
			addPlatform();
			if(engine.gleich) {
				umgebung.getPlayer().setSpeed(-17);
			}
			if (umgebung.getPlayer().getPoint().y <250) {
				umgebung.getPlayer().setSpeed(-10);
			}

			return true;

		}
		else return false;

	}

	public void addPlatform() {
		if(engine.gleich == false) {
			umgebung.generateRadomPlatform();
			scorePositionAnpassung();
			if(umgebung.getPlayer().getSpeed()<0 && scorePosition> umgebung.getPlayer().getPoint().y) {
				score++;
				scorePosition = umgebung.getPlayer().getPoint().y;
			}

		}
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

	public StartMenue returnSM() {
		return menue;
	}

	public void setcloseCommand(int eingabe){
		closeCommand = eingabe;
	}

	public void keyControl(){

		final int frames =10;
		timer= new Timer (frames, new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e){
				if(spielLaeuft == true) {
					setMovement(frames);
					setPhysics();
					setView();
					System.out.println(score);

					try {
						finished(umgebung.getPlayer());
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


					myOverlay.repaint();
					}else {
						switching(closeCommand);
				}
			}
		});


		timer.start();


		DoodleKeyEventDispatcher playerDispatcher = new DoodleKeyEventDispatcher (keysPressed);
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(playerDispatcher);

	}
	public void setMovement(int frames) {
		umgebung.teleportToBorder();
		umgebung.moveAll();
		updatePosition(frames);
	}
	public void setPhysics() {
		jump();
		addPlatform();
	}
	public void setView() {
		moveView();
		updateScoreLabel();
	}

	public boolean getStatus() {
		return spielLaeuft;
	}

	public void updatePosition(int frameTime) {
		for (int key : keysPressed){
			if( key == KeyEvent.VK_LEFT){
				umgebung.getPlayer().moveLeft(frameTime);
			}
			if( key == KeyEvent.VK_RIGHT){
				umgebung.getPlayer().moveRight(frameTime);
			}
		}
	}

	public void switching(int var){

		switch (var){
		case 1:
			this.dispose();
			break;
		case 2: System.exit(1);
			break;
		case 3:
//			this.dispose();
//			try {
//				DoodleAPP appNeu = new DoodleAPP();
//				appNeu.setVisible(true);
//				}catch(Exception o) {
//					o.printStackTrace();
//				};
			break;
		default:;
					}

	}

	public void finished(DoodlePlayer player) throws InterruptedException {


		if(umgebung.bottomReached(player))
		{
			serverLog(menue.getTextFromField(),score);
			spielLaeuft = false;

//			int choice = JOptionPane.showConfirmDialog(null, "Game Over. Wohingenau?", "Game Over",JOptionPane.YES_NO_CANCEL_OPTION);
//			System.out.println(choice);
//

			try {
				cc = new Closingclass(this);
				cc.setVisible(true);
			}catch(Exception o) {
				o.printStackTrace();
		}
			
			
			









//			this.addWindowListener(new WindowAdapter(){
//
//				@Override
//				public void windowClosing(WindowEvent e) {
//
//						cc = new Closingclass();
//						int result = JOptionPane.showConfirmDialog(
//						           cc,
//						            "Spiel beendet. Zur�ck zum Hauptmen�",
//						            "Exit Application",
//						            JOptionPane.YES_NO_OPTION);
//
//						if (result == JOptionPane.YES_OPTION)
//				            cc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//						}
//				});
//
//			cc.setVisible(true);
		}
	}
	public  void serverLog(String player, int score) {
		String hostName = "localhost";
		int port = 4711;
		
		
		try (Socket socket = new Socket(hostName, port)){
			BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
			PrintWriter socketOut = new PrintWriter(socket.getOutputStream(), true); 
			
			
		
			socketOut.println("Der Spieler: " + player +" hat einen Score von "+ score+ " Punkten erreicht" );		

		} 
		catch (UnknownHostException ue) {
			System.out.println("Kein DNS-Eintrag fuer " + hostName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
	}


	public void moveView() {
		if (umgebung.getPlayer().getPoint().y < 250) {
			for( DoodleObject o : umgebung.getObjects()){
				if(!o.equals(umgebung.getPlayer())) {
					o.setSpeed(moveUpSpeed());
					if(umgebung.getPlayer().getPoint().y < 70) {
						umgebung.getPlayer().setSpeed(5);
						o.setSpeed(4);
					}

				}
			}
		}
		if(umgebung.getPlayer().getPoint().y > 300) {
			for( DoodleObject o : umgebung.getObjects()){
				if(!o.equals(umgebung.getPlayer())) o.setSpeed(0);
			}
		}
		if (umgebung.getPlayer().getPoint().y < 0)
			for( DoodleObject o : umgebung.getObjects()){
				if(!o.equals(umgebung.getPlayer())) o.setSpeed(10);
			}
		if (umgebung.getPlayer().getPoint().y <20) umgebung.getPlayer().setSpeed(0);


//		if (umgebung.getPlayer().point.y <= 200 && engine.gleich == false){
//			for( DoodleObject o : umgebung.getObjects()){
//				if(!o.equals(umgebung.getPlayer()))
//					if(umgebung.getPlayer().getSpeed() <0) o.setSpeed((umgebung.getPlayer().getSpeed())*-1);
//
//			}
//
//		}
//		if (umgebung.getPlayer().point.y > 200){
//			for( DoodleObject o : umgebung.getObjects()){
//				if(!o.equals(umgebung.getPlayer())) o.setSpeed(0);
//
//			}
//		}
	}
	public int moveUpSpeed() {
		ausgangSpeed = umgebung.getPlayer().getSpeed();
		if(ausgangSpeed < 0) {
			ausgangSpeed = ausgangSpeed*-1;
			return ausgangSpeed;
		}
		else return 0;


	}



	public void scorePositionAnpassung() {

		System.out.println(scorePosition + "Score Anpassung");
		scorePosition =((umgebung.getObjectSpeed())+scorePosition);

	}




	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public void updateScoreLabel() {

		scoreLabel.setText(String.valueOf(score));
		panel.repaint();
	}

}
