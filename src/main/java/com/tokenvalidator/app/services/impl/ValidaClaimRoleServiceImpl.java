package com.tokenvalidator.app.services.impl;

import com.tokenvalidator.app.enums.RoleEnum;
import com.tokenvalidator.app.services.ValidaClaimRoleService;

public class ValidaClaimRoleServiceImpl implements ValidaClaimRoleService {

	@Override
	public boolean validaRole(String role) {

		RoleEnum roleEnum = RoleEnum.valueOf(role);
		System.out.println("roleEnum: " + roleEnum);
		
		switch (roleEnum) {
		case Admin:
			return true;

		case Member:
			return true;

		case External:
			return true;
		}

		return false;
	}

}
