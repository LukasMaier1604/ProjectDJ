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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.Box;
import java.awt.Button;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import view.DoodleAPP;

public class StartMenue extends JFrame {

	private DoodleAPP app;
	private WindowHighscore window;
	private JPanel contentPane;
	private JButton start, score, button_2;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTextField txtPlayer, textField;


	public StartMenue(DoodleAPP app) {
		setTitle("DoodleJump Startmen\u00FC\r\n");
		setBounds(10, 10, 389, 171);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		Panel panel = new Panel();
		panel.setEnabled(true);
		panel.setBackground(Color.PINK);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(5, 5));

		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);

		score = new JButton("Highscore");
		score.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(score);

		panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.add(panel_2, BorderLayout.NORTH);

		start = new JButton("NEW GAME");
		panel_2.add(start);

		txtPlayer = new JTextField();
		txtPlayer.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPlayer.setText("PlayerName");
		panel_2.add(txtPlayer);
		txtPlayer.setColumns(10);

		panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.SOUTH);
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();

		button_2 = new JButton("Save Score");
		panel_3.add(button_2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		gameStart();
		showScores();

	}

	public void gameStart() {

		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					app = new DoodleAPP(returnMe());
					app.setVisible(true);
				}catch(Exception o) {
					o.printStackTrace();
			}

			}

		});

}

	public void showScores() {
		
		score.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				window = new WindowHighscore();
				window.setVisible(true);
			}
		});
		
	}

	public StartMenue returnMe() {
		return this;
	}
//	public String inputScore() {
//
//		Reader input = null;
//		String score = "";
//		
//		try {
//			input= new FileReader("score.txt");
//			for(int v; (v = input.read()) != -1;) {
//				System.out.println((char) v);
//				score += (char) v;
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//			return "0";
//		}
//		try {
//			input.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return score;
//	}
	
//	public void updateScore(String wert) {
//		txtScore.setText(wert);
//	}
//	
	public String getTextFromField() {
		return txtPlayer.getText();
	}
}
