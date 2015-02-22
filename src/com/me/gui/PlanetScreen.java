package com.me.gui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.game.Planet;
import com.me.interfaces.GUIElement;
import com.me.renderers.GUIRenderer;
import com.me.screens.GameScreen;

public class PlanetScreen implements GUIElement {
	private Texture planetScreenTexture;
	private Sprite planetScreenSprite;
	
	private BitmapFont planetNameLabel;
	private BitmapFont planetPopulationLabel;
	
	private ExitButton exitButton;
	
	private ScrollPane buildingScrollPane;
	
	private Planet planet;
	private Texture planetTexture;
	private Sprite planetSprite;
	
	private SpriteBatch batch;
	
	private boolean isActive = false;
	
	public PlanetScreen() {
		
	}
	
	public void setPlanetTexture() {
		if(this.planet != null) {
			this.planetTexture = planet.getPlanetSprite().getTexture();
		}
	}
	
	private void setPlanetSprite() {
		if(this.planetTexture != null) {
			this.planetSprite = new Sprite(planetTexture);
		}
		else if(this.planet != null) {
			this.planetSprite = planet.getPlanetSprite();
		}
	}
	
	public void show() {
		batch = new SpriteBatch();
		planetNameLabel = new BitmapFont();
		planetPopulationLabel = new BitmapFont();
		planetScreenTexture  = new Texture("assets/planetScreenTemp.png");
		planetScreenSprite = new Sprite(planetScreenTexture);
		exitButton = new ExitButton((int)planetScreenSprite.getWidth() - 20, (int)planetScreenSprite.getHeight());
		exitButton.show();
		exitButton.setParentPlanetScreen(this);
	}
	
	public void render() {
		batch.setProjectionMatrix(GUIRenderer.getGraphicsCamera().combined);
		batch.begin();
		if(planetScreenSprite != null) {
			planetScreenSprite.draw(batch);
			planetNameLabel.draw(batch, planet.getPlanetName(), 10, planetScreenSprite.getHeight());
			planetPopulationLabel.draw(batch, "Population: " + planet.getPopulation(), 70, planetScreenSprite.getHeight() - 20);
			planetSprite.draw(batch);
		}
		
		batch.end();
		if(buildingScrollPane != null) {
			buildingScrollPane.render();
		}
		exitButton.render();
	}
	
	public void update() {
		if(isActive == true) {
			exitButton.update();
			if(buildingScrollPane == null) {
				buildingScrollPane = new ScrollPane(planet.getStructureList().size(), 166, 280, this);
			}
		}
	}
	
	public void unset() { //Use this method to un-set PlanetScreen variables
		planet = null;
		planetTexture = null;
		planetSprite = null;
	}
	
	public void close() {
		unset();
		isActive = false;
	}
	
	public void setPlanet(Planet planet) {
		this.planet = planet;
		setPlanetTexture();
		setPlanetSprite();
		planetSprite.setPosition(12, (int)planetScreenSprite.getHeight() - 62);
	}
	
	public Planet getPlanet() {
		return this.planet;
	}
	
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public boolean isActive() {
		return isActive;
	}
}
