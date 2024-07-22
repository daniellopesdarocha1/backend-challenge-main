package com.tokenvalidator.app.services.impl;

import org.springframework.stereotype.Service;

import com.tokenvalidator.app.enums.RoleEnum;
import com.tokenvalidator.app.services.ValidaClaimRoleService;

@Service
public class ValidaClaimRoleServiceImpl implements ValidaClaimRoleService {

	@Override
	public String validaRole(String role) {

		RoleEnum roleEnum = RoleEnum.valueOf(role);
		System.out.println("roleEnum: " + roleEnum);
		
		switch (roleEnum) {
		case Admin:
			return "OK";

		case Member:
			return "OK";

		case External:
			return "OK";
		}

		return "NOK";
	}

}
