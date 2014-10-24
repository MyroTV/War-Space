package com.me.utils;

import java.util.Random;

public class RandomInt {
	//This method generates a random integer within a given maximum range
	public static int newRandom(int maxRange) {
		Random rand = new Random();
		int value = rand.nextInt(maxRange) + 1;
		return value;
	}
	
	public static int newRandomWithinRange(int min, int max) {
		Random rand = new Random();
		int value = rand.nextInt(max - min) + min;
		return value;
	}
}
