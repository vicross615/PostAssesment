package com.example.post.model;


public class Post {

    int providerId;
    Field fields;

    public Post(int providerId, Field fields) {
        this.providerId = providerId;
        this.fields = fields;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public Field getFields() {
        return fields;
    }

    public void setFields(Field fields) {
        this.fields = fields;
    }
}
