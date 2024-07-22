package com.tokenvalidator.app.services.impl;

import org.springframework.stereotype.Service;

import com.tokenvalidator.app.services.ValidaClaimNameService;

@Service
public class ValidaClaimNameServiceImpl implements ValidaClaimNameService {

	@Override
	public String possuiApenasLetras(String name) {

		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if(Character.isDigit(c)) {
				System.out.println("encontrado número entre letras: " + c);
				return "NOK";
			}
		}
		
		System.out.println("Name não contém números");
		return "OK";
		
	}

	@Override
	public String validaTamanho(String name) {
		
        int tamanhoName = name.length();
        
        System.out.println("tamanhoName: " + tamanhoName);
        
		if (tamanhoName >= 256)
        	return "NOK";
        
        
		return "OK";
	}

}
