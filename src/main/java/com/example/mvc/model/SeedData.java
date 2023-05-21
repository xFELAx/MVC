package com.example.mvc.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.example.mvc.model.entity.Movie;
import com.example.mvc.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        // Look for any movies.
        if (movieRepository.count() > 0) {
            return;   // DB has been seeded
        }
        movieRepository.saveAll(
                List.of(
                        new Movie("When Harry Met Sally", LocalDate.parse("1989-2-12"), "Romantic Comedy", "R", BigDecimal.valueOf(7.99)),
                        new Movie("Ghostbusters", LocalDate.parse("1984-3-13"), "Comedy", "PG", BigDecimal.valueOf(8.99)),
                        new Movie("Ghostbusters 2", LocalDate.parse("1986-2-23"), "Comedy", "PG", BigDecimal.valueOf(9.99)),
                        new Movie("Rio Bravo", LocalDate.parse("1959-4-15"), "Western", "NR", BigDecimal.valueOf(3.99))
                )
        );
    }
}
