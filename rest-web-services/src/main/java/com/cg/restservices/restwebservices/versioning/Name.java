package com.cg.restservices.restwebservices.versioning;

public class Name {

	private String firstName;
	private String lsatName;
	public Name(String firstName, String lsatName) {
		super();
		this.firstName = firstName;
		this.lsatName = lsatName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLsatName() {
		return lsatName;
	}
	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", lsatName=" + lsatName + "]";
	}
	
	
}
