package co.com.movies.main.controllers;

import co.com.movies.main.infrastructure.dtos.MovieDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public interface IMoviesController {

    @GetMapping("/movie")
    public ResponseEntity<MovieDTO> getMovie(@RequestParam(name = "id") String id);

    @PostMapping(value = "/movie")
    public ResponseEntity<MovieDTO> createMovie();

}
