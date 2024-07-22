package com.tokenvalidator.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tokenvalidator.app.dtos.ClaimDto;
import com.tokenvalidator.app.services.TokenService;
import com.tokenvalidator.app.services.impl.TokenServiceImpl;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	public static void main(String[] args)  {
		SpringApplication.run(AppApplication.class, args);
	}

	public void run(String... args) throws Exception {
		
		TokenService tokenService = new TokenServiceImpl();
		ClaimDto claimDto = new ClaimDto();
		
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJTZWVkIjoiNzg0MSIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05sIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg";
		
		claimDto = tokenService.converteTokenJwtParaObjeto(tokenService.deserializaTokenJwt(token));
		
		System.out.println(claimDto.getRole());
		System.out.println(claimDto.getSeed());
		System.out.println(claimDto.getName());
		
	}
	
}
