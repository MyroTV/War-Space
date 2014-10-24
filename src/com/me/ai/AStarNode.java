package com.me.ai;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.screens.GameScreen;

public class AStarNode {
	float costFromStart; //exact cost to reach this node from the starting node
	float heuristic; //estimated cost to reach the destination from here
	float totalCost; //exactCost + heuristic
	float nodeWeight = 0; //the weight cost of travelling through this node
	
	private boolean isStartNode; //is this node the starting node
	private boolean isEndNode; //is this node the end node
	private int x,y;
	
	private SpriteBatch batch;
	private Texture gridSquareTexture;
	private Sprite gridSquareSprite;
	private AStarGrid ASGrid;
	private BitmapFont label;
	
	public AStarNode(int x, int y, float nodeWeight, AStarGrid ASGrid) {
		this.setX(x);
		this.setY(y);
		this.nodeWeight = nodeWeight;
		this.ASGrid = ASGrid;
	}
	
	public AStarNode(int x, int y, AStarGrid ASGrid) {
		this.setX(x);
		this.setY(y);
		this.ASGrid = ASGrid;

	}
	
	public AStarNode(int x, int y, boolean isStartNode, boolean isEndNode, AStarGrid ASGrid) {
		this.setX(x);
		this.setY(y);
		this.isStartNode = isStartNode;
		this.isEndNode = isEndNode;
		this.ASGrid = ASGrid;
	}
	
	public void calculateHeuristic() {
		if(ASGrid.getStartNode() != null && ASGrid.getEndNode() != null) {
			float startX = this.getX();
			float startY = this.getY();
			float endX = ASGrid.getEndNode().getX();
			float endY = ASGrid.getEndNode().getY();
			this.heuristic = (float) Math.sqrt(Math.pow((startX - endX), 2) + Math.pow((startY - endY), 2));
		}
	}
	
	public void calculateTotalCost(int costFromStart) {
		this.totalCost = this.heuristic + costFromStart;
	}
	
	public void show() {
		label = new BitmapFont();
		batch = new SpriteBatch();
		gridSquareTexture = new Texture(Gdx.files.internal("assets/70x70square_top_right.png"));
		gridSquareSprite = new Sprite(gridSquareTexture);
	}
	
	public void setSprite(Sprite sprite) {
		this.gridSquareSprite = sprite;
	}
	
	public Sprite getSprite() {
		return this.gridSquareSprite;
	}
	
	public void setIsStartNode(boolean isStartNode) {
		this.isStartNode = isStartNode;
	}
	
	public void setIsEndNode(boolean isEndNode) {
		this.isEndNode = isEndNode;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}
	
	public void render() {
		this.calculateHeuristic();
		if(this.isStartNode == true) {
			gridSquareSprite.setColor(Color.GREEN);
		}
		
		if(this.isEndNode == true) {
			gridSquareSprite.setColor(Color.RED);
		}
		batch.begin();
			this.gridSquareSprite.draw(batch);
			label.draw(batch,"h: " + this.heuristic, gridSquareSprite.getX() + 1, gridSquareSprite.getY() + 15);
			//label.draw(batch, "tc: " + totalCost + " h: " + this.heuristic, gridSquareSprite.getX() + 2, gridSquareSprite.getY() + 15);
		batch.end();

	}
	
}
