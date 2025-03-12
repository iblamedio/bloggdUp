package com.meddle.bloggdUp.service;

import com.meddle.bloggdUp.model.Blog;
import com.meddle.bloggdUp.model.Post;
import com.meddle.bloggdUp.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    // create post
    public Post addPost(Post post) {
        return repo.save(post);
    }

    // show post by id
    public Post getPost(Long postId) {
        return repo.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
    }

    // delete post
    public Post deletePost(Long postId) {
        Post postToDelete = repo.getReferenceById(postId);
        postToDelete.setActive(false);
        return repo.save(postToDelete);
    }

}
