package com.me.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureLoader {
	
	private static Texture metallicPlanet; //planet textures
	
	private static Texture yellowStar; //star textures
	
	private static Texture spiralGalaxy; //galaxy textures
	
	private static Texture fleetIndicator; //GUI textures
	private static Texture tooltip;
	private static Texture exitButton;
	private static Texture buildingButton;
	
	private static Texture mainMenuScreen; //Main menu screen textures
	private static Texture startButton;
	
	public void loadTextures() {
		setMetallicPlanet(new Texture(Gdx.files.internal("assets/metallic.png")));
		setYellowStar(new Texture(Gdx.files.internal("assets/yellowStar.png")));
		setSpiralGalaxy(new Texture(Gdx.files.internal("assets/spiral.png")));
		setFleetIndicator(new Texture(Gdx.files.internal("assets/fleetIndicator.png")));
		setTooltip(new Texture(Gdx.files.internal("assets/ninePatchTooltip.png")));
		setExitButton(new Texture("assets/exitButton.png"));
		setBuildingButton(new Texture("assets/buildingButton.png"));
		setMainMenuScreen(new Texture("assets/newBG.png"));
		setStartButton(new Texture("assets/startButton.png"));
	}
	public static Texture getMetallicPlanet() {
		return metallicPlanet;
	}
	public static void setMetallicPlanet(Texture metallicPlanet) {
		TextureLoader.metallicPlanet = metallicPlanet;
	}
	public static Texture getYellowStar() {
		return yellowStar;
	}
	public static void setYellowStar(Texture yellowStar) {
		TextureLoader.yellowStar = yellowStar;
	}
	public static Texture getSpiralGalaxy() {
		return spiralGalaxy;
	}
	public static void setSpiralGalaxy(Texture spiralGalaxy) {
		TextureLoader.spiralGalaxy = spiralGalaxy;
	}
	public static Texture getFleetIndicator() {
		return fleetIndicator;
	}
	public static void setFleetIndicator(Texture fleetIndicator) {
		TextureLoader.fleetIndicator = fleetIndicator;
	}
	public static Texture getTooltip() {
		return tooltip;
	}
	public static void setTooltip(Texture tooltip) {
		TextureLoader.tooltip = tooltip;
	}
	public static Texture getExitButton() {
		return exitButton;
	}
	public static void setExitButton(Texture exitButton) {
		TextureLoader.exitButton = exitButton;
	}
	public static Texture getBuildingButton() {
		return buildingButton;
	}
	public static void setBuildingButton(Texture buildingButton) {
		TextureLoader.buildingButton = buildingButton;
	}
	public static Texture getMainMenuScreen() {
		return mainMenuScreen;
	}
	public static void setMainMenuScreen(Texture mainMenuScreen) {
		TextureLoader.mainMenuScreen = mainMenuScreen;
	}
	public static Texture getStartButton() {
		return startButton;
	}
	public static void setStartButton(Texture startButton) {
		TextureLoader.startButton = startButton;
	}
}
