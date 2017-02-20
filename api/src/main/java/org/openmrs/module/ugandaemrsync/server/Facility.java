package org.openmrs.module.ugandaemrsync.server;

/**
 * Created by carapai on 02/02/2017.
 */
public class Facility {
	
	private String name;
	
	public Facility() {
	}
	
	public Facility(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
