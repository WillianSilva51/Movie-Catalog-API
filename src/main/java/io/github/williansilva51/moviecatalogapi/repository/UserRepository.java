package io.github.williansilva51.moviecatalogapi.repository;

import io.github.williansilva51.moviecatalogapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
