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

		try {
			Gson gson = new Gson();
			claimDto = gson.fromJson(payload, ClaimDto.class);

			return claimDto;

		} catch (Exception e) {
			System.out.println("JWT inválido");
			return claimDto;
		}
	}

	@Override
	public String validaQuantidadeAtributos(String payload) {
		
		String json = deserializaTokenJwt(payload);
		
		int qtdAtt = 0;
								
		for (int i = 0; i < json.length(); i++) {
			char c = json.charAt(i);
			String caracter = "" + c;
			if(caracter.contains(":")) {
				qtdAtt++;
			}
		}

		if (qtdAtt != 3) {
			System.out.println("Json não contém 3 Atributos");
			return "NOK";
		}
		
		if (!json.contains("Name") || !json.contains("Role") || !json.contains("Seed")) {
			return "NOK";			
		}
		
		return "OK";
	}

}
