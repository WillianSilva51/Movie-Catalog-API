package io.github.williansilva51.moviecatalogapi.service;

import io.github.williansilva51.moviecatalogapi.dto.SignUpRequestDTO;
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

	public void signup(SignUpRequestDTO signUpRequestDTO) throws RuntimeException {
		if (!userRepository.existsByUsernameAndEmail(signUpRequestDTO.username(), signUpRequestDTO.email())) {
			User newUser = User.builder()
					.name(signUpRequestDTO.name())
					.username(signUpRequestDTO.username())
					.email(signUpRequestDTO.email())
					.password(passwordEncoder.encode(signUpRequestDTO.password()))
					.build();

			userRepository.save(newUser);
		}
		throw new RuntimeException("Username or email already exists");
	}
}
