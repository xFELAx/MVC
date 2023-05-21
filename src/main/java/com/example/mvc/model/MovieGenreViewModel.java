package com.example.mvc.model;

import com.example.mvc.model.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieGenreViewModel {
    private List<Movie> movies;
    private List<String> genres;
    private String movieGenre;
    private String searchString;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}
