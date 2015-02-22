package com.me.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.game.structures.Structure;
import com.me.gui.PlanetScreen;
import com.me.renderers.Renderer;
import com.me.screens.GameScreen;

public class Planet {
	
	private String planetName;
	private Texture planetTexture;
	private Sprite planetSprite;
	private SpriteBatch batch;
	private BitmapFont planetLabel;
	private int realX, realY, size;
	private PlanetType planetType;
	private StarSystem parentStar;
	private int population, populationLimit, populationGrowthPerTick;
	private int productionPerTick;
	private int planetSize;
	private int habitatSuitability;
	private boolean habitable;
	private Player planetOwner = null;
	private boolean inFocus = false;
	private boolean isCapital = false;
	private ArrayList<Structure> structureList = new ArrayList<Structure>();
	
	public Planet(String planetName, PlanetType planetType) {
		this.planetName = planetName;
		this.planetType = planetType;
		this.planetTexture = planetType.getPlanetTypeTexture();
	}
	
	public String getPlanetName() {
		return planetName;
	}

	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}

	public Sprite getPlanetSprite() {
		return planetSprite;
	}

	public void setPlanetSprite(Sprite planetSprite) {
		this.planetSprite = planetSprite;
	}

	public int getRealX() {
		return realX;
	}

	public void setRealX(int realX) {
		this.realX = realX;
	}

	public int getRealY() {
		return realY;
	}

	public void setRealY(int realY) {
		this.realY = realY;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public BitmapFont getPlanetLabel() {
		return planetLabel;
	}

	public void setPlanetLabel(BitmapFont planetLabel) {
		this.planetLabel = planetLabel;
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

	public void populationGrowth() {
		if(planetOwner != null) {
			
		}
	}

	public void show() {
		planetLabel = new BitmapFont();
		planetSprite = new Sprite(planetTexture);
		batch = new SpriteBatch();
	}
	
	public void render() {
		batch.setProjectionMatrix(GameScreen.getCamera().combined);
		batch.begin();
		if(this.parentStar.getFocus() == true) {
			planetSprite.draw(batch);
			if(this.planetOwner != null) {
				planetLabel.setColor(this.planetOwner.getColor());
			}
			
			planetLabel.draw(batch, planetName, planetSprite.getX(), planetSprite.getY());
		}
		batch.end();
	}
	
	public void update() {
		populationGrowth();
		realY = (int) (planetSprite.getY() * 2);
		if(this.planetSprite.getBoundingRectangle().contains(Gdx.input.getX() - (Gdx.graphics.getWidth() / 2) - (GameScreen.getScreenX() * -1), Gdx.input.getY() - ((Gdx.graphics.getHeight() / 2) - planetSprite.getWidth()) - GameScreen.getScreenY() + realY) && parentStar.getFocus() == true) {
			planetSprite.setColor(1, 1, 1, 0.5f);
			if(Gdx.input.justTouched()) {
				lookAt();
				Renderer.getGUIRenderer().getPlanetScreen().setPlanet(this);
				Renderer.getGUIRenderer().getPlanetScreen().setIsActive(true);
			}
		}
		else {
			planetSprite.setColor(1, 1, 1, 1);
		}
	}
	
	public void lookAt() {
		//GameScreen.getCamera().translate(GameScreen.getScreenX() * -1 + realX, GameScreen.getScreenY() * -1 + realY);

	}
}