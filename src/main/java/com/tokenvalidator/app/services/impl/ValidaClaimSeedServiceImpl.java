package com.tokenvalidator.app.services.impl;

import com.tokenvalidator.app.services.ValidaClaimSeedService;

public class ValidaClaimSeedServiceImpl implements ValidaClaimSeedService {

	@Override
	public String validaNumeroPrimo(String seed) {
        
        int numPrimo;
        int numDivisores = 0;
        int i;
        
        numPrimo = Integer.parseInt(seed);
        
        for (i = 1; i <= numPrimo; i++){
            
            if (numPrimo % i == 0){
                numDivisores++;
            }
            
        }
        
        if (numDivisores == 2){
            System.out.println("é um número primo!");
    		return "OK";
        }
            
        System.out.println("Não é num número primo!");
		return "NOK";
	}

	
	
}
