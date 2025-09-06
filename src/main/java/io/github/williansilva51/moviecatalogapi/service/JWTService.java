package io.github.williansilva51.moviecatalogapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JWTService {
	@Value("${jwt.secret}")
	private String SECRET_KEY;

	public String generateToken(UserDetails userDetails) {
		return null;
	}

	public boolean isTokenValid(String token, UserDetails userDetails) {
		return true;
	}

	public String extractUsername(String token) {
		return null;
	}
}
