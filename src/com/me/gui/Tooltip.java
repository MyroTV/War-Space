package com.me.gui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.game.TextureLoader;
import com.me.interfaces.GUIElement;
import com.me.renderers.GUIRenderer;
import com.me.screens.GameScreen;

public class Tooltip implements GUIElement {
	
	private String content;
	private int height, width, posX, posY;
	private int maxWidth, maxHeight;
	private Sprite tooltipSprite;
	private SpriteBatch batch;
	private boolean isActive = false;
	
	public Tooltip(String content) {
		this.content = content;
	}
	
	public void init() {
		tooltipSprite = new Sprite(TextureLoader.getTooltip());
		batch = new SpriteBatch();
	}
	
	public void dispose() {
		batch.dispose();
		tooltipSprite = null;
	}
	
	public void render() {
		if(isActive) {
			batch.setProjectionMatrix(GUIRenderer.getGraphicsCamera().combined);
			batch.begin();
			batch.end();
		}
	}
	
	public void setDimensions() {
		
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}