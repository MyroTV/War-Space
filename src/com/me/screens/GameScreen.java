package com.me.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.game.PlayersHandler;
import com.me.gdxtestgame.MyGame;
import com.me.renderers.Renderer;

public class GameScreen implements Screen{

	MyGame game;
	private static int screenX;
	private static int screenY;
	private SpriteBatch batch;
	private static OrthographicCamera camera;
	private static Renderer renderer;
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

	public static void setScreenX(int screenX) {
		GameScreen.screenX = screenX;
	}

	public static int getScreenY() {
		return screenY;
	}

	public static void setScreenY(int screenY) {
		GameScreen.screenY = screenY;
	}
	
	public static Renderer getRenderer() {
		return renderer;
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		this.update();
		
		batch.begin();
		
			renderer.render();
			
		batch.end();
	}

	public void resize(int width, int height) {
		
	}
	
	public void update() {
		if(camera.viewportWidth != Gdx.graphics.getWidth()) {
			camera.viewportWidth = Gdx.graphics.getWidth();
		}
		
		if(camera.viewportHeight != Gdx.graphics.getHeight()) {
			camera.viewportHeight = Gdx.graphics.getHeight();
		}
		
		if(Gdx.input.isKeyPressed(Keys.W)) {
			camera.translate(0, 8);
		}
		if(Gdx.input.isKeyPressed(Keys.A)) {
			camera.translate(-8, 0);
		}
		if(Gdx.input.isKeyPressed(Keys.S)) {
			camera.translate(0, -8);
		}
		if(Gdx.input.isKeyPressed(Keys.D)) {
			camera.translate(8, 0);
		}
		camera.update();
		renderer.update();
		GameScreen.setScreenX((int) camera.position.x);
		GameScreen.setScreenY((int) camera.position.y);
	}

	public void show() {
		renderer = new Renderer();
		renderer.show();
		camera = new OrthographicCamera(1680, 1020);
		batch = new SpriteBatch();
		playerHandler = new PlayersHandler(1);
		playerHandler.show();
	}

	public void hide() {
		
	}

	public void pause() {

	}

	public void resume() {

	}

	public void dispose() {

	}

}
