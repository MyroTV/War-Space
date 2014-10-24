package com.me.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class StarType {
	
	private String starType;
	private Texture starTexture;
	
	public StarType(String starType) {
		this.starType = starType;
		this.setTexture();
	}
	
	public void setTexture() {
		//String filePath = "assets/" + starType + ".png";
		//if(Gdx.files.internal(filePath) != null) {
		//	starTexture = new Texture(Gdx.files.internal(filePath));
		//}
		starTexture = TextureLoader.getYellowStar();
	}
	
	public Texture getStarTexture() {
		return this.starTexture;
	}
}
