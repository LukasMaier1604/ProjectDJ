package game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

public class DoodleAPP extends JFrame{
	
	private JPanel contentPane;
	private DoodleBackground umgebung;
	
	
	public DoodleAPP() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		contentPane.setBackground(Color.RED);
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		umgebung = new DoodleBackground()							// OPEN TO DO
	}


	public DoodleBackground getUmgebung() {
		return umgebung;
	}
	
	
	

}
