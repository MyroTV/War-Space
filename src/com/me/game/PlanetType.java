package com.me.game;

import com.badlogic.gdx.graphics.Texture;

public class PlanetType {	
	private Texture planetTypeTexture;
	private String planetType;
	
	public PlanetType(String planetType) {
		this.planetType = planetType;
	}

	public String toString() {
		return planetType;
	}
	
	public Texture getPlanetTypeTexture() {
		return this.planetTypeTexture;
	}
	
	public Texture getPlanetTypeTexture(String planetType) {
		if(planetType == "metallic") {
			return TextureLoader.getMetallicPlanet();
		}
		else {
			return TextureLoader.getMetallicPlanet();
		}
	}
}
