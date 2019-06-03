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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
	private boolean spielLaeuft = true;
	private Closingclass cc;
	private int closeCommand = 0;
	public int runTime = 10;





	public DoodleAPP() {

		umgebung = new DoodleBackground(350, 500);

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


		myOverlay = new Overlay(umgebung);								//�hnlich dem Canvas, funktioniert hier noch nicht. bin noch
		panel_1.add(myOverlay);											//nich sicher ob, dass bei den Plattformen helfen kann.
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


	public DoodleBackground getUmgebung() {
		return umgebung;
	}
	public void setMainFrame() {
		setTitle("Doodle Jump");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}




	public void jump() {

		if ((engine.checkCollision(objects)) && (umgebung.getPlayer().getSpeed() > 0)) {
			umgebung.getPlayer().setSpeed(-18);
//		if(runTime >= 15)	runTime += 1;

		}

	}

	public void addPlatform() {
		if(umgebung.generateRadomPlatform(runTime)) {
			runTime = 0 ;
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

	public void setcloseCommand(int eingabe){
		closeCommand = eingabe;
	}

	public void keyControl(){

		final int frames =10;
		timer= new Timer (frames, new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e){
				if(spielLaeuft == true) {

					updatePosition(frames);
					umgebung.moveAll();
					jump();
					addPlatform();
					try {
						finished(umgebung.getPlayer());
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					umgebung.teleportToBorder();
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
		case 1: this.dispose();
			break;
		case 2: System.exit(1);
			break;
		case 0: ;
			break;
		default:;
					}

	}

	public void finished(DoodlePlayer player) throws InterruptedException {


		if(umgebung.bottomReached(player))
		{
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







}
