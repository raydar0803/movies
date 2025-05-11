package dev.ray.movies.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ray.movies.repository.MovieRepository;
import dev.ray.movies.entity.Movie;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(MovieService.class);

  public List<Movie> getAllMovies() {
    return movieRepository.findAll();
  }
    public Optional<Movie> getMovieByImdbId(String imdbId) {
    logger.info("Fetching movie with imdbId: {}", imdbId);
        return Optional.ofNullable(movieRepository.findByImdbId(imdbId)
        .orElseThrow(() -> new RuntimeException("Movie not found with imdbId: " + imdbId)));
             
}
}