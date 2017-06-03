package com.nasa.model;

import com.nasa.util.CardinalDirections;

public class MarsRobot {
	private int x;
	private int y;
	private CardinalDirections cardinalDirections;
	
	public MarsRobot (int x, int y,CardinalDirections cardinalDirections) {
		this.x = x;
		this.y = y;
		this.cardinalDirections = cardinalDirections;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getX() {
		return this.x;
	}	
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public CardinalDirections getCardinalDirections() {
		return cardinalDirections;
	}

	public void setCardinalDirections(CardinalDirections cardinalDirections) {
		this.cardinalDirections = cardinalDirections;
	}	
}
