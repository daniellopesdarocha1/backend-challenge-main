package com.tokenvalidator.app.services;

import com.tokenvalidator.app.dtos.ClaimDto;

public interface TokenService {

	public String deserializaTokenJwt(String token);
	public ClaimDto converteTokenJwtParaObjeto(String payload);
	public String validaQuantidadeAtributos(String payload);
}
