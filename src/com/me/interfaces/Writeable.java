package com.me.interfaces;

import com.badlogic.gdx.utils.Json;

public interface Writeable {
	
	public void writeData();
	public void readData();
	public Json getJson();
}
