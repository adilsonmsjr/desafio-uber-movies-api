package desafio.uber.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.uber.model.MovieLocation;
import desafio.uber.service.MovieLocationService;
import jakarta.annotation.Resource;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/movies")

public class MovieLocationController {

    private final MovieLocationService movieLocationService;

    public MovieLocationController(MovieLocationService movieLocationService) {
        this.movieLocationService = movieLocationService;
    }

    @GetMapping()
    public List<MovieLocation> getAll(@RequestParam Optional<String> param) {
        return param.map(movieLocationService::filterByTitle)
        .orElseGet(movieLocationService::getAllMovies);
    }
    

}
