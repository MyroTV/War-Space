package com.me.game;

import java.util.ArrayList;

import com.cedarsoftware.util.io.JsonWriter;
import com.me.game.entities.StarSystemEntity;
import com.me.gui.FleetIndicator;
import com.me.screens.GameScreen;

public class StarSystem {
	
	private StarSystemEntity starSystemEntity;
	
	private StarSystemShell starSystemShell;
	
	private Galaxy parentGalaxy;
	private String systemName;
	private int numberOfPlanets;
	private ArrayList<Planet> planets = new ArrayList<Planet>();
	private boolean inFocus = false;
	private boolean graphicsInitialised = false;
	private boolean childPlanetsGenerated = false;
	private StarType starType;
	private int posX,posY;
	
	private FleetIndicator fleetIndicator;
	
	public StarSystem(String systemName, int numberOfPlanets, StarType starType) {
		this.systemName = systemName;
		this.numberOfPlanets = numberOfPlanets;
		this.starType = starType;
	}
	
	public void generatePlanets() {
		for(int i = 0; i < numberOfPlanets; i++) {
			planets.add(new Planet(Universe.getRandomPlanetName(), new PlanetType("metallic")));
			//Universe.removePlanetNameFromArray(planets.get(i).getPlanetName());
			planets.get(i).setParentStar(this);
			if(i == 0) {
				planets.get(i).setPosX(100 + posX);
				planets.get(i).setPosY(100 + posY);
			}
			else {
				planets.get(i).setPosX((i + 1) * 100 + posX);
				planets.get(i).setPosY((i + 1) * 100 + posY);
			}
		}
		this.childPlanetsGenerated = true;
	}
	
	public void setRandomStarSprite() {
		
	}
	
	public void addPlanet() {
		
	}
	
	public void removePlanet() {
		
	}
	
	public void render() {
		if(this.getFocus() == true) {
			for(int i = 0; i < planets.size(); i++) {
				planets.get(i).render();
			}
		}
		starSystemEntity.render();
	}
	public void lookAt() {
		GameScreen.getCamera().translate(GameScreen.getScreenX() * -1 + posX, GameScreen.getScreenY() * -1 + posY);
	}
	
	public void update() {
		starSystemEntity.update();
		checkClick();
		if(this.inFocus == true && this.childPlanetsGenerated == true) {
			for(int i = 0; i < planets.size(); i++) {
				planets.get(i).update();
			}
		}

	}

	public void dispose() {
		//star systems aren't being disposed when entering planet view but their graphics are being intialised again when leaving planet view
		//check if this is still happening
		System.out.print("Star System graphics destroyed \n");
		starSystemEntity.dispose();
		starSystemEntity = null;
		setGraphicsInitialised(false);
	}
	
	public void save() {
		ArrayList<PlanetShell> tmp = new ArrayList<PlanetShell>();
		String json;
		for(int i = 0; i < planets.size(); i++) {
			tmp.add(planets.get(i).getPlanetShell());
		}
		starSystemShell = new StarSystemShell(this.systemName);
		starSystemShell.setPlanets(tmp);
		json = JsonWriter.objectToJson(starSystemShell);
		System.out.print(JsonWriter.formatJson(json));
	}
	
	void checkClick() {
		if(starSystemEntity.isClicked() == true) {
			if(this.childPlanetsGenerated == false) {
				this.generatePlanets();
			}
			this.parentGalaxy.setFocus(false);
			for(int i = 0; i < planets.size(); i++) {
				if(planets.get(i).isGraphicsInitialised() == false) {
					planets.get(i).initialiseGraphics();
					planets.get(i).init();
				}
			}
			this.parentGalaxy.setChildStarFocused(true);
			this.setFocus(true);
		}
	}
	
	public void initialiseGraphics() {
		starSystemEntity = new StarSystemEntity(starType.getStarTexture("yellowStar"), this.systemName, this.posX, this.posY);
		setGraphicsInitialised(true);
	}
	
	public void setParentGalaxy(Galaxy parentGalaxy) {
		this.parentGalaxy = parentGalaxy;
	}
	
	public Galaxy getParentGalaxy() {
		return this.parentGalaxy;
	}
	
	public boolean getFocus() {
		return this.inFocus;
	}
	
	public void setFocus(boolean focus) {
		this.inFocus = focus;
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int x) {
		this.posX = x;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int y) {
		this.posY = y;
	}

	public StarSystemEntity getStarSystemEntity() {
		return starSystemEntity;
	}

	public void setStarSystemEntity(StarSystemEntity starSystemEntity) {
		this.starSystemEntity = starSystemEntity;
	}

	public ArrayList<Planet> getPlanets() {
		return this.planets;
	}
	
	public String getSystemName() {
		return this.systemName;
	}
	
	public void setAreChildPlanetsGenerated(boolean areChildPlanetsGenerated) {
		this.childPlanetsGenerated = areChildPlanetsGenerated;
	}
	
	public boolean isGraphicsInitialised() {
		return graphicsInitialised;
	}

	public void setGraphicsInitialised(boolean graphicsInitialised) {
		this.graphicsInitialised = graphicsInitialised;
	}
}
