# HttpHandler
HttpHandler in Java for Android with POST and GET methods with easy usage for parameters.

Usage example:

 
```
public class MainActivity {

  HttpHandler request = new HttpHandler(this);
  
  protected void onCreate() {
    // GET method:
    
    // get_content variable will store the content returned from url
    String get_content = request.GET("https://your.website.com/?param=value");  
    
    // OR
    // POST method:
    
    // post_request variable will store the content of the url after all parameters was sent with POST method
    String post_request = request.POST("https://your.website.com/", "param=value&param2=value"); 
  }
  
}
```
