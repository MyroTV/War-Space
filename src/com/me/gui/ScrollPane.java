package com.me.gui;

import java.util.ArrayList;

import com.me.interfaces.GUIElement;

public class ScrollPane implements GUIElement {
	private ArrayList<ScrollPaneElement> scrollPaneElements = new ArrayList<ScrollPaneElement>();
	private ArrayList<ScrollPaneElement> displayedScrollPaneElements = new ArrayList<ScrollPaneElement>();
	private Button upButton, downButton;
	private int numOfElements;
	private int sizeX, sizeY, x, y;
	private PlanetScreen parentScreen;
	
	
	public ScrollPane(int numOfElements, int sizeX, int sizeY, PlanetScreen parentScreen) {
		this.numOfElements = numOfElements;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.parentScreen = parentScreen;
	}
	
	public void show() {
		
	}
	
	public void update() {
		
	}
	
	public void render() {
		
	}
	
	public void generatePanes() {
		if(parentScreen.getPlanet().getStructureList() != null && parentScreen.getPlanet().getStructureList().size() != 0) {
			for(int i = 0; i < parentScreen.getPlanet().getStructureList().size(); i++) {
				scrollPaneElements.add(new ScrollPaneElement(0, 280 - 28, 166, 28, this));
			}
		}
	}
	
	public void updateNumOfElements(int numberOfElements) {
		this.numOfElements = numberOfElements;
	}
	
	public void removeScrollPaneElement(ScrollPaneElement scrollPaneElement) {
		scrollPaneElements.remove(scrollPaneElement);
	}
	
	public void updateDisplayedPanes(int factor) {
		
	}
	
	public void setLocation(int x, int y) {
		
	}
}
