package co.com.movies.main.infrastructure.dtos;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class MovieDTO {

    private String movieId;
    private String genre;
    private String name;
    private String synopsis;
    private Date creationDate;
    private String director;
}
