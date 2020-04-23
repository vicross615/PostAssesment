package com.example.post.service;

import com.example.post.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostService {

    private List<Post> listOfPosts = new ArrayList<>();

    public Post save(Post post) {
        try{
            this.listOfPosts.add(post);

        }
        catch(Exception ex) {
            ex.printStackTrace();
        }

        return post;
    }

    public List<Post> getAll() {
        return listOfPosts;
    }
}
