package com.me.gui;

import com.me.game.structures.Structure;
import com.me.interfaces.GUIElement;
import com.me.renderers.GUIRenderer;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScrollPaneElement implements GUIElement {
	private int x, y, sizeX, sizeY;
	private ScrollPane parentScrollPane;
	private String structureNameText;
	private BitmapFont structureNameLabel;
	private SpriteBatch batch;
	private Structure structure;
	
	public ScrollPaneElement(int x, int y, int sizeX, int sizeY, ScrollPane parentScrollPane, Structure structure) {
		this.x = x;
		this.y = y;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.parentScrollPane = parentScrollPane;
		this.structure = structure;
	}
	
	public void setPaneText(String structureName) {
		structureNameText = structureName;
	}
	
	public void show() {
		structureNameLabel = new BitmapFont();
		batch = new SpriteBatch();
	}
	
	public void update() {
		
	}
	
	public void render() {
		batch.setProjectionMatrix(GUIRenderer.getGraphicsCamera().combined);
		batch.begin();
		structureNameLabel.draw(batch, structure.getName(), x, y);
		batch.end();
	}
	
}
