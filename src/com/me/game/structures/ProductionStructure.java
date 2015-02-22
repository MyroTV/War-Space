package com.me.game.structures;

public abstract class ProductionStructure extends Structure {
	
	private String name;
	private int materialCost;
	private int moneyCost;
	private int structureLevel = 0;
	private int structureHealth;
	private int output;
	
	public ProductionStructure() {
		
	}
	
	public String getName() {
		return this.name;
	}

	public int getMaterialCost() {
		return this.materialCost;
	}

	public int getMoneyCost() {
		return this.moneyCost;
	}

	public Structure getStructure() {
		return this;
	}

	public int getStructureHealth() {
		return this.structureHealth;
	}

	public int structureLevel() {
		return this.structureLevel;
	}

	public void show() {
		
	}
	
	public void update() {
		
	}
	
	public abstract int getOutput();
	public abstract void setOutput();
}
