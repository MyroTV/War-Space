package com.me.gui;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BuildingButton extends Button {
	
	private SpriteBatch batch;
	private Sprite buildingButtonSprite;
	public BuildingButton(int posX, int posY) {
		super(posX, posY);
	}
	public void dispose() {
	
	}
	public void init() {
		batch = new SpriteBatch();
		buildingButtonSprite = new Sprite();
	}
	public void render() {

	}
	public void update() {

	}

}
