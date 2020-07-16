package co.com.movies.main.controllers;

import co.com.movies.main.infrastructure.dtos.MovieDTO;
import co.com.movies.main.infrastructure.errors.ServiceError;
import io.vavr.control.Either;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public interface IMoviesController {

    @GetMapping("/movie")
    public ResponseEntity<?> getMovie(@RequestParam(name = "id") String id);

    @GetMapping("/movies")
    public ResponseEntity<? extends List> getAllMovies();

    @PostMapping(value = "/movie", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createMovie(@RequestBody MovieDTO movie);

}
