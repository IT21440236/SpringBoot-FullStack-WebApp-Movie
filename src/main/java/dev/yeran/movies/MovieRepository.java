package dev.yeran.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    /*I do not want to expose the Id's of my collection entities, to the public
    Instead i want to use the imdb to search for movies.

    Although the repository comes with built-in methods for searching with id, it doesnt come with
    methods for searching by imdb ID.

    So we have to implement that method ourselves

    It REALLY EASY. There is something called automatic queries that lets u form queries dynamically
    from property names

    Let implement it
    **/
    Optional<Movie> findMovieByImdbId(String imdbId);
    //Now the magical thing is, Just by naming this method findMovieByImdbId, spring data mongodb
    // will understand what we are trying to do 🤩
    //Its that much intelligent

}


//Notes


/*
In Spring MVC, making the repository class an interface is a common practice because it allows for easier implementation of various persistence technologies and provides a clear separation of concerns.

Here are some reasons why repository classes are typically defined as interfaces in Spring MVC:

Abstraction and Loose Coupling: Defining the repository as an interface promotes abstraction and loose coupling between the application and the underlying persistence technology. The interface serves as a contract that defines the operations or methods available for data access, while the actual implementation can vary based on the chosen persistence technology (e.g., relational database, NoSQL database, etc.).

Testability: Interface-based repositories are easier to test because you can create mock or stub implementations of the repository interface for testing purposes. This allows you to isolate the repository logic and write unit tests without relying on an actual database or persistence technology.

Dependency Injection: Spring MVC heavily relies on dependency injection for managing dependencies. By defining the repository as an interface, you can easily inject the repository implementation into other components or services using annotations like @Autowired. This promotes the principle of "programming to interfaces" and enables loose coupling between different layers of your application.

Support for Multiple Implementations: Using interfaces allows you to have multiple implementations of the repository interface. This can be useful in scenarios where you need to switch between different persistence technologies or have different implementations for different environments (e.g., production, testing, in-memory database, etc.). Spring MVC provides mechanisms to configure which implementation to use based on configuration or annotations.

Overall, using an interface for the repository class in Spring MVC offers flexibility, testability, and modularity in your application's data access layer. It promotes best practices in software design and helps decouple your application from specific persistence technologies.

 */