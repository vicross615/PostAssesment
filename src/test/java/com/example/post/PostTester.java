package com.example.post;

import com.example.post.controller.PostController;
import com.example.post.model.Field;
import com.example.post.model.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.server.ResponseStatusException;


class PostTester {

	@Autowired
	private PostController postController;


		@Test
		public void testNewPost() throws ResponseStatusException{
			try{
				ResponseEntity<Post> post = postController.createPost(toPost());
				Assert.notNull(post,"cannot be created" );
			} catch (ResponseStatusException ex){
				ex.getMessage();
			}



		}

		Post toPost() {

			Field field = new Field();
			field.setAge(14);
			field.setName("frank");
			field.setTimestamp("129887432");

			Post post = new Post(12345, field);
			return post;
		}


}
