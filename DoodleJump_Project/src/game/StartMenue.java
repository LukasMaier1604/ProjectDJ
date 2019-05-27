package game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Panel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.Box;
import java.awt.Button;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class StartMenue extends JFrame {
	
	private DoodleAPP app;
	private JPanel contentPane;
	private JButton start, score, button_2;
	
	
	public StartMenue(DoodleAPP app) {
		setTitle("DoodleJump Startmen\u00FC\r\n");
		setBounds(10, 10, 450, 250);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		Panel panel = new Panel();
		panel.setEnabled(false);
		panel.setBackground(Color.PINK);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(5, 5));
		
		start = new JButton("Neues Spiel starten");
		panel.add(start, BorderLayout.NORTH);
		
		score = new JButton("Highscore");
		panel.add(score, BorderLayout.EAST);
		
		button_2 = new JButton("Ja Moin");
		panel.add(button_2, BorderLayout.WEST);
		
		
		this.app = app;
		this.gameStart();
	}
	
	public void gameStart() {
		
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				System.out.println("hallo");
			}
			
		});
};
}