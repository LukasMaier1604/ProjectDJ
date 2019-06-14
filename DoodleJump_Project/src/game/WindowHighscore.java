package game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class WindowHighscore extends JFrame{
	public WindowHighscore() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField);
		textField.setColumns(30);
	}
	
	private JPanel contentPane;
	private JTextField textField;

	
	public void WindowHighscore() {
		
	}
}
