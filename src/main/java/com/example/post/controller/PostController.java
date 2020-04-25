package com.example.post.controller;

import com.example.post.model.Field;
import com.example.post.model.Post;
import com.example.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1")
public class PostController {


    private  List<Post> listOfPosts = new ArrayList<>();
   // private Map<Integer, Post> postByProvider = new HashMap<>();

    @PostMapping("/post")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        try {
            listOfPosts .add(post);
            return new ResponseEntity<>(post, HttpStatus.CREATED);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPost() {

        return new ResponseEntity<List<Post>>(listOfPosts, HttpStatus.OK);
    }

    @GetMapping("/filter/{providerId}")
    public ResponseEntity<List<Post>> getByProvider(@PathVariable int providerId){
        List<Post> posts= listOfPosts.stream().filter(post-> post.getProviderId() == providerId)
                                                                .collect(Collectors.toList());
        return new ResponseEntity<List<Post>>(posts, HttpStatus.ACCEPTED);
    }

    @GetMapping("/filter/{provider_Id}")
    public ResponseEntity<?>  getProviderData(@PathVariable("provider_Id") int providerId,
                                                @RequestParam("name") String name,
                                              @RequestParam("age") String age,
                                              @RequestParam("timestamp") String timestamp) {
        List<String> providerData = new ArrayList<>();
        try{
            providerData.addAll(performOperation(name, "name"));
            providerData.addAll(performOperation(age, "age"));
            providerData.addAll(performOperation(timestamp, "timestamp"));
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<Object>(providerData, HttpStatus.ACCEPTED);
    }

    private List<String> performOperation(String var,String field){
        String [] result = preprocessesField(var);

        String condition = result[0];
        String value = result[1];

        return rules(condition,value,field);
    }

    public String[] preprocessesField(String param) {
        return param.split(":");
    }

    public List<String> rules(String condition, String value, String field) {
        List<String> result = new ArrayList<>();

        switch(condition) {
            case "eqc":
                 //operation
                String eqc ="";
                  listOfPosts.stream().filter(post ->
                                                    post.getFields().getName().equalsIgnoreCase(value)).collect(Collectors.toList());

                 result.add(eqc);
                break;

            case "eq":
                    //operation
                break;
//            case "gt":
//                //operation
//                break;
//
//            case "lt":
//                //operation
        }

        return result;
    }



}
