package co.com.movies.main.controllers.impl;

import co.com.movies.main.cassandra.repositories.MoviesByIdRepository;
import co.com.movies.main.controllers.IMoviesController;
import co.com.movies.main.infrastructure.dtos.MovieDTO;
import co.com.movies.main.services.MovieServices;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class MoviesControllerV1 implements IMoviesController {

    private final MoviesByIdRepository repository;
    private final MovieServices movieServices;

    public MoviesControllerV1(MoviesByIdRepository repository) {
        this.repository = repository;
        this.movieServices = new MovieServices();
    }

    @Override
    public ResponseEntity<MovieDTO> getMovie(String id) {
        Optional<MovieDTO> movie = movieServices.getMovie(id, repository);

        return movie
                .map(m -> ResponseEntity.ok().body(m))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @Override
    public ResponseEntity<MovieDTO> createMovie() {
        return null;
    }
}
