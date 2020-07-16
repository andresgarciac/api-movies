package co.com.movies.main.controllers.impl;

import co.com.movies.main.cassandra.repositories.MoviesByIdRepository;
import co.com.movies.main.controllers.IMoviesController;
import co.com.movies.main.infrastructure.dtos.MovieDTO;
import co.com.movies.main.infrastructure.errors.ServiceError;
import co.com.movies.main.services.MovieServices;
import io.vavr.control.Either;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class MoviesControllerV1 implements IMoviesController {

    private final MoviesByIdRepository repository;
    private final MovieServices movieServices;

    public MoviesControllerV1(MoviesByIdRepository repository) {
        this.repository = repository;
        this.movieServices = new MovieServices(this.repository);
    }

    @Override
    public ResponseEntity<MovieDTO> getMovie(String id) {
        Optional<MovieDTO> movie = movieServices.getMovie(id);

        return movie
                .map(m -> ResponseEntity.ok().body(m))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @Override
    public ResponseEntity<? extends List> getAllMovies() {
        return ResponseEntity.ok().body(movieServices.getAllMovies());
    }

    @Override
    public ResponseEntity<?> createMovie(MovieDTO movie) {
        Either<ServiceError, MovieDTO> resp = movieServices.createMovie(movie);

        if (resp.isLeft()) {
            return ResponseEntity.status(resp.getLeft().getStatusCode()).body(resp.getLeft());
        }
        return ResponseEntity.ok().body(resp.get());
    }
}
