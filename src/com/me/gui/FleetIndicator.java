package com.me.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.game.TextureLoader;
import com.me.screens.GameScreen;

public class FleetIndicator {
//This will sit over a planet and possibly star system and galaxy
	private SpriteBatch batch;
	private Sprite fleetIndicatorSprite;
	private int posX, posY;
	private Tooltip tooltip;
	
	public FleetIndicator(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public void init() {
		System.out.println("Fleet indicator initialised.");
		batch = new SpriteBatch();
		fleetIndicatorSprite = new Sprite(TextureLoader.getFleetIndicator());
		tooltip = new Tooltip("");
		tooltip.init();
	}
	
	public void dispose() {
		batch.dispose();
		batch = null;
		fleetIndicatorSprite = null;
		tooltip.dispose();
		tooltip = null;
	}
	
	public void render() {
		batch.setProjectionMatrix(GameScreen.getCamera().combined);
		batch.begin();
			fleetIndicatorSprite.draw(batch);
		batch.end();
	}
	
	public void update() {
		fleetIndicatorSprite.setPosition(posX + 50, posY + 20);
		isHovering();
	}
	
	public boolean isHovering() {
		if(fleetIndicatorSprite.getBoundingRectangle().contains(Gdx.input.getX() - (Gdx.graphics.getWidth() / 2) - (GameScreen.getScreenX() * -1),
				Gdx.input.getY() - ((Gdx.graphics.getHeight() / 2) - (fleetIndicatorSprite.getWidth() * 2) - 20) - GameScreen.getScreenY() + (this.getPosY() * 2))) {
			fleetIndicatorSprite.setColor(1, 1, 1, 0.5f);
			return true;
		}
		else {
			fleetIndicatorSprite.setColor(1, 1, 1, 1);
			return false;
		}
	}
	
	public boolean isClicked() {
		return false;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}
