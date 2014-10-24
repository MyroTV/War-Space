package com.me.gui;

import java.util.ArrayList;

import com.me.interfaces.GUIElement;

public class ScrollPane implements GUIElement {
	private ArrayList<ScrollPaneElement> scrollPaneElements = new ArrayList<ScrollPaneElement>();
	private ArrayList<ScrollPaneElement> displayedScrollPaneElements = new ArrayList<ScrollPaneElement>();
	private Button upButton, downButton;
	
	
	public ScrollPane(int maxNumOfElements, int sizeX, int sizeY) {
		
	}
}
