# HttpHandler
HttpHandler (Java) for Android with POST and GET methods with easy usage for parameters.

Usage example:

 
```
public class MainActivity {

  HttpHandler request = new HttpHandler(this);
  
  protected void onCreate() {
  
    new Thread(new Runnable() {
       @Override
       public void run() {

           // GET method:
           try {
               String get_content = request.GET("https://your.website.com/?param=value"); // get_content variable will store the content returned from url
           } catch (Exception e) {
               e.printStackTrace();
           }

           // OR
           // POST method:
           try {
               String post_request = request.POST("https://your.website.com/", "param=value&param2=value"); // post_request variable will store the content of the url after all parameters was sent with POST method
           } catch (Exception e) {
               e.printStackTrace();
           }

       }
   }).start();
       
  }
  
}
```
