package co.com.movies.main.infrastructure.transformers;

import co.com.movies.main.cassandra.tables.Movie;
import co.com.movies.main.infrastructure.dtos.MovieDTO;

import java.util.UUID;

public class Transformers {

    public static MovieDTO toMovieDTO(Movie movie) {
        return MovieDTO.builder()
                .movieId(movie.getMovieId())
                .genre(movie.getGenre())
                .synopsis(movie.getSynopsis())
                .creationDate(movie.getCreationDate())
                .director(movie.getDirector())
                .name(movie.getName())
                .build();
    }

    public static Movie toMovieEntity(MovieDTO movie) {
        return Movie.builder()
                .movieId(UUID.randomUUID().toString())
                .genre(movie.getGenre())
                .synopsis(movie.getSynopsis())
                .creationDate(movie.getCreationDate())
                .director(movie.getDirector())
                .name(movie.getName())
                .build();
    }

}
