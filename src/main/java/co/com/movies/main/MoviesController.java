package co.com.movies.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class MoviesController {

    @GetMapping("/water")
    public String getWaterDebt(@RequestParam(name = "id") String clientId) {
        return clientId;
    }

}
