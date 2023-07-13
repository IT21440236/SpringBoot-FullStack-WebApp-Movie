package dev.yeran.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Inside this class we will write the DB access methods
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

//    public Movie singleMovie(ObjectId id){
//        return movieRepository.findById(id);
    /*This method will give u an error
    That is because sometimes there might not be a movie with the given id, it may return null
    So we have to let the compiler know that it might return null by saying Optional<Movie>
    * */
//    }

    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }


}
