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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		umgebung = new DoodleBackground(250, 700);								// OPEN TO DO
	}


	public DoodleBackground getUmgebung() {
		return umgebung;
	}
	
	
	

}
