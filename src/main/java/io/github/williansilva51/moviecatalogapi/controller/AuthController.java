package io.github.williansilva51.moviecatalogapi.controller;

import io.github.williansilva51.moviecatalogapi.dto.AuthenticationResponse;
import io.github.williansilva51.moviecatalogapi.dto.LoginRequest;
import io.github.williansilva51.moviecatalogapi.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
class AuthController {

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody SignUpRequest signUpRequest) {
		return null;
	}

	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {
		return null;
	}

}
