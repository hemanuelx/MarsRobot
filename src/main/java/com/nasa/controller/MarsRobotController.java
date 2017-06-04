package com.nasa.controller;

import javax.ws.rs.BadRequestException;

import com.nasa.model.MarsRobot;
import com.nasa.util.CardinalDirections;
import com.nasa.util.Land;

public class MarsRobotController {
	MarsRobot marsRobot;
	Land land;
	
	public MarsRobotController () {
		this.land = new Land();
		this.marsRobot = new MarsRobot(0, 0, CardinalDirections.NORTH);		
	}	
	
	public void move() throws BadRequestException {
		//If aiming to North or SOUTH it will move through y
		if	(marsRobot.getCardinalDirections().getValue().equals(CardinalDirections.NORTH.getValue())) {
			moveY(1);							
		} else if (marsRobot.getCardinalDirections() == CardinalDirections.SOUTH) {
			moveY(-1);
		//If aiming to EAST or WEST it will move through x
		} else if (marsRobot.getCardinalDirections() == CardinalDirections.EAST) {
			moveX(1);
		} else if (marsRobot.getCardinalDirections() == CardinalDirections.WEST) {
			moveX(-1);
		}
	}
	
	public String getPosition() {		
		return "("+marsRobot.getX()+","+marsRobot.getY()+","+marsRobot.getCardinalDirections().getValue()  +") \n";
	}
	
	public void turnLeft() {
		if (marsRobot.getCardinalDirections().equals(CardinalDirections.NORTH)) {
			marsRobot.setCardinalDirections(CardinalDirections.WEST);
		} else if (marsRobot.getCardinalDirections().equals(CardinalDirections.WEST)) {
			marsRobot.setCardinalDirections(CardinalDirections.SOUTH);
		} else if (marsRobot.getCardinalDirections().equals(CardinalDirections.SOUTH)) {
			marsRobot.setCardinalDirections(CardinalDirections.EAST);
		} else if (marsRobot.getCardinalDirections().equals(CardinalDirections.EAST)) {
			marsRobot.setCardinalDirections(CardinalDirections.NORTH);
		}
	}
	
	public void turnRight() {
		if (marsRobot.getCardinalDirections().equals(CardinalDirections.NORTH)) {
			marsRobot.setCardinalDirections(CardinalDirections.EAST);
		} else if (marsRobot.getCardinalDirections().equals(CardinalDirections.EAST)) {
			marsRobot.setCardinalDirections(CardinalDirections.SOUTH);
		} else if (marsRobot.getCardinalDirections().equals(CardinalDirections.SOUTH)) {
			marsRobot.setCardinalDirections(CardinalDirections.WEST);
		} else if (marsRobot.getCardinalDirections().equals(CardinalDirections.WEST)) {
			marsRobot.setCardinalDirections(CardinalDirections.NORTH);
		}
	}
	
	public void moveY(int y) throws BadRequestException {
		//if robot gonna get out of the land is a bad request 
		if	(y + marsRobot.getY() > land.getY() || y + marsRobot.getY() < 0 ){
			throw new BadRequestException();
		} else {
			marsRobot.setY(marsRobot.getY() + y);
		}
	}
	
	public void moveX(int x) throws BadRequestException {
		//if robot gonna get out of the land is a bad request
		if	(x + marsRobot.getX() > land.getX() || x + marsRobot.getX() < 0 ) {
			throw new BadRequestException();
		} else {
			marsRobot.setX(marsRobot.getX() + x);		
		}
	}
}
