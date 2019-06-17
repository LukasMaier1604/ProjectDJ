package game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class WindowHighscore extends JFrame{
	
	private Spielstand tryhard;
	private JPanel contentPane;
	private JPanel panel, panel_1, panel_2;
	private JButton back;
	private JTextArea text;
	
																				
	public WindowHighscore() {
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		setBounds(5, 5, 366,220);
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		text = new JTextArea();
		text.setWrapStyleWord(true);
		text.setColumns(5);
		text.setRows(7);
		panel_1.add(text);
		
		panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		
		back = new JButton("Zurück");
		panel_2.add(back);
		tryhard = new Spielstand();
		loadingScores(tryhard);
		
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

		Map<String, Integer> vergleich = maps.dontDoIt();
		 vergleich.forEach((k, v) ->{
			text.append(k+" - "+ String.valueOf(v)+"\n" );
		 });
//		for(Map.Entry<String, Integer> entry : vergleich.entrySet()) {
//			text.append(entry.getKey()+" - "+ String.valueOf(entry.getValue())+"\n" );
//			System.out.println(entry.getKey()+ " - "+ entry.getValue());
//		}
	}
}