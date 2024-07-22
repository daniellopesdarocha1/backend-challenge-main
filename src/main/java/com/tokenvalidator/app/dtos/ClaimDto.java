package com.tokenvalidator.app.dtos;

public class ClaimDto {

	private String Role;
	private String Seed;
	private String Name;
	
	public ClaimDto() {
		
	}

	public ClaimDto(String role, String seed, String name) {
		super();
		Role = role;
		Seed = seed;
		Name = name;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSeed() {
		return Seed;
	}

	public void setSeed(String seed) {
		Seed = seed;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

}
