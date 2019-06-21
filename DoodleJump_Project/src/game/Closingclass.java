package game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import view.DoodleAPP;

import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;

public class Closingclass extends JFrame {

	private JPanel contentPane;
	private JButton yes, no, retry;
	private DoodleAPP app;
	private JTextArea textArea;
	private JPanel panel_3;
	private JPanel panel_4;


	public Closingclass(DoodleAPP app) {

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(100, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		textArea = new JTextArea("Game Over. Wohingenau?");
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 23));
		panel_1.add(textArea);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBorder(new EmptyBorder(0, 10, 0, 0));
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
				
						yes = new JButton("Hauptmenue");
						yes.setForeground(Color.BLACK);
						panel_2.add(yes);
						yes.setHorizontalAlignment(SwingConstants.LEFT);
						yes.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
				panel_4 = new JPanel();
				panel_4.setBorder(new EmptyBorder(0, 15, 0, 15));
				panel_2.add(panel_4);
						panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
				
						no= new JButton("Benden");
						panel_4.add(no);
						no.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
				panel_3 = new JPanel();
				panel_2.add(panel_3);
						panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
				
						retry = new JButton("Nochmal");
						panel_3.add(retry);
						retry.setEnabled(false);
						retry.setHorizontalAlignment(SwingConstants.RIGHT);
						retry.setFont(new Font("Tahoma", Font.PLAIN, 16));
		setBounds(5, 5, 366,220);

		this.app = app;
		
		redirection();
	}

	public void redirection(){

		yes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				app.setcloseCommand(1);
				exit();
			}
		});

		no.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){

				app.setcloseCommand(2);
				exit();
		}

	});

		retry.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){

				app.setcloseCommand(3);
				exit();
			}
		});
}
	
	public void exit() {							
		finalStatusScore();
		dispose();
	}
	
	public void finalStatusScore() {				
		String tempName = app.returnSM().getTextFromField();
		int tempScore = app.getScore();
		Map<String, Integer> vergleich = app.getSpielstand().dontDoIt();
		
		if(vergleich.containsKey(tempName)) {
			if(vergleich.get(tempName) < tempScore) {
			vergleich.put(tempName, tempScore);	
			}
		}else {
			vergleich.put(tempName, tempScore);
		}

		app.getSpielstand().doIt(vergleich);
	}

}
