package com.nasa.test;

import javax.ws.rs.BadRequestException;

import org.junit.Assert;
import org.junit.Test;

import com.nasa.resources.RobotResource;

public class TestMarsRobot {

	@Test
	public void testEndSouth() {
		RobotResource robotResource = new RobotResource();
		String expected = "(2,0,S) \n";
		String actual = robotResource.insertMovement("MMRMMRMM");
		Assert.assertEquals(expected, actual);		
	}
	
	@Test
	public void testEndWest() {
		RobotResource robotResource = new RobotResource();
		String expected = "(0,2,W) \n";
		String actual = robotResource.insertMovement("MML");
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testEndWestRepetition() {
		RobotResource robotResource = new RobotResource();
		String expected = "(0,2,W) \n";
		String actual = robotResource.insertMovement("MML");				
		expected = "(0,2,W) \n";
		actual = robotResource.insertMovement("MML");
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected=BadRequestException.class)
	public void testInvalidCommand() {
		RobotResource robotResource = new RobotResource();		
		String actual = robotResource.insertMovement("AAA");		
	}
	
	@Test(expected=BadRequestException.class)
	public void testInvalidPosition() {
		RobotResource robotResource = new RobotResource();		
		String actual = robotResource.insertMovement("MMMMMMMMMMMMMMMMMMMMMMMM");		
	}

}
