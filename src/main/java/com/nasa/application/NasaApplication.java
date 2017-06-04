package com.nasa.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.nasa.resources.RobotResource;

@ApplicationPath("/webapi")
public class NasaApplication extends Application {	
	@Override
	public Set<Class<?>> getClasses() {	    
	    final Set<Class<?>> classes = new HashSet<Class<?>>();
	    // register root resource
	    classes.add(RobotResource.class);
	    return classes;
	}
}
