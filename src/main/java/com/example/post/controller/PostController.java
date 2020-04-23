package com.example.post.controller;

import com.example.post.model.Field;
import com.example.post.model.Post;
import com.example.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1")
public class PostController {


    private  List<Post> listOfPosts = new ArrayList<>();

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

        List<Post> posterList = listOfPosts;
        return new ResponseEntity<List<Post>>(posterList, HttpStatus.OK);
    }

    @GetMapping("/providers-post")
    public ResponseEntity<List<Post>> getByProvider(int providerId){
        List<Post> posts= listOfPosts.stream().filter(post-> post.getProviderId() == providerId)
                                                                .collect(Collectors.toList());
        return new ResponseEntity<List<Post>>(posts, HttpStatus.ACCEPTED);
    }
}
