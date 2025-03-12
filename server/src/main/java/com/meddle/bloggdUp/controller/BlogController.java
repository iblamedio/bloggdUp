package com.meddle.bloggdUp.controller;

import com.meddle.bloggdUp.model.Blog;
import com.meddle.bloggdUp.model.Post;
import com.meddle.bloggdUp.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    private BlogService service;

    // create blog
    @PostMapping("/create")
    public Blog create(@RequestBody Blog blog) {
        return service.addBlog(blog);
    }

    // find blog by id
    @GetMapping("/{id}")
    public Blog find(@PathVariable(name = "id") Long id) {
        return service.getBlog(id);
    }

    // search blog posts
    @GetMapping("/{id}/posts")
    public List<Post> search(@PathVariable(name = "id") Long blogId) {
        return service.getPosts(blogId);
    }

    // delete blog
    @PostMapping("/delete")
    public Blog destroy(@RequestBody Long id) {
        return service.deleteBlog(id);
    }

}
