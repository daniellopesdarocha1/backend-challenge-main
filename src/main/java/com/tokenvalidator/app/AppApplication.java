package com.tokenvalidator.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tokenvalidator.app.dtos.ClaimDto;
import com.tokenvalidator.app.services.TokenService;
import com.tokenvalidator.app.services.ValidaClaimNameService;
import com.tokenvalidator.app.services.ValidaSeedService;
import com.tokenvalidator.app.services.impl.TokenServiceImpl;
import com.tokenvalidator.app.services.impl.ValidaClaimNameServiceImpl;
import com.tokenvalidator.app.services.impl.ValidaSeedServiceImpl;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	public static void main(String[] args)  {
		SpringApplication.run(AppApplication.class, args);
	}

	public void run(String... args) throws Exception {
		
		TokenService tokenService = new TokenServiceImpl();
		ClaimDto claimDto = new ClaimDto();
		ValidaClaimNameService validaClaimNameService = new ValidaClaimNameServiceImpl();
		ValidaSeedService validaSeedService = new ValidaSeedServiceImpl();
		
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJTZWVkIjoiNzg0MSIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05sIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg";
		
		claimDto = tokenService.converteTokenJwtParaObjeto(tokenService.deserializaTokenJwt(token));
		System.out.println("Role: " + claimDto.getRole());
		System.out.println("Seed: " + claimDto.getSeed());
		System.out.println("Name: " + claimDto.getName());
		
		
		validaClaimNameService.validaTamanho(claimDto.getName());
		validaClaimNameService.validaCaracters(claimDto.getName());
		
		validaSeedService.validaNumeroPrimo(claimDto.getSeed());
		
	}
	
}
