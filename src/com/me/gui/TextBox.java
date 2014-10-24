package com.me.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.me.interfaces.GUIElement;
import com.me.utils.KeyListener;

public class TextBox implements GUIElement {

		private Sprite textBoxSprite;
		private Texture textBoxTexture;
		private boolean limitedInput = false;
		private int maxColumns, tick, x, y, height, width; //or number of columns
		private boolean inFocus = false;
		private ShapeRenderer sr;
		private BitmapFont text;
		private KeyListener keyListener;
		private String inputString = "";
		private SpriteBatch batch;
		
	public TextBox(int maxColumns, int posX, int posY, int height) {
		this.maxColumns = maxColumns;
		this.limitedInput = false;
	}
	
	public TextBox(boolean limitedInput) {
		this.limitedInput = limitedInput;
	}
	
	public void resetText() {

	}
	
	public boolean isFocused() {
		return this.inFocus;
	}
	
	public boolean isMouseOver() {
		if(textBoxSprite.getBoundingRectangle().contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	public void focus() {
		this.isMouseOver();
		if(this.isMouseOver() == true) {
			if(Gdx.input.isButtonPressed(Buttons.LEFT)) {
				this.inFocus = true;
			}
		}
		if(this.isMouseOver() == false) {
			if(Gdx.input.isButtonPressed(Buttons.LEFT)) {
				this.inFocus = false;
			}
		}
	}
	
	public void render() {
		tick++;
		if(tick < 30 && this.inFocus == true) {
			sr.begin(ShapeType.Line);
			sr.line(510, 535, 510, 505);
			sr.end();
		}
		else {
			sr.dispose();
		}
		if(tick >= 60) {
			tick = 0;
		}
		batch.begin();
			if(inputString.length() > 0) {
				text.draw(batch, inputString, 505, 515, inputString.length() - 1 - text.computeVisibleGlyphs(inputString, 0, inputString.length() - 1, 180), inputString.length());
			}
			else {
				text.draw(batch, inputString, 505, 515, inputString.length() - text.computeVisibleGlyphs(inputString, 0, inputString.length() - 1, 180), inputString.length());
			}
		batch.end();
	}
	
	public void drawSprite(SpriteBatch batch) {
		textBoxSprite.draw(batch);
	}
	
	public void update() {
		this.focus();
		this.clear();
		keyListener.checkKeyPressed();
	}
	
	public void clear() {
		this.isMouseOver();
		if(this.isMouseOver() == true) {
			if(Gdx.input.isButtonPressed(Buttons.RIGHT)) {
				inputString = "";
				System.out.print("got here");
			}
		}
	}
	
	public void show() {
		keyListener = new KeyListener(this);
		text = new BitmapFont();
		text.setColor(Color.BLACK);
		batch = new SpriteBatch();

		textBoxTexture = new Texture(Gdx.files.internal("assets/textBox.png"));
		textBoxSprite = new Sprite(textBoxTexture);
		textBoxSprite.setSize(200, 40);
		textBoxSprite.setPosition(500, 500);
		textBoxSprite.getBoundingRectangle().setY(520.0f);
		sr = new ShapeRenderer();
		sr.setColor(Color.BLACK);
	}
}
