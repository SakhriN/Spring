package com.example.demo;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.SecretKey;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

//		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
//
//		String baseKey = Encoders.BASE64.encode(key.getEncoded());
//
//		System.out.println(baseKey);


	}

}