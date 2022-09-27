# HttpHandler
HttpHandler (Java) for Android with POST and GET methods with easy usage for parameters.

Usage example:

 
```

HttpHandler request = new HttpHandler(this);
  
// GET method:
String get_content = request.GET("https://your.website.com/?param=value"); // get_content variable will store the content returned from url


// OR
// POST method:

String post_request = request.POST("https://your.website.com/", "param=value&param2=value"); // post_request variable will store the content of the url after all parameters was sent with POST method

```
