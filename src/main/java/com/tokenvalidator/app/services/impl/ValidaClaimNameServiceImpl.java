package com.tokenvalidator.app.services.impl;

import org.springframework.stereotype.Service;

import com.tokenvalidator.app.services.ValidaClaimNameService;

@Service
public class ValidaClaimNameServiceImpl implements ValidaClaimNameService {

	@Override
	public boolean validaCaracters(String name) {
		
		boolean apenasCaracter = name.matches("[A-Z][a-z]{1,}");
		System.out.println("apenasCaracter: " + apenasCaracter);
		return apenasCaracter;
		
	}

	@Override
	public boolean validaTamanho(String name) {
		
        int tamanhoName = name.length();
        
        System.out.println("tamanhoName: " + tamanhoName);
        
		if (tamanhoName >= 256)
        	return false;
        
        
		return true;
	}

}
