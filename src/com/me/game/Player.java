package com.me.game;

import com.badlogic.gdx.graphics.Color;
import com.me.screens.GameScreen;
import com.me.utils.RandomInt;

public class Player {

	private Race race;
	private int money;
	private int rawMaterials;
	private int processedMaterials;
	private Planet capitalPlanet;
	private Color raceColor;
	private boolean isHumanControlled = false;
	
	public Player(Race race, boolean isHumanControlled, Planet capitalPlanet) {
		this.race = race;
		this.isHumanControlled = isHumanControlled;
		this.capitalPlanet = capitalPlanet;
	}
	
	public void setColor(Color color) {
		this.raceColor = color;
	}
	
	public Color getColor() {
		return this.raceColor;
	}
	
	public void setIsHumanControlled(boolean isHumanControlled) {
		this.isHumanControlled = isHumanControlled;
	}
	
	public boolean getIsHumanControlled() {
		return this.isHumanControlled;
	}
	
	public void setFocusOnCapital() {
		if(capitalPlanet != null) {
			GameScreen.getCamera().translate((GameScreen.getScreenX() * -1) + capitalPlanet.getRealX(), (GameScreen.getScreenY() * -1) + capitalPlanet.getRealY());
		}
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Planet getCapitalPlanet() {
		return this.capitalPlanet;
	}

	public void setCapitalPlanet(Planet capitalPlanet) {
		this.capitalPlanet = capitalPlanet;
	}
}
