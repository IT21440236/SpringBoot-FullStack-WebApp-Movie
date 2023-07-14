import "./App.css";
import api from "./api/axiosConfig";
import { useEffect, useState } from "react";

function App() {
  const [movies, setMovies] = useState(); //Returns a desctructured array with 2 elements, the first is the state and the second is the function to update the state. will store the movies from the api call.

  //Lets create a function that will handle a HTTP get request to an api endpoint that will return a list of movies.
  //Once the movie data is successfully returned, this code that changes the state of the movies array will be executed.

  try {
    const getMovies = async () => {
      const response = await api.get("/api/v1/movies");

      console.log(response.data);

      setMovies(response.data);
    };
  } catch (error) {
    console.log(error);
  }

  //Now we have to call this function. We can do this by using the useEffect hook.
  //getMovies(); //This will call the getMovies function when the component is rendered.
  useEffect(() => {
    getMovies();
  }, []); //This will call the getMovies function when the component is rendered.

  return <div className="App"></div>;
}

export default App;

//NOTES

/*
In React, you may use the `async` keyword to declare an asynchronous function. Here are a few reasons why you might use the `async` keyword in React:

1. Handling asynchronous operations: Asynchronous operations, such as making API calls or fetching data from a server, can take some time to complete. By using the `async` keyword, you can write functions that can pause and resume their execution while waiting for asynchronous tasks to finish. This allows you to handle asynchronous operations more conveniently and avoid blocking the main thread of execution.

2. Using `await` for promises: The `async` keyword works in conjunction with the `await` keyword. When you mark a function as `async`, you can use `await` to wait for promises to resolve. This simplifies the syntax and makes the code more readable by avoiding nested callbacks or excessive chaining of `then` methods.

3. Error handling: Asynchronous operations can potentially fail, resulting in rejected promises. By using `async/await`, you can handle errors more effectively using try-catch blocks. This makes it easier to handle exceptions and provide appropriate error handling within your React components.

Overall, using the `async` keyword in React allows you to write more concise and readable code when dealing with asynchronous operations, simplifies error handling, and ensures a smoother execution flow in your application.

============================================================

In React's useEffect hook, the empty array ([]) is used as the dependency list. It specifies that the effect should only run once, immediately after the component mounts, and not re-run on subsequent renders.

The useEffect hook allows you to perform side effects in your components, such as fetching data from an API or subscribing to events. The second argument of useEffect is the dependency list, which determines when the effect should be re-run.

By passing an empty array ([]) as the dependency list, you are telling React that the effect does not depend on any values from the component's state or props. Therefore, the effect will only run once, after the initial render.

This pattern is commonly used when you want to perform an action on component mount and do not need to re-run the effect based on changes in component state or props. It helps optimize performance by avoiding unnecessary re-renders and side effects.
*/
