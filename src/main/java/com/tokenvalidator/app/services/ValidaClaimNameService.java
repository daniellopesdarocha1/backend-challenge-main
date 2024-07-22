package com.tokenvalidator.app.services;

public interface ValidaClaimNameService {

	// A claim Name não pode ter carácter de números
	// O tamanho máximo da claim Name é de 256 caracteres.
	
	public boolean validarCaracters(String name);
	public boolean validarTamanho(String name);
}
