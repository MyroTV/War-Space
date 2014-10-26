package com.me.gui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.game.Planet;
import com.me.interfaces.GUIElement;

public class PlanetScreen implements GUIElement {
	private Texture planetScreenTexture;
	private Sprite planetScreenSprite;
	private BitmapFont planetNameLabel;
	
	private ExitButton exitButton;
	
	private ScrollPane scrollPane;
	
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
		planetScreenTexture  = new Texture("assets/planetScreenTemp.png");
		planetScreenSprite = new Sprite(planetScreenTexture);
		exitButton = new ExitButton((int)planetScreenSprite.getWidth() - 20, (int)planetScreenSprite.getHeight() - 20);
		exitButton.show();
		exitButton.setParentPlanetScreen(this);
	}
	
	public void render() {
		batch.begin();
		
		if(planetScreenSprite != null) {
			planetScreenSprite.draw(batch);
			planetNameLabel.draw(batch, planet.getPlanetName(), 10, planetScreenSprite.getHeight());
		}
		
		batch.end();
		
		exitButton.render();
	}
	
	public void update() {
		if(isActive == true) {
			exitButton.update();
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
	}
	
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public boolean isActive() {
		return isActive;
	}
}
