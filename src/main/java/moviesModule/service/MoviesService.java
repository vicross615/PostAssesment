package moviesModule.service;

import com.fasterxml.jackson.core.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MoviesService {

    RestTemplate restTemplate = new RestTemplate();

    @Value("${base.url.movies:https://jsonmock.hackerrank.com/api/movies/search/?Title=}")
    private String BASEURL;




    public void getClientIP(){
//        String sURL = "http://freegeoip.net/json/"; //just a string
//
//        // Connect to the URL using java's native library
//        URL url = new URL(sURL);
//        URLConnection request = url.openConnection();
//        request.connect();
//
//        // Convert to a JSON object to print data
//        JsonParser jp = new JsonParser(); //from gson
//        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
//        JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
//        String zipcode = rootobj.get("zip_code").getAsString(); //just grab the zipcode
    }



}
