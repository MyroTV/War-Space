package com.me.game;

import com.badlogic.gdx.graphics.Texture;

public class GalaxyType {

	private Texture galaxyTexture;
	private String galaxytype;
	
	public GalaxyType(String galaxyType) {
		this.galaxytype = galaxyType;
		this.setTexture();
	}
	
	public void setTexture() {
		//String filePath = "assets/" + galaxytype + ".png";
		//if(Gdx.files.internal(filePath) != null) {
			//galaxyTexture = new Texture(Gdx.files.internal(filePath));
		//}
		galaxyTexture = TextureLoader.getSpiralGalaxy();
	}
	
	public Texture getGalaxyTexture() {
		return this.galaxyTexture;
	}
}
