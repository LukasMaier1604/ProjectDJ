package game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Panel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import view.DoodleAPP;
import java.awt.Font;

public class StartMenue extends JFrame {

	private DoodleAPP app;
	private WindowHighscore window;
	private JButton start, score, button_2;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTextField txtPlayer;


	public StartMenue() {
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
		panel.add(panel_2, BorderLayout.NORTH);
				panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
				start = new JButton("NEW GAME");
				panel_2.add(start);
		
				txtPlayer = new JTextField();
				txtPlayer.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
				txtPlayer.setHorizontalAlignment(SwingConstants.RIGHT);
				txtPlayer.setText("PlayerName");
				panel_2.add(txtPlayer);
				txtPlayer.setColumns(10);

		panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.SOUTH);
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();

		button_2 = new JButton("Save Score");
		panel_3.add(button_2);
		button_2.setEnabled(false);
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

	public String getTextFromField() {
		return txtPlayer.getText();
	}
}
