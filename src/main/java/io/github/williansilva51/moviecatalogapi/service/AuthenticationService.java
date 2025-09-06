package io.github.williansilva51.moviecatalogapi.service;

import io.github.williansilva51.moviecatalogapi.dto.SignUpRequest;
import io.github.williansilva51.moviecatalogapi.model.User;
import io.github.williansilva51.moviecatalogapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
	public UserRepository userRepository;
	public PasswordEncoder passwordEncoder;

	public void signup(SignUpRequest signUpRequest) throws RuntimeException {
		if (!userRepository.existsByUsernameAndEmail(signUpRequest.username(), signUpRequest.email())) {
			User newUser = User.builder()
					.name(signUpRequest.name())
					.username(signUpRequest.username())
					.email(signUpRequest.email())
					.password(passwordEncoder.encode(signUpRequest.password()))
					.build();

			userRepository.save(newUser);
		}
		throw new RuntimeException("Username or email already exists");
	}
}
