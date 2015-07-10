package com.me.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.game.Planet;
import com.me.game.TextureLoader;
import com.me.game.Universe;
import com.me.screens.GameScreen;

public class UniverseRenderer {
	
	private static Universe universe;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private TextureLoader textureLoader;
	long backcd1 = 0, backcd2 = 0;
	
	public UniverseRenderer() {

	}
	
	public void render() {
		batch.setProjectionMatrix(GameScreen.getCamera().combined);
		batch.begin();
		universe.render();
		batch.end();
		checkFocusedObject();
	}
	
	public void show() {
		textureLoader = new TextureLoader();
		textureLoader.loadTextures();
		universe = new Universe(9);
		universe.show();
		batch = new SpriteBatch();
	}
	
	public void update() {
		universe.update();
	}
	
	void checkFocusedObject() {
		backcd1++;
		if(Gdx.input.isKeyPressed(Keys.Q) && backcd1 > backcd2 + 20) { //cooldown
			backcd2 = backcd1;
			if(universe.getFocus() != true && universe.getActiveGalaxy() != null) {
				if(universe.getActiveGalaxy().getFocus() == false) {
					if(universe.getActiveGalaxy().getActiveStarSystem() != null && universe.getActiveGalaxy().getActiveStarSystem().getFocus() == true) {
						for(int i = 0; i < universe.getActiveGalaxy().getActiveStarSystem().getPlanets().size(); i++) {
							universe.getActiveGalaxy().getActiveStarSystem().getPlanets().get(i).dispose();
						}
						for(int i = 0; i < universe.getActiveGalaxy().getStarSystems().size(); i++) {
							universe.getActiveGalaxy().getStarSystems().get(i).initialiseGraphics();
						}
						universe.getActiveGalaxy().setFocus(true);
						universe.getActiveGalaxy().getActiveStarSystem().setFocus(false);
						universe.getActiveGalaxy().setChildStarFocused(false);
					}
				}
				else if(universe.getActiveGalaxy().getFocus() == true) {
					for(int i = 0; i < universe.getActiveGalaxy().getStarSystems().size(); i++) {
						universe.getActiveGalaxy().getStarSystems().get(i).dispose();
					}
					for(int i = 0; i < universe.getGalaxies().size(); i++) {
						universe.getGalaxies().get(i).initialiseGraphics();
					}
					Universe.setFocus(true);
					universe.getActiveGalaxy().lookAt();
					universe.getActiveGalaxy().setFocus(false);
					universe.getActiveGalaxy();
				}
			}
		}
	}
	
	public Universe getUniverse() {
		if(universe != null) {
			return universe;
		}
		else return null;
	}
	
	public void setFocusedObject() {
		
	}
}
