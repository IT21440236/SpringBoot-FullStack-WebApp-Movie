package dev.yeran.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @GetMapping
    ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }
    @GetMapping("/{imdbId}")
    ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<>(movieService.singleMovie(imdbId), HttpStatus.OK);

    }
}


//NOTES:


/*

ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

OR

ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(movieService.allMovies(), HttpStatus.OK);
    }

which one is correct ?

Both of the provided code snippets are correct and will produce the same result.

In the first snippet: The generic type List<Movie> is explicitly specified in the ResponseEntity constructor.

In the second snippet: The diamond operator <> is used, which allows type inference to determine the generic type based on the provided argument (movieService.allMovies() in this case). This is a shorthand notation introduced in Java 7 that simplifies the syntax when the type can be inferred.

Both snippets will create a ResponseEntity object with the specified list of movies and the HTTP status code HttpStatus.OK. They are equivalent and will have the same effect. It's a matter of personal preference which syntax you choose to use.

* */