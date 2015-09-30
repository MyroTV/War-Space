package com.me.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.gui.PlanetScreen;
import com.me.screens.GameScreen;

public class GUIRenderer {
	private PlanetScreen planetScreen;
	
	private SpriteBatch batch;
	
	private static OrthographicCamera guiCamera;
	
	public GUIRenderer() {
		
	}
	
	public void show() {
		guiCamera = new OrthographicCamera(1680, 1020);
		planetScreen = new PlanetScreen(null);
		planetScreen.show();
		batch = new SpriteBatch();
	}
	
	public void render() {
		batch.setProjectionMatrix(guiCamera.combined);
		batch.begin();
		
		if(planetScreen.isActive() == true) {
			planetScreen.render();
		}
		
		batch.end();
	}
	
	public void update() {
		
		if(guiCamera.viewportWidth != Gdx.graphics.getWidth()) {
			guiCamera.viewportWidth = Gdx.graphics.getWidth();
		}
		
		if(guiCamera.viewportHeight != Gdx.graphics.getHeight()) {
			guiCamera.viewportHeight = Gdx.graphics.getHeight();
		}
		
		if(planetScreen != null && planetScreen.isActive() == true) {
			planetScreen.update();
		}
		guiCamera.update();
	}
	
	public PlanetScreen getPlanetScreen() {
		return planetScreen;
	}
	
	public static OrthographicCamera getGraphicsCamera() {
		return guiCamera;
	}
}
