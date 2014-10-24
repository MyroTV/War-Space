package com.me.ai;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.screens.GameScreen;

public class AStarGrid {
	private int maxX, maxY, sizeX, sizeY;
	private ArrayList<AStarNode> allNodes = new ArrayList<AStarNode>();
	private ArrayList<AStarNode> currentPath = new ArrayList<AStarNode>();
	private SpriteBatch batch;
	private AStarNode startNode, endNode = null;
	
	public AStarGrid(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	public void emptyCurrentPath() {
		this.currentPath.removeAll(currentPath);
	}
	
	public void emptyallNodes() {
		this.allNodes.removeAll(allNodes);
	}
	
	public void createNodes() {
		AStarNode tmpNode;
	}
	
	public void show() {
		batch = new SpriteBatch();
		sizeX = sizeY = 5;
		int tmpCount = 0;
		for(int i = 0; i < sizeX; i++) {
			for(int j = 0; j < sizeY; j++) {
				allNodes.add(new AStarNode(i, j, 10, this));
				allNodes.get(tmpCount).show();
				allNodes.get(tmpCount).getSprite().setPosition(i * 70 + 800, j * 70 + 500);
				allNodes.get(tmpCount).setBatch(batch);
				tmpCount++;
				if(tmpCount == 5) {
					allNodes.get(tmpCount - 1).setIsStartNode(true);
					this.setStartNode(allNodes.get(tmpCount - 1));
				}
				
				if(tmpCount == 22) {
					allNodes.get(tmpCount - 1).setIsEndNode(true);
					this.setEndNode(allNodes.get(tmpCount - 1));
				}
			}
		}
	}
	//System.out.print();
	public void render() {
		for(int i = 0; i < allNodes.size(); i++) {
				allNodes.get(i).render();
			}
	}
	
	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}
	
	public AStarNode getEndNode() {
		return endNode;
	}

	public void setEndNode(AStarNode endNode) {
		this.endNode = endNode;
	}

	public AStarNode getStartNode() {
		return startNode;
	}

	public void setStartNode(AStarNode startNode) {
		this.startNode = startNode;
	}

	public void determinePath(AStarNode startNode, AStarNode endNode) {
		
	}
	
}
