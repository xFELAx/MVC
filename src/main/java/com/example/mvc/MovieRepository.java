package com.example.mvc;

import java.util.List;
import java.util.Optional;

import com.example.mvc.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<String> findDistinctGenres();

    List<Movie> findByTitleContaining(String searchString);

    List<Movie> findByGenre(String genre);

    Optional<Movie> findById(int id);
}
