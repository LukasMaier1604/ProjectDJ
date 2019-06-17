package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import models.DoodleObject;

public class Overlay extends JPanel{

	private DoodleBackground bg;
	private BufferedImage img;


	public Overlay(DoodleBackground background) {
		bg = background;
		ImagePanel();
		this.setBackground(Color.WHITE);
		setArea();


	}
	public void ImagePanel() {
	       try {
	          img = ImageIO.read(new File("Images/background.png"));
	       } catch (IOException ex) {
	    	   ex.printStackTrace();
	       }
	 }

	public void setArea() {
	this.setPreferredSize( new Dimension( bg.getWidth(), bg.getHeight() ) );
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img,0,0,this);
		for(DoodleObject o : bg.getObjects()) {
			g.setColor(Color.BLACK);
			g.drawImage(o.getImage(), o.getPoint().x, o.getPoint().y, o.getWidth(), o.getHeight(), null);
		}

	}




}
