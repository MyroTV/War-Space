package com.me.game;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.cedarsoftware.util.io.JsonWriter;
import com.me.game.entities.PlanetEntity;
import com.me.game.structures.Structure;
import com.me.gui.FleetIndicator;
import com.me.gui.Tooltip;
import com.me.interfaces.Orbitable;
import com.me.renderers.Renderer;

public class Planet implements Orbitable {
	//TO DO
	//Building space
	//land requisition (clearing land to build on)
	//administrative lag (depending on race and government type)
	//title screen with capital ship orbiting planet
	
	//JSON serialization for saving data
	//may need a new class holding just the variables I want to save
	private PlanetEntity planetEntity;
	private PlanetShell planetShell;

	private String json;
	private Writer writer;
	
	private String planetName;
	private int posX, posY, size;
	private PlanetType planetType;
	private StarSystem parentStar;
	private int population;
	private int planetSize;
	private boolean habitable;
	private Player planetOwner = null;
	private boolean focus = false;
	private boolean isCapital = false;
	private boolean graphicsInitialised = false;
	private boolean fleetDocked = false;
	private ArrayList<Structure> structureList = new ArrayList<Structure>();
	private FleetIndicator fleetIndicator;
	private Tooltip tooltip;
	
	public Planet(String planetName, PlanetType planetType) {
		this.planetName = planetName;
		this.planetType = planetType;
	}
	//TO DO LIST
	//

	public void populationGrowth() {
		if(planetOwner != null) {
			
		}
	}
	public void init() {
		tooltip = new Tooltip(planetName);
		tooltip.init();
		if(fleetDocked) {
			fleetIndicator = new FleetIndicator(0, 0);
			fleetIndicator.init();
		}
	}
	
	public void render() {
		planetEntity.render();
		if(fleetDocked) {
			//fleetIndicator.render();
		}
		if(planetEntity.isHovered()) {
			tooltip.setPosition(Gdx.input.getX() + 20, Gdx.graphics.getHeight() - Gdx.input.getY());
			tooltip.render();
		}
	}
	
	public void update() {
		populationGrowth();
		this.getPlanetEntity().update();
		if(this.getPlanetEntity().isClicked() == true && Renderer.getGUIRenderer().getPlanetScreen().isActive() == false) {
			initialisePlanetScreen();
		}
		if(fleetDocked) {
			fleetIndicator.setPosX(posX);
			fleetIndicator.setPosY(posY);
			fleetIndicator.update();
		}
	}
	
	public void dispose() {
		System.out.println("Planet graphics destroyed.");
		setFocus(false);
		planetEntity.dispose();
		planetEntity = null;
		setGraphicsInitialised(false);
		tooltip.dispose();
		tooltip = null;
		if(fleetIndicator != null) {
			fleetIndicator.dispose();
			fleetIndicator = null;
		}
	}

	public void initialiseGraphics() {
		planetEntity = new PlanetEntity(planetType.getPlanetTypeTexture("metallic"), planetName, posX, posY);
		setGraphicsInitialised(true);
	}
	
	public void save() {
		json = JsonWriter.objectToJson(planetShell);
		System.out.print(JsonWriter.formatJson(json));
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("universe.json")));
			System.out.print("Got here");
			writer.write(JsonWriter.formatJson(json));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initialisePlanetScreen() {
		planetShell = new PlanetShell(this.planetName, this.planetType.toString());
		save();
		Renderer.getGUIRenderer().getPlanetScreen().setPlanet(this);
		Renderer.getGUIRenderer().getPlanetScreen().setIsActive(true);
	}
	
	public boolean getFocus() {
		return focus;
	}
	public void setFocus(boolean inFocus) {
		this.focus = inFocus;
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
	public boolean isFleetDocked() {
		return fleetDocked;
	}
	public void setFleetDocked(boolean fleetDocked) {
		this.fleetDocked = fleetDocked;
	}
	public Tooltip getTooltip() {
		return tooltip;
	}
	public FleetIndicator getFleetIndicator() {
		return fleetIndicator;
	}
	public PlanetShell getPlanetShell() {
		return planetShell;
	}
	public void setPlanetShell(PlanetShell planetShell) {
		this.planetShell = planetShell;
	}
	public boolean isGraphicsInitialised() {
		return graphicsInitialised;
	}
	public void setGraphicsInitialised(boolean graphicsInitialised) {
		this.graphicsInitialised = graphicsInitialised;
	}
}