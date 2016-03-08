package com.me.gdxtestgame;

import com.badlogic.gdx.Game;
import com.me.game.TextureLoader;
import com.me.screens.GameScreen;
import com.me.screens.MainMenuScreen;

public class MyGame extends Game {

	MainMenuScreen mainMenuScreen;
	private GameScreen gameScreen;
	private TextureLoader textureLoader;
	
	@Override
	public void create() {
		textureLoader = new TextureLoader();
		textureLoader.loadTextures();
		mainMenuScreen = new MainMenuScreen(this);
		setGameScreen(new GameScreen(this));
		setScreen(mainMenuScreen);
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	public GameScreen getGameScreen() {
		return gameScreen;
	}

	public void setGameScreen(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}
}
