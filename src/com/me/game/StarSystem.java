package com.me.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.screens.GameScreen;

public class StarSystem {
	
	private Galaxy parentGalaxy;
	private String systemName;
	private int numberOfPlanets;
	private ArrayList<Planet> planets;
	private Sprite starSprite;
	private Texture starTexture;
	private SpriteBatch batch;
	private boolean inFocus = false;
	private StarType starType;
	private float realY;
	private BitmapFont starSystemLabel;
	private int x,y;
	
	private Texture planetTexture;
	
	public StarSystem(String systemName, int numberOfPlanets, StarType starType) {
		this.systemName = systemName;
		this.numberOfPlanets = numberOfPlanets;
		this.starType = starType;
		this.starTexture = starType.getStarTexture();
	}
	
	public void generatePlanets() {
		for(int i = 0; i < numberOfPlanets; i++) {
			planets.add(new Planet(Universe.getRandomPlanetName(), new PlanetType("metallic")));
			
			//Universe.removePlanetNameFromArray(planets.get(i).getPlanetName());
			planets.get(i).setParentStar(this);
			planets.get(i).show();
			if(i == 0) {
				planets.get(i).getPlanetSprite().setPosition(100 + x, 100 + y);
				planets.get(i).setRealX(100);
				planets.get(i).setRealY(100);
			}
			else {
				planets.get(i).getPlanetSprite().setPosition((i + 1) * 100 + x, (i + 1) * 100 + y);
				planets.get(i).setRealX((i + 1) * 100);
				planets.get(i).setRealY((i + 1) * 100);
			}
		}
	}
	
	public void setRandomStarSprite() {
		
	}
	
	public void addPlanet() {
		
	}
	
	public void removePlanet() {
		
	}
	
	public void setParentGalaxy(Galaxy parentGalaxy) {
		this.parentGalaxy = parentGalaxy;
	}
	
	public Galaxy getParentGalaxy() {
		return this.parentGalaxy;
	}
	
	public Sprite getSprite() {
		return this.starSprite;
	}
	
	public boolean getFocus() {
		return this.inFocus;
	}
	
	public void setFocus(boolean focus) {
		this.inFocus = focus;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ArrayList<Planet> getPlanets() {
		return this.planets;
	}
	
	public String getSystemName() {
		return this.systemName;
	}
	
	public void show() {
		planets = new ArrayList<Planet>();
		starSystemLabel = new BitmapFont();
		starSprite = new Sprite(this.starTexture);
		batch = new SpriteBatch();
	}
	
	public void render() {
		batch.setProjectionMatrix(GameScreen.getCamera().combined);
		
		if(this.getFocus() == true) {
			for(int i = 0; i < planets.size(); i++) {
					planets.get(i).render();
			}
		}
		batch.begin();
		if(parentGalaxy.getFocus() == true) {
			this.starSprite.draw(batch);
			starSystemLabel.draw(batch, systemName, starSprite.getX(), starSprite.getY());
			//starSprite.setX((float) Math.sin(GameScreen.getDebugOverlay().getElapsedTime() / 25) * 100); makes object translate in a circular motion
			//starSprite.setY((float) Math.cos(GameScreen.getDebugOverlay().getElapsedTime() / 25) * 100);
		}
		if(this.getFocus() == true) {
			//this.starSprite.setPosition(0, 0);
			this.starSprite.draw(batch);
			starSystemLabel.draw(batch, systemName, starSprite.getX(), starSprite.getY());
		}
		batch.end();
	}
	public void lookAt() {
		GameScreen.getCamera().translate(GameScreen.getScreenX() * -1 + x, GameScreen.getScreenY() * -1 + y);
	}
	
	public void update() {
		this.realY = this.starSprite.getY() * 2;
		for(int i = 0; i < planets.size(); i++) {
			planets.get(i).update();
		}
		if(this.starSprite.getBoundingRectangle().contains(Gdx.input.getX() - 840 - (GameScreen.getScreenX() * -1), Gdx.input.getY() - (510 - starSprite.getWidth()) - GameScreen.getScreenY() + realY)) {
			this.starSprite.setColor(1, 1, 1, 0.5f);
			if(Gdx.input.justTouched() && parentGalaxy.getFocus() == true) {
				System.out.print(this.systemName + " clicked");
				this.parentGalaxy.setFocus(false);
				this.parentGalaxy.setChildStarFocused(true);
				this.setFocus(true);
				this.lookAt();
			}
		}
		else {
			starSprite.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		}
	}
}
