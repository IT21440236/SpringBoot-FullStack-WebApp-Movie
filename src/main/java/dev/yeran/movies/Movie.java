package dev.yeran.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies") //This will let the compiler know that this class
// represents each document in the movies collection
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id //This will let the framework know that this property should be treated as the unique identifier \
    // for each movie inside the DB
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    List<String> genres;
    List<String> backdrops;
    @DocumentReference //This will cause the DB to store only the Id of the review
    // and the reviews will be in a separate collection.
    List<Review> reviewIds;
}



//Notes

/*
ObjectId refers to a class in MongoDB's Java driver.
It represents a unique identifier for documents in a MongoDB collection.
The private ObjectId id line declares a private instance variable named id of type ObjectId. This variable can be used to store and manipulate MongoDB document identifiers within the corresponding Java class.

 =====================================================
 In Spring Boot, the @Document annotation is used to mark a class as representing a MongoDB document. It is typically used in conjunction with other Spring Data MongoDB annotations, such as @Id, @Field, and @Indexed, to define the mapping between Java objects and MongoDB documents.

By applying the @Document annotation to a class, you are indicating that instances of this class should be stored as documents in a MongoDB collection. The annotation allows you to specify additional attributes such as the collection name and language override.

Here's an example usage of @Document:
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    // Class definition
}

In the example above, the User class is annotated with @Document, specifying that instances of this class should be stored in the "users" collection in MongoDB.

By using @Document, you can leverage Spring Data MongoDB's repository and query features to perform CRUD operations and interact with MongoDB using a more object-oriented approach.

============================

In Spring Data MongoDB, the @DocumentReference annotation is used to establish a reference between documents in different collections or even different databases. It is used to define a relationship between entities in a non-embedded manner.

By applying the @DocumentReference annotation to a field, you indicate that the field represents a reference to another document. This allows you to establish relationships and navigate between documents.

Here's an example usage of @DocumentReference
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "orders")
public class Order {
    // other fields

    @DocumentReference
    private Customer customer;

    // getters and setters
}

In the example above, the Order class has a customer field annotated with @DocumentReference. This field represents a reference to a Customer document.

By using @DocumentReference, you can fetch related documents lazily or eagerly and navigate between different documents using Spring Data MongoDB's repository and query features. It provides a convenient way to establish relationships and maintain data integrity in your MongoDB data model.

Q)what happens if we just write private Customer customer; without the @DocumentReference in the above you gave

If you just write `private Customer customer;` without the `@DocumentReference` annotation, it will be treated as a regular embedded document within the `Order` document. This means that the `Customer` object will be stored as a nested document within the `Order` document in the MongoDB collection.

In this case, when you save an `Order` object, the associated `Customer` object will be stored along with it as a nested document. The two documents will be tightly coupled, and changes to the `Customer` object will not be reflected as separate documents in a different collection.

By using `@DocumentReference`, you indicate that the `Customer` field should be treated as a reference to a separate `Customer` document, rather than an embedded document. This allows for more flexible and efficient querying, indexing, and management of related documents. It enables you to establish relationships between entities without embedding the entire document and allows you to navigate between documents using references.

So, if you want the `Customer` object to be stored as a separate document and establish a reference to it from the `Order` document, you should use the `@DocumentReference` annotation.




 */