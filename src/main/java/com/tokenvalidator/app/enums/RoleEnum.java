package com.tokenvalidator.app.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {

	ADMIN("Admin"),
	MEMBER("Member"),
	EXTERNAL("External");
	
	private String role;
	
	RoleEnum(String role) {
		this.role = role;
	}
	
}
