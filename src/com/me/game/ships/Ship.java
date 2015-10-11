package com.me.game.ships;

import java.util.ArrayList;

import com.me.game.WeaponType;

public abstract class Ship {
	private String shipName;
	private int shipHull;
	private int shipSize;
	private int shields;
	private int speed; //might consider different speed variables for galaxy travel, system travel and inter-planet travel
	private int materialCost;
	private int moneyCost;
	private ArrayList<Module> modules;
	
	public abstract String getShipName();
	public abstract int getHull();
	public abstract int getShields();
	public abstract int getMaterialCost();
	public abstract int getMoneyCost();
	public abstract WeaponType getWeaponType();
}
