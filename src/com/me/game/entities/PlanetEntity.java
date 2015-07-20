package com.me.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.renderers.Renderer;
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
			super.getEntitySprite().draw(batch);
			super.getEntityLabel().draw(batch, getEntityName(), super.getPosX(), super.getPosY());
		batch.end();
	}
	
	public void update() {
		checkClick();
	}

	public void dispose() {
		super.setSpriteTexture(null);
		super.setEntitySprite(null);
	}

	public void initialiseGraphics() {
		batch = new SpriteBatch();
		super.getEntitySprite().setPosition(getPosX(), getPosY());
		//super.getEntitySprite().setTexture(getSpriteTexture());
	}
	
	void checkClick() {
		if(super.getEntitySprite().getBoundingRectangle().contains(Gdx.input.getX() - (Gdx.graphics.getWidth() / 2) - (GameScreen.getScreenX() * -1), Gdx.input.getY() - ((Gdx.graphics.getHeight() / 2) - super.getEntitySprite().getWidth()) - GameScreen.getScreenY() + (super.getPosY() * 2))) {
			super.getEntitySprite().setColor(1, 1, 1, 0.5f);
			if(Gdx.input.justTouched()) {
				lookAt();
				super.setClicked(true);
			}
		}
		else {
			super.getEntitySprite().setColor(1, 1, 1, 1);
			super.setClicked(false);
		}
	}
	public void lookAt() {
		//GameScreen.getCamera().translate(GameScreen.getScreenX() * -1 + realX, GameScreen.getScreenY() * -1 + realY);

	}
	
}
