package com.meddle.bloggdUp.controller;

import com.meddle.bloggdUp.model.Post;
import com.meddle.bloggdUp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService service;

    // create post - POST /api/post/create
    @PostMapping("/create")
    public ResponseEntity<Post> add(@RequestBody Post post) {
        Post response = service.addPost(post);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // show posts by blog - GET /api/post/showAll/{blogId}

    // show post by id - GET /api/post/show/{post_id}
    @GetMapping("/show/{post_id}")
    public ResponseEntity<Post> get(@PathVariable(value = "post_id") Long postId) {
        return new ResponseEntity<>(service.getPost(postId), HttpStatus.OK);
    }

    // delete post - POST /api/post/delete
    @PostMapping("/delete")
    public ResponseEntity<Post> delete(@RequestBody Long postId) {
        return new ResponseEntity<>(service.deletePost(postId), HttpStatus.OK);
    }

}
