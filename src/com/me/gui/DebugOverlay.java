package com.me.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.screens.GameScreen;

public class DebugOverlay {
	
	private String mouseX, mouseY, screenX, screenY, gameTurn, FPS;
	private SpriteBatch batch;
	private BitmapFont mouseXLabel, mouseYLabel, screenXLabel, screenYLabel, gameTurnLabel, FPSLabel, framesPastLabel, elapsedTimeLabel;
	private boolean isActive;
	long f3cd1 = 0, f3cd2 = 150000000; //cooldown for debug overlay
	int tick, framesPast = 0, tickLength = 120, turns; //tick is the game tick, tick length will be used to allow faster or slower game speeds, turn is amount of turns past
	float elapsedTime = 0;
	
	public String getMouseX() {
		return mouseX;
	}
	public void setMouseX(String mouseX) {
		this.mouseX = mouseX;
	}
	public String getMouseY() {
		return mouseY;
	}
	public void setMouseY(String mouseY) {
		this.mouseY = mouseY;
	}
	public String getScreenX() {
		return screenX;
	}
	public void setScreenX(String screenX) {
		this.screenX = screenX;
	}
	public String getScreenY() {
		return screenY;
	}
	public void setScreenY(String screenY) {
		this.screenY = screenY;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public float getElapsedTime() {
		return this.elapsedTime;
	}
	public int getFramesPast() {
		return this.framesPast;
	}
	public void show() {
		batch = new SpriteBatch();
		mouseXLabel = new BitmapFont();
		mouseYLabel = new BitmapFont();
		screenXLabel = new BitmapFont();
		screenYLabel = new BitmapFont();
		gameTurnLabel = new BitmapFont();
		FPSLabel = new BitmapFont();
		framesPastLabel = new BitmapFont();
		elapsedTimeLabel = new BitmapFont();
		mouseX = "";
		mouseY = "";
		screenX = "";
		screenY = "";
		gameTurn = "";
		FPS = "";
	}
	public void render() {
		batch.begin();
		if(this.isActive == true) {
			mouseXLabel.draw(batch, mouseX, 0, 1020);
			mouseYLabel.draw(batch, mouseY, 0, 1000);
			screenXLabel.draw(batch, screenX, 0, 980);
			screenYLabel.draw(batch, screenY, 0, 960);
			gameTurnLabel.draw(batch, gameTurn, 0, 940);
			FPSLabel.draw(batch, FPS, 0, 920);
			framesPastLabel.draw(batch, "Frames past: " + framesPast, 0, 900);
			elapsedTimeLabel.draw(batch, "Elapsed time: " + elapsedTime, 0, 880);
		}
		batch.end();
	}
	
	public void update() {
		tick ++;
		framesPast++;
		elapsedTime += Gdx.app.getGraphics().getDeltaTime();
		if(framesPast == 2147483646) {
			framesPast = 0;
		}
		if(tick == tickLength) { //tickLength dictates how long each turn will be. currently FPS based. need time alternative
			turns++;
			tick = 0;
		}
		//COOLDOWN BEGIN       (Cooldown was needed because update is called multiple times per second so just pressing F3 once could change the boolean multiple times)
		if(Gdx.input.isKeyPressed(Keys.F3) && this.isActive() == false && f3cd1 == 0) {
				this.setActive(true);
				f3cd1 = System.nanoTime();
		}
		if(Gdx.input.isKeyPressed(Keys.F3) && this.isActive() == false && System.nanoTime() - f3cd1 > f3cd2) {
			this.setActive(true);
			f3cd1 = System.nanoTime();
		}
		else if((Gdx.input.isKeyPressed(Keys.F3) && this.isActive() == true)) {
			if(System.nanoTime() - f3cd1 > f3cd2) {
			this.setActive(false);
			f3cd1 = System.nanoTime();
			}
		}
		//COOLDOWN END
		mouseX = "Mouse X-coordinate: " + Gdx.input.getX();
		mouseY = "Mouse Y-coordinate: " + Gdx.input.getY();
		screenX = "Screen X-coordinate: " + GameScreen.getScreenX();
		screenY = "Screen Y-coordinate: " + GameScreen.getScreenY();
		gameTurn = "Game turn: " + turns + " Tick: " + tick;
		FPS = "FPS: " + Gdx.graphics.getFramesPerSecond();
	}
}
