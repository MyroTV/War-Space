package com.me.game.structures;

import com.me.game.WeaponType;

public class DefenceStructure extends Structure {
	private String name;
	private int materialCost;
	private int moneyCost;
	private int structureHealth;
	private int structureLevel;
	private int damage;
	private WeaponType weaponType;
	
	public DefenceStructure(String name, int structureHealth, int damage, WeaponType weaponType){
		this.name = name;
		this.structureHealth = structureHealth;
		this.damage = damage;
		this.weaponType = weaponType;
	}
	
	public DefenceStructure getStructure() {
		return this;
	}
	public String getName() {
		return name;
	}
	public int getMaterialCost() {
		return materialCost;
	}
	public int getMoneyCost() {
		return moneyCost;
	}
	public int getStructureHealth() {
		return structureHealth;
	}
	public int structureLevel() {
		return structureLevel;
	}
	public int getDamage() {
		return damage;
	}
	public WeaponType getWeaponType() {
		return weaponType;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
