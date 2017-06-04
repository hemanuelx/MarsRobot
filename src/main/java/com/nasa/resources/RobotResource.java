package com.nasa.resources;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.nasa.controller.MarsRobotController;
import com.nasa.util.Movement;

@Path("/mars")
public class RobotResource {
	@POST
	@Path("/{param}")
	public Response insertMovement(@PathParam("param") String movement) throws BadRequestException {
		MarsRobotController marsRobotController = new MarsRobotController();
		//Check if it's a valid command
		if (!movement.contains(Movement.MOVE.getValue()) && !movement.contains(Movement.LEFT.getValue())
				&& !movement.contains(Movement.RIGHT.getValue())) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			try {
				//check each command and send it to the robot
				for (char command : movement.toCharArray()) {
					if (command == Movement.MOVE.getValue().charAt(0)) {
						marsRobotController.move();
					} else if (command == Movement.LEFT.getValue().charAt(0)) {
						marsRobotController.turnLeft();
					} else if (command == Movement.RIGHT.getValue().charAt(0)) {
						marsRobotController.turnRight();
					} else {
						return Response.status(Response.Status.BAD_REQUEST).build();
					}
				}
			} catch (BadRequestException e) {
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
			//return the last position of the robot
			return Response.status(Response.Status.OK).entity(marsRobotController.getPosition()).build();
		}
	}

}
