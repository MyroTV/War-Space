package com.me.renderers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.gui.DebugOverlay;

public class Renderer {
	private static GUIRenderer guiRenderer;
	private static UniverseRenderer universeRenderer;
	private static DebugOverlay dbOverlay;
	
	private SpriteBatch batch;
	
	public Renderer() {
		
	}
	
	public void show() {
		batch = new SpriteBatch();
		universeRenderer = new UniverseRenderer();
		universeRenderer.show();
		guiRenderer = new GUIRenderer();
		guiRenderer.show();
		dbOverlay = new DebugOverlay();
		dbOverlay.show();
	}
	
	public void render() {
		batch.begin();
		
			universeRenderer.render();
			guiRenderer.render();
			dbOverlay.render();
			
		batch.end();
	}
	
	public void update() {
		universeRenderer.update();
		guiRenderer.update();
		dbOverlay.update();
	}
	
	public static GUIRenderer getGUIRenderer() {
		return guiRenderer;
	}
	
	public static UniverseRenderer getUniverseRenderer() {
		return universeRenderer;
	}
}
