package com.nasa.util;

public enum CardinalDirections {
	NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");
	
	private final String value;
	
	CardinalDirections (String value) {
		this.value = value;		
	}
	
	public String getValue() {
		return this.value;
	}
}
