package com.me.game;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.screens.GameScreen;
import com.me.utils.RandomInt;

public class Galaxy {

	private ArrayList<StarSystem> starSystems = new ArrayList<StarSystem>();
	private boolean focus = false;
	private boolean graphicsInitialised = false;
	private boolean isChildStarFocused = false;
	private boolean childrenSystemsGenerated = false;
	private Universe parentUniverse;
	private String galaxyName;
	private int numberOfSystems;
	private Sprite galaxySprite;
	private SpriteBatch batch;
	private GalaxyType galaxyType;
	private BitmapFont galaxyLabel;
	private int posX, posY;
	
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
				starSystems.get(j).setParentGalaxy(this);
				starSystems.get(j).setPosX(x * 100);
				starSystems.get(j).setPosY(y * 100);
				starSystems.get(j).show();
				//System.out.print("Star System " + j + " generated in " + galaxyName + "\n");
				starSystems.get(j).generatePlanets();
				j++;
			}
			x++;
			if(x == 23) {
				x = 0;
				y++;
			}
			this.setChildSystemsGenerated(true);
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
		
		if(this.parentUniverse.getFocus() == true && isGraphicsInitialised() == true) {
			this.galaxySprite.draw(this.batch);
			galaxyLabel.draw(batch, galaxyName, galaxySprite.getX(), galaxySprite.getY());
		}
		
		this.batch.end();
	}
	
	public void show() {
		initialiseGraphics();
		setGraphicsInitialised(true);
	}
	
	public void update() {
		if(this.getFocus() == true && this.childrenSystemsGenerated == true) {
			for(int i = 0; i < starSystems.size(); i++) {
				starSystems.get(i).update();
			}
		}
		else if(getActiveStarSystem() != null) {
			getActiveStarSystem().update();
		}
		if(parentUniverse.getFocus() == true && isGraphicsInitialised() == true) {
			this.realX = this.galaxySprite.getX();
			this.realY = this.galaxySprite.getY() * 2;
			if(this.galaxySprite.getBoundingRectangle().contains(Gdx.input.getX() - (Gdx.graphics.getWidth() / 2) - (GameScreen.getScreenX() * -1), Gdx.input.getY() - ((Gdx.graphics.getHeight() / 2) - galaxySprite.getWidth()) - GameScreen.getScreenY() + realY)) {
				this.galaxySprite.setColor(1, 1, 1, 0.5f);
				if(Gdx.input.justTouched()) {
					System.out.print(this.galaxyName + " clicked\n");
					if(this.childrenSystemsGenerated == false) {
						this.generateTest();
					}
					Universe.setFocus(false);
					for(int i = 0; i < starSystems.size(); i++) {
						starSystems.get(i).initialiseGraphics();
					}
					this.focus = true;
				}
			}
			else {
				galaxySprite.setColor(1.0f, 1.0f, 1.0f, 1.0f);
			}
		}
	}
	
	public boolean getFocus() {
		return this.focus;
	}
	
	public String getGalaxyName() {
		return this.galaxyName;
	}
	
	public void setFocus(boolean focus) {
		this.focus = focus;
	}
	
	public void setParentUniverse(Universe universe) {
		this.parentUniverse = universe;
	}
	
	public Sprite getGalaxySprite() {
		return this.galaxySprite;
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
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
	
	public void setChildSystemsGenerated(boolean areChildSystemsGenerated) {
		this.childrenSystemsGenerated = areChildSystemsGenerated;
	}
	
	public boolean isGraphicsInitialised() {
		return graphicsInitialised;
	}

	public void setGraphicsInitialised(boolean graphicsInitialised) {
		this.graphicsInitialised = graphicsInitialised;
	}

	public void dispose() {
		System.out.print(galaxyName + "graphics destroyed \n");
		batch.dispose();
		galaxySprite.setTexture(null);
		galaxySprite = null;
		galaxyLabel.dispose();
		setGraphicsInitialised(false);
	}
	
	public void initialiseGraphics() {
		System.out.print(galaxyName + " graphics initialised. \n");
		batch = new SpriteBatch();
		galaxySprite = new Sprite(TextureLoader.getSpiralGalaxy());
		galaxySprite.setPosition(posX, posY);
		galaxyLabel = new BitmapFont();
		setGraphicsInitialised(true);
	}
}
