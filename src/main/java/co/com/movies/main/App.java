package co.com.movies.main;

import com.fasterxml.jackson.databind.Module;
import io.vavr.jackson.datatype.VavrModule;
import javaslang.jackson.datatype.JavaslangModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public Module jacksonBuilder() {
        return new JavaslangModule();
    }
/*
    @Bean
    public Module vavrModule() {
        return new VavrModule();
    }*/
}