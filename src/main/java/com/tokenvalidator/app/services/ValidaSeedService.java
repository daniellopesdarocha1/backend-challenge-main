package com.tokenvalidator.app.services;

public interface ValidaSeedService {

	// A claim Seed deve ser um número primo.
	
	public boolean validarNumeroPrimo(String seed);
	
	
}
