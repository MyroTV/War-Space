package com.me.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

//Entity system to seperate GUI and game-data from renderable objects
//Entity objects can be de-referenced but the object still holds the data it needs
//Thereby reducing the amount of memory used
public abstract class Entity {
	private Sprite entitySprite;
	private Texture spriteTexture;
	private String entityName;
	private BitmapFont entityLabel;
	private int posX, posY;
	private boolean clicked = false;
	
	public Entity(Texture spriteTexture, String entityName, int posX, int posY) {
		this.setSpriteTexture(spriteTexture);
		this.setEntityName(entityName);
		this.setPosX(posX);
		this.setPosY(posY);		
		
		this.init();
		//this.getEntitySprite().setTexture(this.getSpriteTexture());
	}
	
	public abstract void show();
	public abstract void render();
	public abstract void update();
	public abstract void dispose();
	public abstract void initialiseGraphics();
	public abstract void lookAt();
	
	public void init() {
		this.entitySprite = new Sprite(this.getSpriteTexture());
		this.entityLabel = new BitmapFont();
	}

	public Sprite getEntitySprite() {
		return entitySprite;
	}

	public void setEntitySprite(Sprite entitySprite) {
		this.entitySprite = entitySprite;
	}

	public Texture getSpriteTexture() {
		return spriteTexture;
	}

	public void setSpriteTexture(Texture spriteTexture) {
		this.spriteTexture = spriteTexture;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public BitmapFont getEntityLabel() {
		return entityLabel;
	}

	public void setEntityLabel(BitmapFont entityLabel) {
		this.entityLabel = entityLabel;
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

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
}
