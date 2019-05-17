package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

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

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for(DoodleObject o : bg.getObjects()) {
			g.setColor(Color.WHITE);
			g.drawImage(o.getImage(), o.getPoint().x, o.getPoint().y, o.getWidth(), o.getHeight(), null);
		}
		
	}




}
