package co.com.movies.main.infrastructure.errors;

public class ServicesErrorDefinition {

    public static final ServiceError invalidRequest = ServiceError.builder().statusCode(400).errorCode("400").message("The request is invalid").build();

}
