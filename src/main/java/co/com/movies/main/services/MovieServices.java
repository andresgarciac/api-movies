package co.com.movies.main.services;

import co.com.movies.main.cassandra.repositories.MoviesByIdRepository;
import co.com.movies.main.cassandra.tables.Movie;
import co.com.movies.main.infrastructure.dtos.MovieDTO;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
public class MovieServices {

    public Optional<MovieDTO> getMovie(String id, MoviesByIdRepository repository) {
        Optional<Movie> movie = repository.findById(id);

        return movie.map(m -> MovieDTO.builder()
                        .movieId(m.getMovieId())
                        .genre(m.getGenre())
                        .build());
    }

}
