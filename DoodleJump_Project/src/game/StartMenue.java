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
	private JTextField txtHallo;
	
	
	public StartMenue(DoodleAPP app) {
		setTitle("DoodleJump Startmen\u00FC\r\n");
		setBounds(10, 10, 286, 243);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		Panel panel = new Panel();
		panel.setEnabled(true);
		panel.setBackground(Color.PINK);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(5, 5));
		
		start = new JButton("Neues Spiel starten");
		panel.add(start, BorderLayout.NORTH);
		
		score = new JButton("Highscore");
		panel.add(score, BorderLayout.EAST);
		
		button_2 = new JButton("Ja Moin");
		panel.add(button_2, BorderLayout.WEST);
		
		txtHallo = new JTextField();
		txtHallo.setText("nein");
		panel.add(txtHallo, BorderLayout.SOUTH);
		txtHallo.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		//this.app = app;
		this.gameStart();
	}
	
	public void gameStart() {
		
		score.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				try {
					app = new DoodleAPP();
					app.setVisible(true);
				}catch(Exception o) {
					o.printStackTrace();
			}
	
			}
			
		});
};
}