package com.example.mvc.controller;

import java.util.List;

import com.example.mvc.MovieRepository;
import com.example.mvc.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/")
    public ModelAndView index(@RequestParam(required = false) String movieGenre, @RequestParam(required = false) String searchString) {
        List<String> genres = movieRepository.findDistinctGenres();
        List<Movie> movies;
        if (searchString != null && !searchString.isEmpty()) {
            movies = movieRepository.findByTitleContaining(searchString);
        } else if (movieGenre != null && !movieGenre.isEmpty()) {
            movies = movieRepository.findByGenre(movieGenre);
        } else {
            movies = movieRepository.findAll();
        }
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("genres", genres);
        modelAndView.addObject("movies", movies);
        return modelAndView;
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable int id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie == null) {
            return new ModelAndView("404");
        }
        return new ModelAndView("details", "movie", movie);
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("create");
    }

    @PostMapping("/create")
    public ModelAndView create(Movie movie) {
        movieRepository.save(movie);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie == null) {
            return new ModelAndView("404");
        }
        return new ModelAndView("edit", "movie", movie);
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id, Movie movie) {
        if (movie.getId() != id) {
            return new ModelAndView("404");
        }
        movieRepository.save(movie);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie == null) {
            return new ModelAndView("404");
        }
        return new ModelAndView("delete", "movie", movie);
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteConfirmed(@PathVariable int id) {
        movieRepository.deleteById(id);
        return new ModelAndView("redirect:/");
    }
}