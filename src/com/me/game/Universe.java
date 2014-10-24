package com.me.game;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.me.utils.RandomInt;

public class Universe {
	String pn[] = null;
	private static ArrayList<String> planetNames = new ArrayList<String>();
	private ArrayList<Galaxy> galaxies = new ArrayList<Galaxy>();
	private int numberOfGalaxies;
	private static boolean inFocus = true;
	private static boolean isChildGalaxyFocused = false;
	
	public Universe(int numberOfGalaxies) {
		this.numberOfGalaxies = numberOfGalaxies;
	}

	public void generateGalaxies() {
		for(int i = 0; i < this.numberOfGalaxies; i++) {
			galaxies.add(new Galaxy("Galaxy " + i, 1, new GalaxyType("spiral")));
			galaxies.get(i).show();
			galaxies.get(i).setParentUniverse(this);
			galaxies.get(i).getGalaxySprite().setPosition(i * 100, i * 100);
		}
	}
	
	public void readPlanetNamesFromFile() {
		try {
			FileInputStream fStream = new FileInputStream("assets/planetNames");
			BufferedReader br = new BufferedReader(new InputStreamReader(fStream));
			try {
				while(br.ready()) {
					pn = br.readLine().split(",");
				}
				br.close();
				fStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if(pn != null) {
			for(int i = 0; i < pn.length; i++) {
				planetNames.add(pn[i]);
			}
		}
	}
	
	public ArrayList<String> generatePlanetNames(int numberOfNames) {
		ArrayList<String> tmp = new ArrayList<String>();
		for(int i = 0; i < numberOfNames; i++) {
			tmp.add(planetNames.get(RandomInt.newRandom(planetNames.size() - 1)));
		}
		return tmp;
	}
	
	public static void removePlanetNameFromArray(String planetName) {
		planetNames.remove(planetName);
		planetNames.trimToSize();
	}
	
	public static String getRandomPlanetName() {
		return planetNames.get(RandomInt.newRandom(planetNames.size() - 1));
	}
	
	public Planet getRandomPlanet() {
		Planet tmpPlanet = null;
		int tmp = 0;
		while (tmpPlanet == null) {
			Galaxy tmpGalaxy = this.galaxies.get(RandomInt.newRandom(galaxies.size() - 1));
			StarSystem tmpSystem = tmpGalaxy.getStarSystems().get(RandomInt.newRandom(tmpGalaxy.getStarSystems().size() - 1));
			if(tmpSystem.getPlanets() != null) {
				while(tmp < 0) {
					tmp = RandomInt.newRandom(tmpSystem.getPlanets().size() - 1);
				}
				tmpPlanet = tmpSystem.getPlanets().get(tmp);
			}
		}
		return tmpPlanet;
	}
	
	public void render() {
		if(inFocus == true) {
			for(int i = 0; i < galaxies.size(); i++) {
				galaxies.get(i).render();
			}
		}
		else if(getActiveGalaxy() != null) {
			getActiveGalaxy().render();
		}
	}
	
	public void show() {
		this.readPlanetNamesFromFile();
		this.generateGalaxies();
	}
	
	public void update() {
		if(inFocus == true) {
			for(int i = 0; i < galaxies.size(); i++) {
				galaxies.get(i).update();
			}
		}
		else if(getActiveGalaxy() != null) {
			getActiveGalaxy().update();
		}
	}
	
	public boolean getFocus() {
		return inFocus;
	}
	
	public static void setFocus(boolean focus) {
		inFocus = focus;
	}
	
	public Galaxy getActiveGalaxy() {
		if(galaxies != null) {
			for(int i = 0; i < galaxies.size(); i++) {
				if(galaxies.get(i).getFocus() == true || galaxies.get(i).isChildStarFocused() == true) {
					isChildGalaxyFocused = true;
					return galaxies.get(i);
				}
			}
		}
		return null;
	}

}
