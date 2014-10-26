package com.me.renderers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.gui.PlanetScreen;

public class GUIRenderer {
	private PlanetScreen planetScreen;
	
	private SpriteBatch batch;
	
	public GUIRenderer() {
		
	}
	
	public void show() {
		planetScreen = new PlanetScreen();
		planetScreen.show();
		batch = new SpriteBatch();
	}
	
	public void render() {
		batch.begin();
		
		if(planetScreen != null && planetScreen.isActive() == true) {
			planetScreen.render();
		}
		
		batch.end();
	}
	
	public void update() {
		if(planetScreen != null && planetScreen.isActive() == true) {
			planetScreen.update();
		}
	}
	
	public PlanetScreen getPlanetScreen() {
		return planetScreen;
	}
}
