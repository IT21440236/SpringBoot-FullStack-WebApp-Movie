package dev.yeran.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collation = "movies") //This will let the compiler know that this class
// represents each document in the movies collection
public class Movie {
    private ObjectId id;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    List<String> genres;
    List<String> backdrops;
    List<String> reviewIds;
}



//Notes

/*
ObjectId refers to a class in MongoDB's Java driver.
It represents a unique identifier for documents in a MongoDB collection.
The private ObjectId id line declares a private instance variable named id of type ObjectId. This variable can be used to store and manipulate MongoDB document identifiers within the corresponding Java class.
 */