package com.me.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlanetEntity extends Entity {
	private SpriteBatch batch;
	
	public PlanetEntity(Texture spriteTexture, String planetName) {
		super(spriteTexture, planetName);
		super.init();
		this.initialiseGraphics();
	}
	
	public void show() {

	}

	public void render() {	
		batch.begin();
			super.getEntitySprite().draw(batch);
			super.getEntityLabel().draw(batch, getEntityName(), 0, 0);
		batch.end();
	}
	
	public void update() {
				
	}

	public void dispose() {
				
	}

	public void initialiseGraphics() {
		super.getEntitySprite().setTexture(getSpriteTexture());
	}
	
	
}
