package dev.ray.movies.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ray.movies.entity.Movie;
import dev.ray.movies.service.MovieService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @GetMapping("/allMovies")
    public ResponseEntity<List<Movie>> getAllMovies() throws Exception {
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
    }
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable String imdbId) throws Exception {
        Optional<Movie> movie = movieService.getMovieByImdbId(imdbId);
        return new ResponseEntity<Optional<Movie>>(movie, HttpStatus.OK);
    }
    
    
}
