package com.tokenvalidator.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody ;
import org.springframework.web.bind.annotation.RestController;

import com.tokenvalidator.app.dtos.ClaimDto;
import com.tokenvalidator.app.model.Token;
import com.tokenvalidator.app.services.impl.TokenServiceImpl;
import com.tokenvalidator.app.services.impl.ValidaClaimNameServiceImpl;
import com.tokenvalidator.app.services.impl.ValidaClaimRoleServiceImpl;
import com.tokenvalidator.app.services.impl.ValidaClaimSeedServiceImpl;

@RestController
public class TokenController {

	@Autowired
	TokenServiceImpl tokenService;
	@Autowired
	ValidaClaimNameServiceImpl validaClaimNameService;
	@Autowired
	ValidaClaimSeedServiceImpl validaSeedService;
	@Autowired
	ValidaClaimRoleServiceImpl validaClaimRoleService;
	
	@PostMapping(value="/validate")
	public boolean validate( @RequestBody Token token) {

		
		ClaimDto claimDto = new ClaimDto();
		
		claimDto = tokenService.converteTokenJwtParaObjeto(tokenService.deserializaTokenJwt(token.getValue()));

		System.out.println("Role: " + claimDto.getRole());
		System.out.println("Seed: " + claimDto.getSeed());
		System.out.println("Name: " + claimDto.getName());

		String validaQuantidadeAtributosStatus = "";
		String validaTamanhoNameStatus = "";
		String validaApenasLetrasStatus = "";
		String validaNumeroPrimoStatus = "";
		String validaRoleStatus = "";

		if (claimDto.getName() != null) {

			validaQuantidadeAtributosStatus = tokenService.validaQuantidadeAtributos(token.getValue());
			validaTamanhoNameStatus = validaClaimNameService.validaTamanho(claimDto.getName());
			validaApenasLetrasStatus = validaClaimNameService.possuiApenasLetras(claimDto.getName());
			validaNumeroPrimoStatus = validaSeedService.validaNumeroPrimo(claimDto.getSeed());
			validaRoleStatus = validaClaimRoleService.validaRole(claimDto.getRole());
			
		} else {
			System.out.println("false");
			return false;
		}
				
		if (validaQuantidadeAtributosStatus == "NOK"
			|| validaTamanhoNameStatus == "NOK"
			|| validaApenasLetrasStatus == "NOK"
			|| validaNumeroPrimoStatus == "NOK"
			|| validaRoleStatus == "NOK") 
		{
			System.out.println("false");
			return false;
			
		} else {
			System.out.println("true");
			return true;
		}

	}
}




