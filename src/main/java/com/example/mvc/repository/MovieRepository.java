package com.example.mvc.repository;

import java.util.List;
import java.util.Optional;

import com.example.mvc.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<String> findDistinctGenres();

    List<Movie> findByTitleContaining(String searchString);

    List<Movie> findByGenre(String genre);

    Optional<Movie> findById(int id);
}
