package com.me.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.game.Planet;
import com.me.game.PlanetType;
import com.me.game.PlayersHandler;
import com.me.game.Universe;
import com.me.gdxtestgame.MyGame;
import com.me.gui.DebugOverlay;
import com.me.renderers.UniverseRenderer;

public class GameScreen implements Screen{

	MyGame game;
	private static int screenX;
	private static int screenY;
	private SpriteBatch batch;
	private static OrthographicCamera camera;
	private static DebugOverlay dbOverlay;
	private static UniverseRenderer universeRenderer;
	private PlayersHandler playerHandler;
	
	public GameScreen(MyGame game) {
		this.game = game;
	}
	
	public static OrthographicCamera getCamera() {
		return GameScreen.camera;
	}
	
	public static int getScreenX() {
		return screenX;
	}
	
	public static UniverseRenderer getUniverseRenderer() {
		return universeRenderer;
	}

	public static void setScreenX(int screenX) {
		GameScreen.screenX = screenX;
	}

	public static int getScreenY() {
		return screenY;
	}

	public static void setScreenY(int screenY) {
		GameScreen.screenY = screenY;
	}
	
	public static DebugOverlay getDebugOverlay() {
		return GameScreen.dbOverlay;
	}
	

	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		this.update();
		batch.begin();
		universeRenderer.render();
		dbOverlay.render();
		batch.end();
	}

	@Override
	public void resize(int width, int height) {

		
	}
	
	public void update() {
		if(Gdx.input.isKeyPressed(Keys.W)) {
			camera.translate(0, 5);
		}
		if(Gdx.input.isKeyPressed(Keys.A)) {
			camera.translate(-5, 0);
		}
		if(Gdx.input.isKeyPressed(Keys.S)) {
			camera.translate(0, -5);
		}
		if(Gdx.input.isKeyPressed(Keys.D)) {
			camera.translate(5, 0);
		}
		camera.update();
		dbOverlay.update();
		universeRenderer.update();
		GameScreen.setScreenX((int) camera.position.x);
		GameScreen.setScreenY((int) camera.position.y);
	}

	@Override
	public void show() {
		universeRenderer = new UniverseRenderer();
		universeRenderer.show();
		dbOverlay = new DebugOverlay();
		dbOverlay.show();
		camera = new OrthographicCamera(1680, 1020);
		batch = new SpriteBatch();
		playerHandler = new PlayersHandler(1);
		playerHandler.show();
	}

	@Override
	public void hide() {

		
	}

	@Override
	public void pause() {

		
	}

	@Override
	public void resume() {

		
	}

	@Override
	public void dispose() {

		
	}

}
