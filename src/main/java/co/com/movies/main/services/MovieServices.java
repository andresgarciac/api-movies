package co.com.movies.main.services;

import co.com.movies.main.cassandra.repositories.MoviesByIdRepository;
import co.com.movies.main.cassandra.tables.Movie;
import co.com.movies.main.infrastructure.dtos.MovieDTO;
import co.com.movies.main.infrastructure.errors.ServiceError;
import co.com.movies.main.infrastructure.transformers.Transformers;
import io.vavr.control.Either;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static co.com.movies.main.infrastructure.errors.ServicesErrorDefinition.invalidRequest;

@NoArgsConstructor
public class MovieServices {

    private MoviesByIdRepository repository;

    public MovieServices(MoviesByIdRepository repository) {
        this.repository = repository;
    }

    public Optional<MovieDTO> getMovie(String id) {
        Optional<Movie> movie = repository.findById(id);

        return movie.map(Transformers::toMovieDTO);
    }

    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = repository.findAll();

        return movies.stream().map(Transformers::toMovieDTO).collect(Collectors.toList());
    }

    public Either<ServiceError, MovieDTO> createMovie(MovieDTO movie) {

        if(movie == null) {
            return Either.left(invalidRequest);
        }
        return Either.right(Transformers.toMovieDTO(repository.save(Transformers.toMovieEntity(movie))));
    }

}
