package dev.yeran.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	@GetMapping("/")
	public String apiRoot(){
		return "Hello World";
	}

}




//Notes

/*
A white label error page refers to a generic or default error page that is displayed to users when a server encounters an error or fails to process a request. It is called "white label" because it is designed to be neutral and not branded with any specific company or service.

White label error pages are often used in web applications or websites where the server encounters issues such as internal server errors, page not found errors (404), or unauthorized access errors (401). These error pages provide a standardized and consistent user experience by displaying a predefined message or template instead of revealing specific details about the error or the underlying technology being used.

The purpose of a white label error page is to provide a user-friendly and informative message to the user, informing them that something went wrong and providing guidance on what to do next. The page may include instructions to try again later, contact support, or navigate back to the previous page. The content and design of the white label error page can be customized to match the overall branding and design of the application or website.
*/