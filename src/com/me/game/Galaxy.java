package com.me.game;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.screens.GameScreen;
import com.me.utils.RandomInt;

public class Galaxy {

	private ArrayList<StarSystem> starSystems = new ArrayList<StarSystem>();
	private boolean inFocus = false;
	private boolean isChildStarFocused = false;
	private Universe parentUniverse;
	private String galaxyName;
	private int numberOfSystems;
	private Sprite galaxySprite;
	private SpriteBatch batch;
	private Texture galaxyTexture;
	private GalaxyType galaxyType;
	private BitmapFont galaxyLabel;
	
	private int[] spiralGalaxy = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
								  0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,
								  0,0,0,0,0,0,0,0,1,1,0,0,1,0,0,0,0,1,0,0,0,0,0,
								  0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,
								  0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
								  0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,1,0,0,0,
								  0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,1,0,0,0,0,0,0,0,
								  0,1,0,0,0,0,0,1,0,0,0,0,1,0,1,0,1,0,1,0,0,0,0,
								  0,0,0,0,0,0,0,0,1,0,1,1,0,1,0,0,0,0,0,0,0,0,0,
								  0,0,0,0,0,1,0,1,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,
								  0,0,0,0,1,0,1,0,0,1,0,0,1,0,1,0,1,0,0,0,0,0,0,
								  0,0,0,1,0,1,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,
								  0,0,0,0,0,0,1,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,
								  0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,
								  0,0,0,1,0,1,0,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,
								  0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
								  0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,
								  0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,
								  0,0,0,0,0,1,0,1,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,
								  0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,
								  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private float realX, realY;
	
	public Galaxy(String galaxyName, int numberOfSystems, GalaxyType galaxyType) {
		this.galaxyName = galaxyName;
		this.numberOfSystems = numberOfSystems;
		this.galaxyType = galaxyType;
	}
	
	public void generateStarSystems() {
		for(int i = 0; i < this.numberOfSystems; i++) {
			starSystems.add(new StarSystem("System " + i, RandomInt.newRandom(10), new StarType("yellowStar")));
			starSystems.get(i).show();
			starSystems.get(i).setParentGalaxy(this);
			starSystems.get(i).getSprite().setPosition(i * 100, i * 100);
		}
	}
	
	public void generateTest() {
		int x = 0, y = 0, j = 0;
		ArrayList<Integer> values = new ArrayList<Integer>();
		String ln[] = null;
		
		try {
			FileInputStream fStream = new FileInputStream("assets/spiralGalaxySystemPlacements");
			BufferedReader br = new BufferedReader(new InputStreamReader(fStream));
			try {
				while(br.ready()) {
					ln = br.readLine().split(",");
				}
				br.close();
				fStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if(ln != null) {
			for(int i = 0; i < spiralGalaxy.length; i++) {
				values.add(spiralGalaxy[i]);
			}
		}
		
		for(int i = 0; i < values.size(); i++) {
			if(values.get(i) == 1) {
				starSystems.add(new StarSystem("System " + j, RandomInt.newRandom(10), new StarType("yellowStar")));
				starSystems.get(j).show();
				starSystems.get(j).setParentGalaxy(this);
				starSystems.get(j).getSprite().setPosition(x * 100, y * 100);
				starSystems.get(j).setX(x * 100);
				starSystems.get(j).setY(y * 100);
				//System.out.print("Star System " + j + " generated in " + galaxyName + "\n");
				starSystems.get(j).generatePlanets();
				j++;
			}
			x++;
			if(x == 23) {
				x = 0;
				y++;
			}
		}
			
	}
	
	public void lookAt() {
		GameScreen.getCamera().translate(GameScreen.getScreenX() * -1 + realX, GameScreen.getScreenY() * -1 + (realY / 2));
	}
	
	public void render() {
		this.batch.setProjectionMatrix(GameScreen.getCamera().combined);
		
		if(this.getFocus() == true) {
			for(int i = 0; i < starSystems.size(); i++) {
				starSystems.get(i).render();
			}
		}
		else if(getActiveStarSystem() != null) {
			getActiveStarSystem().render();
		}
		
		this.batch.begin();
		
		if(this.parentUniverse.getFocus() == true) {
			this.galaxySprite.draw(this.batch);
			galaxyLabel.draw(batch, galaxyName, galaxySprite.getX(), galaxySprite.getY());
		}
		
		this.batch.end();
	}
	
	public void show() {
		this.galaxyTexture = galaxyType.getGalaxyTexture();
		this.galaxySprite = new Sprite(this.galaxyTexture);
		this.batch = new SpriteBatch();
		//this.generateStarSystems();
		this.generateTest();
		this.galaxyLabel = new BitmapFont();
	}
	
	public void update() {
		this.realX = this.galaxySprite.getX();
		this.realY = this.galaxySprite.getY() * 2;
		
		if(this.getFocus() == true) {
			for(int i = 0; i < starSystems.size(); i++) {
				starSystems.get(i).update();
			}
		}
		else if(getActiveStarSystem() != null) {
			getActiveStarSystem().update();
		}
		
		if(this.galaxySprite.getBoundingRectangle().contains(Gdx.input.getX() - (Gdx.graphics.getWidth() / 2) - (GameScreen.getScreenX() * -1), Gdx.input.getY() - ((Gdx.graphics.getHeight() / 2) - galaxySprite.getWidth()) - GameScreen.getScreenY() + realY)) {
			this.galaxySprite.setColor(1, 1, 1, 0.5f);
			if(Gdx.input.justTouched() && parentUniverse.getFocus() == true) {
				System.out.print(this.galaxyName + " clicked\n");
				Universe.setFocus(false);
				this.inFocus = true;
				
			}
		}
		else {
			galaxySprite.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		}
	}
	
	public boolean getFocus() {
		return this.inFocus;
	}
	
	public String getGalaxyName() {
		return this.galaxyName;
	}
	
	public void setFocus(boolean focus) {
		this.inFocus = focus;
	}
	
	public void setParentUniverse(Universe universe) {
		this.parentUniverse = universe;
	}
	
	public Sprite getGalaxySprite() {
		return this.galaxySprite;
	}
	
	public ArrayList<StarSystem> getStarSystems() {
		return this.starSystems;
	}
	
	public Universe getParentUniverse() {
		return this.parentUniverse;
	}
	
	public StarSystem getActiveStarSystem() {
		if(starSystems != null) {
			for(int i = 0; i < starSystems.size(); i++) {
				if(starSystems.get(i).getFocus() == true) {
					this.setChildStarFocused(true);
					return starSystems.get(i);
				}
			}
		}
		return null;
	}

	public boolean isChildStarFocused() {
		return isChildStarFocused;
	}

	public void setChildStarFocused(boolean isChildStarFocused) {
		this.isChildStarFocused = isChildStarFocused;
	}
}
