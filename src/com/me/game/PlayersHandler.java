package com.me.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
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
			playersList.add(new Player(new Race(), true, GameScreen.getUniverseRenderer().getUniverse().getRandomPlanet()));
			humanPlayer = playersList.get(i);
			humanPlayer.getCapitalPlanet().setPlanetOwner(humanPlayer);
			humanPlayer.setColor(Color.GREEN);
		}
	}
	
	public void show() {
		this.generatePlayers(this.numberOfPlayers);
	}
}
