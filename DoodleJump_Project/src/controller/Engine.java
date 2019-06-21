package controller;

import java.util.ArrayList;

import models.DoodleObject;
import models.DoodlePlayer;
import view.DoodleAPP;
import view.DoodleBackground;

public class Engine {
	private DoodleAPP app;
	private DoodlePlayer player;
	private DoodleBackground umgebung;
	private DoodleObject aktuel = null;
	public boolean gleich = true;
	
	public Engine (DoodleAPP app) {
		this.app = app;
		this.umgebung = app.getUmgebung();
		this.player = umgebung.getPlayer();
	}
	
	public boolean checkCollision(ArrayList<DoodleObject> objects) {
		for(DoodleObject object : objects) {
			if(((player.getPoint().y + player.getHeight() >= (object.getPoint().y +object.getHeight() -8 )	//Y Achsen Kollisionsüberprüfung
					&& player.getPoint().y <= (object.getPoint().y ))							 
					&& !object.equals(player))																// Damit keine nur die Platformen überprüft werden
					&& ((player.getPoint().x + player.getWidth()) > object.getPoint().x						//X Achsen Kollisionsüberprüfung 
					&& player.getPoint().x < (object.getPoint().x + object.getWidth()))
					&& player.getSpeed()>0) {  																//nur beim "runterfallen" 
				if (object.equals(aktuel)) gleich = true;													// boolean gleich überprüft ob Player auf die selbe Platform springt
				if (!object.equals(aktuel)) gleich = false;
				aktuel = object;
				return true;
			}
		}
		return false;
	}



}
