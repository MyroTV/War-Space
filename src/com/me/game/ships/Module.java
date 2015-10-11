package com.me.game.ships;

public abstract class Module {
	//ships can have multiple modules depending on size and type
	//This is an abstract class for ship modules which will include:
	//outpost ship
	//scout ship
	//capital ship or mothership
	//harvester
	//salvager
	//assault ship (boarding ship)
	//jump ship (might get rid of this)
	
	private String moduleName;
	private int moduleCost; //use a cost system so that a player can't add all modules to one ship design
	
	public abstract String getModuleName();
	public abstract int getModuleCost();
}
