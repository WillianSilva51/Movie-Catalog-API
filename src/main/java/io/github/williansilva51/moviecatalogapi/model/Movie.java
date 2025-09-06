package io.github.williansilva51.moviecatalogapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String title;

	@Column(nullable = false, length = 200)
	private String description;

	@Column(nullable = false)
	private Double score;

	@Column(nullable = false, length = 100)
	private String genre;

	@Column(nullable = false, length = 100)
	private String year;

}
