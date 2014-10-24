package com.me.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class PlanetType {
	
	private Texture planetTypeTexture;
	private String planetType;
	private Pixmap pMap;
	
	public PlanetType(String planetType) {
		this.planetType = planetType;
		this.setTexture();
	}
	
	public void setTexture() {
		//String filePath = "assets/" + planetype + ".png";
		if(planetType != null) {
			//planetTypeTexture = new Texture(Gdx.files.internal(filePath));
			
			if(planetType == "metallic") {
				planetTypeTexture = TextureLoader.getMetallicPlanet();
			}
		}
	}
	
	public Texture getPlanetTypeTexture() {
		return this.planetTypeTexture;
	}
}
