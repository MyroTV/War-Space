package com.me.gui;

import java.util.ArrayList;

import com.me.interfaces.GUIElement;

public class ScrollPane implements GUIElement {
	private ArrayList<ScrollPaneElement> scrollPaneElements = new ArrayList<ScrollPaneElement>();
	private ArrayList<ScrollPaneElement> displayedPanes = new ArrayList<ScrollPaneElement>();
	private Button upButton, downButton;
	private int maxElements; //maxElements is max elements to display at any one time note: can be higher than scrollPaneElements.size()
	private int sizeX, sizeY, x, y;
	private PlanetScreen parentScreen;
	
	
	public ScrollPane(int maxElements, int sizeX, int sizeY, PlanetScreen parentScreen) {
		this.maxElements = maxElements;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.parentScreen = parentScreen;
	}
	
	public void show() {
		generatePanes();
		initialisePanes();
		updateDisplayedPanes(0);
	}
	
	public void update() {
		
	}
	
	public void render() { //only render 'displayed panes'
		if(scrollPaneElements != null) {
			if(scrollPaneElements.size() > 0 && scrollPaneElements.size() < maxElements) {
				for(int i = 0; i < maxElements; i++) {
					displayedPanes.get(i).render();
				}
			}
			else if(scrollPaneElements.size() > maxElements){
				for(int i = 0; i < maxElements; i++) {
					displayedPanes.get(i).render();
				}
			}
		}
	}
	
	public void generatePanes() {
		if(parentScreen.getPlanet().getStructureList() != null) {
			if(parentScreen.getPlanet().getStructureList().size() != 0) {
				for(int i = 0; i < parentScreen.getPlanet().getStructureList().size(); i++) {
					scrollPaneElements.add(new ScrollPaneElement(0, 280 - 28, 166, 28, this, parentScreen.getPlanet().getStructureList().get(i)));
					System.out.print("generated " + parentScreen.getPlanet().getStructureList().get(i).getName());
				}
			}
		}
	}
	
	public void initialisePanes() {
		if(scrollPaneElements != null && scrollPaneElements.size() > 0) {
			for(int i = 0; i < scrollPaneElements.size(); i++) {
				 scrollPaneElements.get(i).show();
			}
		}
	}
	
	public void updatePanes() {
		if(scrollPaneElements != null) {
			if(scrollPaneElements.size() > 0) {
				scrollPaneElements.removeAll(scrollPaneElements);
				
				if(parentScreen.getPlanet().getStructureList() != null && parentScreen.getPlanet().getStructureList().size() != 0) {
					for(int i = 0; i < parentScreen.getPlanet().getStructureList().size(); i++) {
						scrollPaneElements.add(new ScrollPaneElement(0, 280 - 28, 166, 28, this, parentScreen.getPlanet().getStructureList().get(i)));
					}
				}
			}
		}
	}
	
	public void updateNumOfElements(int numberOfElements) {
		this.maxElements = numberOfElements;
	}
	
	public void removeScrollPaneElement(ScrollPaneElement scrollPaneElement) {
		scrollPaneElements.remove(scrollPaneElement);
	}
	
	public void updateDisplayedPanes(int startingElement) { //starts from 0
		if(scrollPaneElements.size() < maxElements) {
			maxElements = scrollPaneElements.size();
		}
		if(displayedPanes != null) {
			if(displayedPanes.size() > 0) {
				displayedPanes.removeAll(displayedPanes);
				for(int i = startingElement; i < maxElements; i++) {
					displayedPanes.add(scrollPaneElements.get(i));
				}
			}
			else {
				for(int i = startingElement; i < maxElements; i++) {
					displayedPanes.add(scrollPaneElements.get(i));
				}
			}
		}
	}
	
	public void setLocation(int x, int y) {
		
	}
}
