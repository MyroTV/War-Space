package com.me.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.ai.AStarGrid;
import com.me.gdxtestgame.MyGame;
import com.me.gui.DebugOverlay;
import com.me.gui.TextBox;
import com.me.utils.KeyListener;

public class MainMenuScreen implements Screen {

	private Texture mainMenuScreenTexture;
	private Texture startButtonTexture;
	private Sprite startButtonSprite;
	private Sprite mainMenuScreenSprite;
	private SpriteBatch batch, batch2;
	MyGame game;
	private TextBox tb;
	private DebugOverlay dbOverlay;
	private AStarGrid ASGrid;

	public MainMenuScreen(MyGame game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		update();
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.begin();
			mainMenuScreenSprite.draw(batch);
			startButtonSprite.draw(batch);
			//tb.drawSprite(batch);
			//ASGrid.render();
		batch.end();
		//tb.render();
	}

	@Override
	public void resize(int width, int height) {

	}

	public void update() {
		if(startButtonSprite.getBoundingRectangle().contains(Gdx.input.getX(), (Gdx.graphics.getHeight() - Gdx.input.getY()))) {
			startButtonSprite.setColor(1.0f, 1.0f, 1.0f, 0.4f);
			if(Gdx.input.isButtonPressed(Keys.LEFT)) {
				this.game.setScreen(game.getGameScreen());
			}
		}
		else {
			startButtonSprite.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		}
		//tb.update();
		dbOverlay.update();
	}
	@Override
	public void show() {
		Gdx.graphics.setDisplayMode(
	              Gdx.graphics.getDesktopDisplayMode().width,
	              Gdx.graphics.getDesktopDisplayMode().height, 
	              true
		);
		
		Texture.setEnforcePotImages(false); //Do not put anything before this
		
		batch = new SpriteBatch();
		batch2 = new SpriteBatch();
		
		ASGrid = new AStarGrid(5,5);
		ASGrid.show();
		ASGrid.setBatch(batch);
		
		tb = new TextBox(true);
		tb.show();
		dbOverlay = new DebugOverlay();
		dbOverlay.show();
		
		mainMenuScreenTexture = new Texture(Gdx.files.internal("assets/newBG.png"));
		startButtonTexture = new Texture(Gdx.files.internal("assets/startButton.png"));
		mainMenuScreenTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		startButtonTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		mainMenuScreenSprite = new Sprite(mainMenuScreenTexture);
		startButtonSprite = new Sprite(startButtonTexture);
		mainMenuScreenSprite.setPosition(0, 0);
		startButtonSprite.setPosition(50, 300);
		mainMenuScreenSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());	
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
		this.dispose();
	}

}
