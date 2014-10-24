package com.me.gui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.game.Planet;
import com.me.interfaces.GUIElement;

public class PlanetScreen implements GUIElement {
	private Texture planetScreenTexture;
	private Sprite planetScreenSprite;
	
	private Button exitButton;
	
	private ScrollPane scrollPane;
	
	private Planet planet;
	private Texture planetTexture;
	private Sprite planetSprite;
	
	private SpriteBatch batch;
	
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
		planetScreenTexture  = new Texture("assets/planetScreenTemp.png");
		planetScreenSprite = new Sprite(planetScreenTexture);
	}
	
	public void render() {
		batch.begin();
		
		batch.end();
	}
	
	public void update() {
		
	}
	
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
}
