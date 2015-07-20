package com.me.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.game.entities.StarSystemEntity;
import com.me.renderers.Renderer;
import com.me.screens.GameScreen;

public class StarSystem {
	
	private StarSystemEntity starSystemEntity;
	
	private Galaxy parentGalaxy;
	private String systemName;
	private int numberOfPlanets;
	private ArrayList<Planet> planets;
	private Sprite starSprite;
	private SpriteBatch batch;
	private boolean inFocus = false;
	private boolean graphicsInitialised = false;
	private boolean childPlanetsGenerated = false;
	private StarType starType;
	private float realY;
	private BitmapFont starSystemLabel;
	private int posX,posY;
	
	public StarSystem(String systemName, int numberOfPlanets, StarType starType) {
		this.systemName = systemName;
		this.numberOfPlanets = numberOfPlanets;
		this.starType = starType;
	}
	
	public void generatePlanets() {
		for(int i = 0; i < numberOfPlanets; i++) {
			planets.add(new Planet(Universe.getRandomPlanetName(), new PlanetType("metallic")));
			
			//Universe.removePlanetNameFromArray(planets.get(i).getPlanetName());
			planets.get(i).setParentStar(this);
			if(i == 0) {
				planets.get(i).setPosX(100 + posX);
				planets.get(i).setPosY(100 + posY);
				planets.get(i).show();
			}
			else {
				planets.get(i).setPosX((i + 1) * 100 + posX);
				planets.get(i).setPosY((i + 1) * 100 + posY);
				planets.get(i).show();
			}
		}
		this.childPlanetsGenerated = true;
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
		return posX;
	}

	public void setX(int x) {
		this.posX = x;
	}

	public int getY() {
		return posY;
	}

	public void setY(int y) {
		this.posY = y;
	}

	public ArrayList<Planet> getPlanets() {
		return this.planets;
	}
	
	public String getSystemName() {
		return this.systemName;
	}
	
	public void setAreChildPlanetsGenerated(boolean areChildPlanetsGenerated) {
		this.childPlanetsGenerated = areChildPlanetsGenerated;
	}
	
	public void show() {
		planets = new ArrayList<Planet>();
		initialiseGraphics();
	}
	
	public void render() {
		batch.setProjectionMatrix(GameScreen.getCamera().combined);

		if(this.getFocus() == true) {
			for(int i = 0; i < planets.size(); i++) {
				planets.get(i).render();
			}
		}
		batch.begin();
		if(parentGalaxy.getFocus() == true && graphicsInitialised == true) {
			this.starSprite.draw(batch);
			starSystemLabel.draw(batch, systemName, this.getX(), this.getY());
			//starSprite.setX((float) Math.sin(GameScreen.getDebugOverlay().getElapsedTime() / 25) * 100); makes object translate in a circular motion
			//starSprite.setY((float) Math.cos(GameScreen.getDebugOverlay().getElapsedTime() / 25) * 100);
		}
		if(this.getFocus() == true) {
			this.starSprite.draw(batch);
			starSystemLabel.draw(batch, systemName, starSprite.getX(), starSprite.getY());
		}
		batch.end();
		
		checkClick();
	}
	public void lookAt() {
		GameScreen.getCamera().translate(GameScreen.getScreenX() * -1 + posX, GameScreen.getScreenY() * -1 + posY);
	}
	
	public void update() {
		this.realY = this.starSprite.getY() * 2;
		if(this.inFocus == true && this.childPlanetsGenerated == true) {
			for(int i = 0; i < planets.size(); i++) {
				planets.get(i).update();
			}
		}

	}
	public boolean isGraphicsInitialised() {
		return graphicsInitialised;
	}

	public void setGraphicsInitialised(boolean graphicsInitialised) {
		this.graphicsInitialised = graphicsInitialised;
	}

	public void dispose() {
		System.out.print("Star System graphics destroyed \n");
		batch.dispose();
		batch = null;
		starSprite.setTexture(null);
		starSprite = null;
		starSystemLabel.dispose();
		starSystemLabel = null;
		setGraphicsInitialised(false);
	}
	
	void checkClick() {
		if(starSystemEntity.isClicked() == true) {
			if(this.childPlanetsGenerated == false) {
				this.generatePlanets();
				System.out.print("Planets generated in: " + this.systemName);
			}
			this.parentGalaxy.setFocus(false);
			for(int i = 0; i < planets.size(); i++) {
				if(planets.get(i).isGraphicsInitialised() == false) {
					planets.get(i).initialiseGraphics();
					System.out.print("Planet graphics initialised in: " + this.systemName);
				}
			}
			this.parentGalaxy.setChildStarFocused(true);
			this.setFocus(true);
		}
		
		if(this.starSprite.getBoundingRectangle().contains(Gdx.input.getX() - (Gdx.graphics.getWidth() / 2) - (GameScreen.getScreenX() * -1), Gdx.input.getY() - ((Gdx.graphics.getHeight() / 2) - starSprite.getWidth()) - GameScreen.getScreenY() + realY)) {
			this.starSprite.setColor(1, 1, 1, 0.5f);
			if(Gdx.input.justTouched() && parentGalaxy.getFocus() == true) {
				System.out.print(this.systemName + " clicked");
				if(this.childPlanetsGenerated == false) {
					this.generatePlanets();
					System.out.print("Planets generated in: " + this.systemName);
				}
				this.parentGalaxy.setFocus(false);
				for(int i = 0; i < planets.size(); i++) {
					if(planets.get(i).isGraphicsInitialised() == false) {
						planets.get(i).initialiseGraphics();
						System.out.print("Planet graphics initialised in: " + this.systemName);
					}
				}
				this.parentGalaxy.setChildStarFocused(true);
				this.setFocus(true);
				this.lookAt();
			}
		}
		else {
			starSprite.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		}
	}
	
	public void initialiseGraphics() {
		batch = new SpriteBatch();
		starSprite = new Sprite(TextureLoader.getYellowStar());
		starSprite.setPosition(getX(), getY());
		starSystemLabel = new BitmapFont();
		setGraphicsInitialised(true);
		
		starSystemEntity = new StarSystemEntity(TextureLoader.getYellowStar(), this.systemName, this.posX, this.posY);
	}
}
