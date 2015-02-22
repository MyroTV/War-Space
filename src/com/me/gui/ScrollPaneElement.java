package com.me.gui;

import com.me.interfaces.GUIElement;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScrollPaneElement implements GUIElement {
	private int x, y, sizeX, sizeY;
	private ScrollPane parentScrollPane;
	private String structureNameText;
	private BitmapFont structureNameLabel;
	private SpriteBatch batch;
	
	public ScrollPaneElement(int x, int y, int sizeX, int sizeY, ScrollPane parentScrollPane) {
		
	}
	
	public void setPaneText(String structureName) {
		structureNameText = structureName;
	}
	
	public void show() {
		structureNameLabel = new BitmapFont();
	}
	
	public void update() {
		
	}
	
	public void render() {
		batch.begin();		
		structureNameLabel.draw(batch, structureNameText, x, y);
	}
	
}
