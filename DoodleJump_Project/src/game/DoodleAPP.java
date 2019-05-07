package game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class DoodleAPP extends JFrame{
	public DoodleAPP() {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		getContentPane().add(panel, BorderLayout.CENTER);
	}
	
	private JPanel contentPane;
	

}
