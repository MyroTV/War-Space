package com.me.game;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.me.game.entities.GalaxyEntity;
import com.me.screens.GameScreen;
import com.me.utils.RandomInt;

public class Galaxy {
	//have a different save file for each galaxy? or galaxy cluster?
	private GalaxyEntity galaxyEntity;

	private ArrayList<StarSystem> starSystems = new ArrayList<StarSystem>();
	private boolean focus = false;
	private boolean graphicsInitialised = false;
	private boolean isChildStarFocused = false;
	private boolean childrenSystemsGenerated = false;
	private Universe parentUniverse;
	private String galaxyName;
	private int numberOfSystems;
	private GalaxyType galaxyType;
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
	
	public Galaxy(String galaxyName, int numberOfSystems, GalaxyType galaxyType) {
		this.galaxyName = galaxyName;
		this.numberOfSystems = numberOfSystems;
		this.galaxyType = galaxyType;
	}
	
	public void generateStarSystems() {
		for(int i = 0; i < this.numberOfSystems; i++) {
			starSystems.add(new StarSystem("System " + i, RandomInt.newRandom(10), new StarType("yellowStar")));
			starSystems.get(i).initialiseGraphics();
			starSystems.get(i).setParentGalaxy(this);
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
		GameScreen.getCamera().translate(GameScreen.getScreenX() * -1 + posX, GameScreen.getScreenY() * -1 + (posY / 2));
	}
	
	public void render() {
		
		if(this.getFocus() == true) {
			for(int i = 0; i < starSystems.size(); i++) {
				starSystems.get(i).render();
			}
		}
		
		else if(getActiveStarSystem() != null) {
			getActiveStarSystem().render();
		}
		
		else {
			galaxyEntity.render();
		}
	}
	
	public void show() {
		initialiseGraphics();
		setGraphicsInitialised(true);
	}
	
	public void update() {
		galaxyEntity.update();
		checkClick();
		if(this.getFocus() == true && this.childrenSystemsGenerated == true) {
			for(int i = 0; i < starSystems.size(); i++) {
				starSystems.get(i).update();
			}
		}
		else if(getActiveStarSystem() != null) {
			getActiveStarSystem().update();
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

	public GalaxyEntity getGalaxyEntity() {
		return galaxyEntity;
	}

	public void setGalaxyEntity(GalaxyEntity galaxyEntity) {
		this.galaxyEntity = galaxyEntity;
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
		galaxyEntity.dispose();
		galaxyEntity = null;
		System.out.print(galaxyName + "graphics destroyed \n");
		setGraphicsInitialised(false);
	}
	
	public void initialiseGraphics() {
		galaxyEntity = new GalaxyEntity(TextureLoader.getSpiralGalaxy(), this.galaxyName, this.posX, this.posY);
		setGraphicsInitialised(true);
		System.out.print(galaxyName + " graphics initialised. \n");
	}
	
	public void checkClick() {
		if(galaxyEntity.isClicked() == true) {
			if(this.childrenSystemsGenerated == false) {
				this.generateTest();
			}
			Universe.setFocus(false);
			for(int i = 0; i < starSystems.size(); i++) {
				if(starSystems.get(i).isGraphicsInitialised() == false) {
					starSystems.get(i).initialiseGraphics();
				}
			}
			this.setFocus(true);
		}
	}
}
