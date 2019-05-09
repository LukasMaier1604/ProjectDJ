package game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Overlay extends JPanel{

	private DoodleBackground bg;
	
	
	public Overlay(DoodleBackground background) {
		bg = background;
		this.setBackground(Color.GREEN);
		setArea();
	}
	
	public void setArea() {
	this.setPreferredSize( new Dimension( bg.getWidth(), bg.getHeight() ) );
	}
}
