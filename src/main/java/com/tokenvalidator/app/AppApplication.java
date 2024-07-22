package com.tokenvalidator.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tokenvalidator.app.dtos.ClaimDto;
import com.tokenvalidator.app.services.TokenService;
import com.tokenvalidator.app.services.ValidaClaimNameService;
import com.tokenvalidator.app.services.ValidaClaimRoleService;
import com.tokenvalidator.app.services.ValidaClaimSeedService;
import com.tokenvalidator.app.services.impl.TokenServiceImpl;
import com.tokenvalidator.app.services.impl.ValidaClaimNameServiceImpl;
import com.tokenvalidator.app.services.impl.ValidaClaimRoleServiceImpl;
import com.tokenvalidator.app.services.impl.ValidaClaimSeedServiceImpl;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	public void run(String... args) throws Exception {

		TokenService tokenService = new TokenServiceImpl();
		ClaimDto claimDto = new ClaimDto();
		ValidaClaimNameService validaClaimNameService = new ValidaClaimNameServiceImpl();
		ValidaClaimSeedService validaSeedService = new ValidaClaimSeedServiceImpl();
		ValidaClaimRoleService validaClaimRoleService = new ValidaClaimRoleServiceImpl();

		// true
		// String token =
		// "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJTZWVkIjoiNzg0MSIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05sIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg";

//		// caso 1 - ok
//		String token = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJTZWVkIjoiNzg0MSIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05sIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg";

		// caso 2 - Erro
		String token = "eyJhbGciOiJzI1NiJ9.dfsdfsfryJSr2xrIjoiQWRtaW4iLCJTZrkIjoiNzg0MSIsIk5hbrUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05fsdfsIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg";

//		// caso 3 - ok
//		String token = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiRXh0ZXJuYWwiLCJTZWVkIjoiODgwMzciLCJOYW1lIjoiTTRyaWEgT2xpdmlhIn0.6YD73XWZYQSSMDf6H0i3-kylz1-TY_Yt6h1cV2Ku-Qs";

//		// caso 4 - ok
//		String token = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiTWVtYmVyIiwiT3JnIjoiQlIiLCJTZWVkIjoiMTQ2MjciLCJOYW1lIjoiVmFsZGlyIEFyYW5oYSJ9.cmrXV_Flm5mfdpfNUVopY_I2zeJUy4EZ4i3Fea98zvY";

		claimDto = tokenService.converteTokenJwtParaObjeto(tokenService.deserializaTokenJwt(token));

		System.out.println("Role: " + claimDto.getRole());
		System.out.println("Seed: " + claimDto.getSeed());
		System.out.println("Name: " + claimDto.getName());

		if (claimDto.getName() != null) {

			validaClaimNameService.validaTamanho(claimDto.getName());
			validaClaimNameService.validaCaracters(claimDto.getName());
			validaSeedService.validaNumeroPrimo(claimDto.getSeed());
			validaClaimRoleService.validaRole(claimDto.getRole());
			
		}

	}

}
