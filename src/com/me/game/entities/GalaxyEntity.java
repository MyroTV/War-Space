package com.me.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.screens.GameScreen;

public class GalaxyEntity extends Entity {
	private SpriteBatch batch;
	public GalaxyEntity(Texture spriteTexture, String entityName, int posX,
			int posY) {
		super(spriteTexture, entityName, posX, posY);
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
		System.out.print("Galaxy entity initialised \n");
	}
	
	public void checkClick() {
		if(this.getEntitySprite().getBoundingRectangle().contains(Gdx.input.getX() - (Gdx.graphics.getWidth() / 2) - (GameScreen.getScreenX() * -1), Gdx.input.getY() - ((Gdx.graphics.getHeight() / 2) - this.getEntitySprite().getWidth()) - GameScreen.getScreenY() + (this.getPosY() * 2))) {
			this.getEntitySprite().setColor(1, 1, 1, 0.5f);
			if(Gdx.input.justTouched()) {
				System.out.print(this.getEntityName() + " clicked");
				
				this.lookAt();
				this.setClicked(true);
			}
		}
		else {
			this.getEntitySprite().setColor(1.0f, 1.0f, 1.0f, 1.0f);
			this.setClicked(false);
		}
	}

	public void lookAt() {
		
	}

}
