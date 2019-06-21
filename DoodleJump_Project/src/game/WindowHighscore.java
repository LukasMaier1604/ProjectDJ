package game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class WindowHighscore extends JFrame{
	
	private Spielstand highPoint;
	private JPanel panel, panel_3, panel_2, panel_1;
	private JButton back;
	private JTextArea text;
	private JTextField headline;
																				
	public WindowHighscore() {
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		setBounds(5, 5, 183,277);
		setTitle("HighScores");
		
		panel_1 = new JPanel();

		getContentPane().add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		headline= new JTextField();
		headline.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(headline);
		headline.setColumns(10);
		headline.setText("Die 5 Highscores sind:");
		
		panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		
		back = new JButton("Zurück");
		panel_2.add(back);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.PINK);
		panel.add(panel_3, BorderLayout.NORTH);
		
		text = new JTextArea();
		text.setFont(new Font("Dubai", Font.BOLD, 18));
		text.setWrapStyleWord(true);
		text.setColumns(5);
		text.setRows(5);
		panel_3.add(text);
		
		highPoint = new Spielstand();
		loadingScores(highPoint);
		
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
	public void loadingScores(Spielstand maps ) {

		Map<String, Integer> vergleich = maps.readScores();
		 vergleich.forEach((k, v) ->{
			text.append(k+" - "+ String.valueOf(v)+"\n" );
		 });
	}
}