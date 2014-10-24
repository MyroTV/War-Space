package com.me.game;

public abstract class Structure {
	
	public abstract String getName();
	public abstract int getMaterialCost();
	public abstract int getMoneyCost();
	public abstract Structure getStructure();
	public abstract int getStructureHealth();
	public abstract int structureLevel();
}
