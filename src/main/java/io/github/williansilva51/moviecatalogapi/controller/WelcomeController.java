package io.github.williansilva51.moviecatalogapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
class WelcomeController {

	@GetMapping
	public ResponseEntity<String> welcome() {
		return ResponseEntity.ok("HELLO WORLD");
	}
}
