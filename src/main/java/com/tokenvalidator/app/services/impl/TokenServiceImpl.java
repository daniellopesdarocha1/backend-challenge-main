package com.tokenvalidator.app.services.impl;

import java.util.Base64;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.tokenvalidator.app.dtos.ClaimDto;
import com.tokenvalidator.app.services.TokenService;

@Service
public class TokenServiceImpl implements TokenService {

	@Override
	public String deserializaTokenJwt(String token) {
		
		String[] chunks = token.split("\\.");
		Base64.Decoder decoder = Base64.getUrlDecoder();
		String payload = new String(decoder.decode(chunks[1]));
		
		return payload;
	}

	@Override
	public ClaimDto converteTokenJwtParaObjeto(String payload) {
		
		ClaimDto claimDto = new ClaimDto();
		
		Gson gson = new Gson();
		claimDto = gson.fromJson(payload, ClaimDto.class);
		
		return claimDto;
	}
	
	

}
