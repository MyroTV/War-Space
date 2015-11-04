package com.me.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.game.TextureLoader;
import com.me.interfaces.GUIElement;
import com.me.renderers.GUIRenderer;
import com.me.screens.GameScreen;

public class Tooltip implements GUIElement {

	private String content;
	private BitmapFont contentFont;
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
		setDimensions(content);
		contentFont = new BitmapFont();
	}

	public void dispose() {
		batch.dispose();
		batch = null;
		contentFont.dispose();
		contentFont = null;
		content = null;
		tooltipSprite = null;
	}

	public void render() {
		tooltipSprite.setPosition(posX, posY);
		//batch.setProjectionMatrix(GUIRenderer.getGraphicsCamera().combined);
		batch.begin();
		tooltipSprite.draw(batch);
		batch.end();
	}

	public void setDimensions(String content) {
		//will take description as an argument and calculate the dimensions based on the size of the string
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setPosition(int x, int y) {
		this.posX = x;
		this.posY = y;
	}
}