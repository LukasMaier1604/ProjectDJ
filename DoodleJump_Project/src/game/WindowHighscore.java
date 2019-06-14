package game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class WindowHighscore extends JFrame{
	
	private JPanel contentPane;
	private JTextField text;
	private JPanel panel, panel_1, panel_2;
	private JButton back;
	
																				
	public WindowHighscore() {
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		text = new JTextField();										//hier kommen die Zeilen vom HS rein
		panel_1.add(text);
		text.setColumns(10);
		
		panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		
		back = new JButton("New button");
		panel_2.add(back);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
				}catch(Exception o) {
					o.printStackTrace();
				}
			}
		});
	}
}
