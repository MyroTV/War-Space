package com.me.game;

import java.util.ArrayList;

public class StarSystemShell {
	private String systemName;
	private ArrayList<PlanetShell> planets = new ArrayList<PlanetShell>();
	
	public StarSystemShell(String systemName) {
		this.systemName = systemName;
	}
	
	public void dispose() {
		
	}

	public ArrayList<PlanetShell> getPlanets() {
		return planets;
	}

	public void setPlanets(ArrayList<PlanetShell> planets) {
		this.planets = planets;
	}
}
