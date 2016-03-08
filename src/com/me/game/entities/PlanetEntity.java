package com.me.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Json;
import com.me.game.Planet;
import com.me.screens.GameScreen;

public class PlanetEntity extends Entity {
	private SpriteBatch batch;
	
	public PlanetEntity(Texture spriteTexture, String planetName, int posX, int posY) {
		super(spriteTexture, planetName, posX, posY);
		
		//super.init();
		this.initialiseGraphics();
	}
	
	public void show() {
		
	}

	public void render() {
		batch.setProjectionMatrix(GameScreen.getCamera().combined);

		batch.begin();
			this.getEntitySprite().draw(batch);
			this.getEntityLabel().draw(batch, getEntityName(), this.getPosX(), this.getPosY());
		batch.end();
	}
	
	public void update() {
		checkClick();
	}

	public void dispose() {
		batch.dispose();
		batch = null;
		this.setSpriteTexture(null);
		this.setEntitySprite(null);
		this.getEntityLabel().dispose();
		this.setEntityLabel(null);
	}

	public void initialiseGraphics() {
		batch = new SpriteBatch();
		this.getEntitySprite().setPosition(getPosX(), getPosY());
		System.out.println("Planet entity initialised.");
		//super.getEntitySprite().setTexture(getSpriteTexture());
	}
	
	void checkClick() {
		if(this.getEntitySprite().getBoundingRectangle().contains(Gdx.input.getX() - (Gdx.graphics.getWidth() / 2) - (GameScreen.getScreenX() * -1),
				Gdx.input.getY() - ((Gdx.graphics.getHeight() / 2) - this.getEntitySprite().getWidth()) - GameScreen.getScreenY() + (this.getPosY() * 2))) {
			this.getEntitySprite().setColor(1, 1, 1, 0.5f);
			this.setHovered(true);
			if(Gdx.input.justTouched()) {
				lookAt();
				this.setClicked(true);
			}
		}
		else {
			this.getEntitySprite().setColor(1, 1, 1, 1);
			this.setClicked(false);
			this.setHovered(false);
		}
	}
	public void lookAt() {
		//GameScreen.getCamera().translate(GameScreen.getScreenX() * -1 + realX, GameScreen.getScreenY() * -1 + realY);

	}
	
}
