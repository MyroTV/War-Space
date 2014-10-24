package com.me.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureLoader {
	
	private static Texture metallicPlanet; //planet textures
	
	private static Texture yellowStar; //star textures
	
	private static Texture spiralGalaxy; //galaxy textures
	
	public void loadTextures() {
		setMetallicPlanet(new Texture(Gdx.files.internal("assets/metallic.png")));
		setYellowStar(new Texture(Gdx.files.internal("assets/yellowStar.png")));
		setSpiralGalaxy(new Texture(Gdx.files.internal("assets/spiral.png")));
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
	
	
}
