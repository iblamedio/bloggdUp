package com.meddle.bloggdUp.service;

import com.meddle.bloggdUp.model.Blog;
import com.meddle.bloggdUp.model.Post;
import com.meddle.bloggdUp.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogRepository repo;

    // create blog
    public Blog addBlog(Blog blog) {
        return repo.save(blog);
    }

    // find blog by id
    public Blog getBlog(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));
    }

    // search blog posts
    public List<Post> getPosts(Long blogId) {
        return this.getBlog(blogId).getPosts();
    }


    // delete blog
    public Blog deleteBlog(Long id) {
        Blog blogToBeDeleted = this.getBlog(id);
        blogToBeDeleted.setActive(false);
        return repo.save(blogToBeDeleted);
    }

}
