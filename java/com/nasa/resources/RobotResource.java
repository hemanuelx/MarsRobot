package com.nasa.resources;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nasa.controller.MarsRobotController;
import com.nasa.util.Movement;

@Path("/robot")
public class RobotResource {

	@GET	
	public String qualquerCoisa() {
		return "teste maunca";
	}

	@POST
	@Path("/{param}")
	public String insertMovement(@PathParam("param") String movement) {
		MarsRobotController marsRobotController = new MarsRobotController();
		if (!movement.contains(Movement.MOVE.getValue()) && !movement.contains(Movement.LEFT.getValue())
				&& !movement.contains(Movement.RIGHT.getValue())) {
			throw new BadRequestException();
		} else {
			for (char command : movement.toCharArray()) {
				if (command == Movement.MOVE.getValue().charAt(0)) {
					marsRobotController.move();
				} else if (command == Movement.LEFT.getValue().charAt(0)) {
					marsRobotController.turnLeft();
				} else if (command == Movement.RIGHT.getValue().charAt(0)) {
					marsRobotController.turnRight();
				} else {
					throw new BadRequestException();
				}
			}
			return marsRobotController.getPosition();
		}
	}

}
