package co.com.movies.main.infrastructure.errors;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ServiceError {

    private int statusCode;
    private String errorCode;
    private String message;
}
