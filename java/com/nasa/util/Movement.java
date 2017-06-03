package com.nasa.util;

public enum Movement {
	MOVE("M"), LEFT("L"), RIGHT("R");
	
	private final String value;
	Movement (String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
