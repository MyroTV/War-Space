package com.me.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.me.game.structures.Capital;
import com.me.game.structures.Factory;
import com.me.screens.GameScreen;

public class PlayersHandler {
	private ArrayList<Player> playersList = new ArrayList<Player>();
	private int numberOfPlayers;
	private Player humanPlayer;
	
	public PlayersHandler(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	
	public void generatePlayers(int numberOfPlayers) {
		for(int i = 0; i < numberOfPlayers; i++) {
			playersList.add(new Player(new Race(), true, GameScreen.getRenderer().getUniverseRenderer().getUniverse().getRandomPlanet()));
			humanPlayer = playersList.get(i);
			humanPlayer.getCapitalPlanet().setPlanetOwner(humanPlayer);
			humanPlayer.getCapitalPlanet().addStructure(new Capital("Capital"));
			humanPlayer.getCapitalPlanet().addStructure(new Factory());
			humanPlayer.setColor(Color.GREEN);
			System.out.print("Player Capital" + "(" + humanPlayer.getCapitalPlanet().getPlanetName() + ") " + "generated in: " + humanPlayer.getCapitalPlanet().getParentStar().getSystemName() + ", " + humanPlayer.getCapitalPlanet().getParentStar().getParentGalaxy().getGalaxyName());
		}
	}
	
	public void show() {
		this.generatePlayers(this.numberOfPlayers);
	}
}
