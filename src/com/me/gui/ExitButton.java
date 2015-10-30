package com.me.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.game.TextureLoader;
import com.me.renderers.GUIRenderer;
import com.me.screens.GameScreen;

public class ExitButton extends Button {
	private Sprite exitButtonSprite;	
	private SpriteBatch batch;
	private PlanetScreen parentPlanetScreen;
	private int posX, posY;
	
	public ExitButton(int posX, int posY) {
		super(posX, posY);
	}

	public void init() {
		batch = new SpriteBatch();
		exitButtonSprite = new Sprite(TextureLoader.getExitButton());
		exitButtonSprite.setPosition(this.getX(), this.getY());
	}

	public void render() {
		batch.setProjectionMatrix(GUIRenderer.getGraphicsCamera().combined);
		batch.begin();
		
		exitButtonSprite.draw(batch);
		
		batch.end();
	}

	public void update() {
		posY = (int) (exitButtonSprite.getY() * 2);
		if(this.exitButtonSprite.getBoundingRectangle().contains((Gdx.input.getX() - (Gdx.graphics.getWidth() / 2)), Math.abs(Gdx.input.getY() - ((Gdx.graphics.getHeight() / 2))))) {
			exitButtonSprite.setColor(1, 1, 1, 0.5f);
			if(Gdx.input.justTouched()) {
				parentPlanetScreen.dispose();
			}
		}
		else {
			exitButtonSprite.setColor(1, 1, 1, 1);
		}
	}
	
	public void dispose() {
		exitButtonSprite = null;
	}

	public PlanetScreen getParentPlanetScreen() {
		return parentPlanetScreen;
	}

	public void setParentPlanetScreen(PlanetScreen parentPlanetScreen) {
		this.parentPlanetScreen = parentPlanetScreen;
	}
	
}
