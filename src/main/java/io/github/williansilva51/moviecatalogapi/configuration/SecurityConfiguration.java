package io.github.williansilva51.moviecatalogapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	/**
	 * Define um bean para a codificação de senhas.
	 * Utiliza um PasswordEncoder que delega para o algoritmo de codificação apropriado
	 * (o padrão é bcrypt).
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	/**
	 * Configura a cadeia de filtros de segurança do Spring.
	 * Define quais endpoints são públicos e quais exigem autenticação.
	 *
	 * @param http O objeto HttpSecurity para configurar a segurança ‘web’.
	 * @return A cadeia de filtros de segurança construída.
	 * @throws Exception se ocorrer um erro durante a configuração.
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth
						.requestMatchers("/").permitAll()
						.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll().anyRequest().authenticated()
				)
				.httpBasic(withDefaults());
		return http.build();
	}


}
