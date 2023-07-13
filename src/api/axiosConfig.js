import axios from "axios";

export default axios.create({
  baseURL: "https://9c96-103-106-239-104.ap.ngrok.io", //This is the url that we get from ngrok.
  headers: { "ngrok-skip-browser-warning": "true" },
  //This code means that we are going to use this url as a base url for all the requests we are going to make from this file.
  //cors error is because of the ngrok url. So we have to add this header to the axios config. so that it will not show the cors error.
  ///cors means cross origin resource sharing. It is a security feature in the browser. It is used to prevent the cross origin requests.
});

//NOTES

/*Axios is a popular JavaScript library used in React applications for making HTTP requests to external resources, such as APIs. It provides an easy-to-use and powerful API that simplifies the process of sending asynchronous HTTP requests and handling responses.

Here are some key uses of Axios in React:

1. Sending HTTP Requests: Axios allows you to send various types of HTTP requests, including GET, POST, PUT, DELETE, and more. It provides a simple and consistent syntax for specifying the request method, URL, request headers, request body, and other parameters.

2. Handling Responses: Axios makes it easy to handle the responses returned by the server. It provides methods for accessing the response data, response headers, and status codes. You can also handle errors and handle different response formats, such as JSON, XML, or plain text.

3. Interceptors: Axios allows you to intercept requests or responses before they are sent or received. This feature is useful for adding common headers, authentication tokens, or performing global error handling.

4. Promise-based API: Axios is built on top of JavaScript promises, which enables you to take advantage of async/await syntax or use promise chaining to handle asynchronous operations. This helps in writing cleaner and more readable asynchronous code.

5. Cross-Origin Resource Sharing (CORS): Axios handles CORS-related issues by default, simplifying the process of making cross-origin requests from your React application.

Overall, Axios is a powerful and widely-used library for handling HTTP requests in React applications. It provides a convenient and consistent API, making it easier to work with external APIs and retrieve data from servers. */
