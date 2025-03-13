package com.meddle.bloggdUp.controller;

import com.meddle.bloggdUp.model.Blog;
import com.meddle.bloggdUp.model.Post;
import com.meddle.bloggdUp.service.BlogService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    private BlogService service;

    // create blog
    @PostMapping("/create")
    public ResponseEntity<Blog> create(@RequestBody Blog blog) {
        Blog response = service.addBlog(blog);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // find blog by id
    @GetMapping("/{id}")
    public ResponseEntity<Blog> find(@PathVariable(name = "id") Long id) {
        Blog response = service.getBlog(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // search blog posts
    @GetMapping("/{id}/posts")
    @CrossOrigin
    public ResponseEntity<List<Post>> search(@PathVariable(name = "id") Long blogId) {
        List<Post> response = service.getPosts(blogId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // delete blog
    @PostMapping("/delete")
    public ResponseEntity<Blog> destroy(@RequestBody Long id) {
        Blog response = service.deleteBlog(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
