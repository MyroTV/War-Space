package com.me.game;

import java.util.ArrayList;
import com.me.game.entities.PlanetEntity;
import com.me.game.structures.Structure;
import com.me.renderers.Renderer;

public class Planet {
	private PlanetEntity planetEntity;
	
	private String planetName;
	private int posX, posY, size;
	private PlanetType planetType;
	private StarSystem parentStar;
	private int population, populationLimit, populationGrowthPerTick;
	private int productionPerTick;
	private int planetSize;
	private int habitatSuitability;
	private boolean habitable;
	private Player planetOwner = null;
	private boolean focus = false;
	private boolean isCapital = false;
	private boolean graphicsInitialised = false;
	private ArrayList<Structure> structureList = new ArrayList<Structure>();
	
	public Planet(String planetName, PlanetType planetType) {
		this.planetName = planetName;
		this.planetType = planetType;
	}
	
	public String getPlanetName() {
		return planetName;
	}

	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void setParentStar(StarSystem starSystem) {
		this.parentStar = starSystem;
	}
	
	public StarSystem getParentStar() {
		return this.parentStar;
	}
	
	public Player getPlanetOwner() {
		return planetOwner;
	}

	public void setPlanetOwner(Player planetOwner) {
		this.planetOwner = planetOwner;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public boolean isCapital() {
		return isCapital;
	}

	public void setCapital(boolean isCapital) {
		this.isCapital = isCapital;
	}
	
	public void addStructures(ArrayList<Structure> structures) {
		structureList.addAll(structures);
	}
	
	public void addStructure(Structure structure) {
		structureList.add(structure);
	}
	
	public ArrayList<Structure> getStructureList() {
		return this.structureList;
	}

	public PlanetEntity getPlanetEntity() {
		return planetEntity;
	}

	public void setPlanetEntity(PlanetEntity planetEntity) {
		this.planetEntity = planetEntity;
	}

	public void populationGrowth() {
		if(planetOwner != null) {
			
		}
	}

	public void show() {

	}
	
	public void render() {
		planetEntity.render();
	}
	
	public void update() {
		populationGrowth();
		this.getPlanetEntity().update();
		if(this.getPlanetEntity().isClicked() == true) {
			initialisePlanetScreen();
		}
			
	}
	
	public void dispose() {
		System.out.print("Planet graphics destroyed \n");
		planetEntity.dispose();
		planetEntity = null;
		setGraphicsInitialised(false);
	}

	public boolean getFocus() {
		return focus;
	}

	public void setFocus(boolean inFocus) {
		this.focus = inFocus;
	}
	
	public boolean isGraphicsInitialised() {
		return graphicsInitialised;
	}

	public void setGraphicsInitialised(boolean graphicsInitialised) {
		this.graphicsInitialised = graphicsInitialised;
	}

	public void initialiseGraphics() {
		planetEntity = new PlanetEntity(this.planetType.getPlanetTypeTexture(), this.planetName, this.posX, this.posY);
		setGraphicsInitialised(true);
	}
	
	public void initialisePlanetScreen() {
		Renderer.getGUIRenderer().getPlanetScreen().setPlanet(this);
		Renderer.getGUIRenderer().getPlanetScreen().setIsActive(true);
	}
}