package dev.yeran.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {


    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview(String reviewBody, String imdbId){
//        Review review = new Review(reviewBody);
        Review review = reviewRepository.insert(new Review(reviewBody));

        //Now we have to associate the review with a movie.
        //For that we first need a template ; private MongoTemplate mongoTemplate;
        //U have learned one way to talk to the DB is using the repository
        //The other way is using the template
        //Sometimes some functions might be too complex/ or high-level to implement in a repository
        //So what we need for that is a template.

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;

    }
}


//NOTES


/*
In a Spring Data MongoDB application, the MongoTemplate class is a high-level MongoDB operations helper. It provides various methods for interacting with the MongoDB database, such as querying, updating, inserting, and deleting documents.

When you declare a private field of type MongoTemplate in a class, You are essentially creating an instance variable that can be used within the class to access MongoDB operations. This field can be auto-wired or manually instantiated using the appropriate configuration.

By having a MongoTemplate instance in your class, you can perform more advanced and custom operations on MongoDB compared to what is provided by the higher-level Spring Data MongoDB repositories. It gives you more control and flexibility over the interactions with the database.

You can use the mongoTemplate field to execute queries, perform updates, access collections, work with indexes, and leverage various MongoDB features directly through the MongoTemplate API.
============================================================

Explain me this code snippet ;
public Review createReview(String reviewBody, String imdbId){

        Review review = reviewRepository.insert(new Review(reviewBody));


        mongoTemplate.update(Movie.class)
                .matching(Criteria.where(imdbId).is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;

    }

The given code snippet is a method createReview that creates a new review for a movie specified by its IMDb ID. Let's break down the code:

Review review = reviewRepository.insert(new Review(reviewBody));

This line creates a new Review object using the reviewBody parameter.
The reviewRepository is assumed to be an instance of a repository class that provides CRUD operations for the Review entity.
The insert method is called to persist the newly created review in the database, and the returned Review object is assigned to the review variable.
mongoTemplate.update(Movie.class)

This line starts a MongoDB update operation on the Movie class, assuming that Movie is a MongoDB document/entity.
The mongoTemplate is an instance of the MongoTemplate class, which provides a set of methods for performing advanced database operations.
.matching(Criteria.where(imdbId).is(imdbId))

This line specifies the criteria for the update operation.
The Criteria.where(imdbId).is(imdbId) construct creates a criterion to match the imdbId field of the Movie object with the provided IMDb ID value.
.apply(new Update().push("reviewIds").value(review))

This line defines the update action to be performed.
It uses the push method to add the review object to the reviewIds field of the matched Movie object.
The push operation appends the review object to the existing list of reviews in the reviewIds field.
.first();

This line specifies that only the first matched document should be updated.
If multiple documents match the criteria, only the first one encountered will be updated.
return review;

Finally, the created Review object is returned from the method.
Overall, this code snippet creates a new review, persists it in the database, and updates the corresponding Movie object by adding the review to its list of reviews.


* */