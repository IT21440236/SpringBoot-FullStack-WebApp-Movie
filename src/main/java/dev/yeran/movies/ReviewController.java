package dev.yeran.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){// What
        // we are saying here is, whatever we get as the @RequestBody, we are going to convert it to
        // a map of key: String and value: String , and we want to name this map as payload

        return new ResponseEntity<>(reviewService.createReview(payload.get("reviewBody"),
                payload.get("imdbId")), HttpStatus.CREATED);

    }
}


//NOTES:

/*
Map<String, String> declares a map variable named payload that can store key-value pairs.
<String, String> specifies the types of keys and values that the map can hold. In this case, both the keys and values are of type String.
By using a Map, you can store and access data using a key-value relationship. The key is used to uniquely identify each value in the map. In the provided code snippet, the payload map can store multiple key-value pairs, where both the keys and values are of type String.
 */