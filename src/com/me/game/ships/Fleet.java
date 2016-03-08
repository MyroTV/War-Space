package com.me.game.ships;

import java.util.ArrayList;

import com.me.game.Planet;
import com.me.interfaces.Orbitable;

public class Fleet {
	//Maybe store each ship of the same type in a different class?
	private String fleetName;
	private ArrayList<Ship> ships = new ArrayList<Ship>();
	private int travelLength, travelStartTick;
	private Orbitable location;
	private int numberOfShips = 0;
	
	public Fleet(String fleetName, ArrayList<Ship> ships) {
		numberOfShips = ships.size();
	}
	
	public void removeShips() {
		
	}
	
	public void addSubFleet() {
		
	}
	
	public void addShips() {
		
	}
	
	public void updateIndicator() {
		location.getFleetIndicator();
	}
}