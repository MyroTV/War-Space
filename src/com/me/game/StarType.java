package com.me.game;

import com.badlogic.gdx.graphics.Texture;

public class StarType {
	
	private String starType;
	
	public StarType(String starType) {
		this.starType = starType;
	}
	
	public Texture getStarTexture(String starSystemType) {
		if(starSystemType == "yellowStar") {
			return TextureLoader.getYellowStar();
		}
		else {
			return TextureLoader.getYellowStar();
		}
	}
}
