package com.alura.forum.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.alura.forum.model.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${forum.jwt.expiration}") // Injetar parametros do application properties
	private String expiration;
	@Value("${forum.jwt.secret}") // Injetar parametros do application properties
	private String secret;

	public String gerarToken(Authentication authentication) {
		Usuario logado = (Usuario) authentication.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration)); // somando os milisegundos do
																					// expiration
		System.out.println(secret);
		return Jwts.builder().setIssuer("Api do Forum da Alura") // Quem fez a geração desse Token
				.setSubject(logado.getId().toString())// Dono deste token
				.setIssuedAt(hoje)// Usa a api de datas antiga do java
				.setExpiration(dataExpiracao)// Tempo de expiração
				.signWith(SignatureAlgorithm.HS256, secret) // Algoritmo hs256 de criptografia + o secret que é a senha
															// da sua aplicação
				.compact();// compactar em uma string
	}

	public boolean isTokenValid(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
