package com.me.game.ships;

import com.me.game.WeaponType;

public abstract class Ship {
	
	public abstract String getName();
	public abstract int getHull();
	public abstract int getShields();
	public abstract int getMaterialCost();
	public abstract int getMoneyCost();
	public abstract WeaponType getWeaponType();
}
