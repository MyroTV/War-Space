package com.me.gui;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.me.interfaces.GUIElement;

public abstract class Button implements GUIElement {
	private Sprite buttonSprite;
	
	private int posX, posY;
	
	public Button(int sizeX, int sizeY, int posX, int posY) {
	
	}
	
	public Button(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public abstract void init();
	public abstract void render();
	public abstract void update();
	
	public int getX() {
		return posX;
	}
	
	public int getY() {
		return posY;
	}
}
