package game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

public class DoodleAPP extends JFrame{
	
	private JPanel contentPane;
	private Overlay myOverlay;
	private DoodleBackground umgebung;
	

	
	public DoodleAPP() {
		
		umgebung = new DoodleBackground(100, 150);								// OPEN TO DO

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
		
//		myOverlay = new Overlay(umgebung);								//ähnlich dem Canvas, funktioniert hier noch nicht. bin noch 
//		panel_1.add(myOverlay);											//nich sicher ob, dass bei den Plattformen helfen kann.
																		// dazu: Klasse App kann noch nicht gestartet werden. IMG müsste da sein
		
	}


	public DoodleBackground getUmgebung() {
		return umgebung;
	}
	
	
	

}
