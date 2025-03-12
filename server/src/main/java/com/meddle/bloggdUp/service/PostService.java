package com.meddle.bloggdUp.service;

import com.meddle.bloggdUp.model.Post;
import com.meddle.bloggdUp.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    // create post
    public Post addPost(Post post) {
        return repo.save(post);
    }

    // show posts by blog

    // show post by id
    public Post getPost(Long postId) {
        return repo.getReferenceById(postId);
    }

    // delete post
    public Post deletePost(Long postId) {
        Post postToDelete = repo.getReferenceById(postId);
        postToDelete.setActive(false);
        return repo.save(postToDelete);
    }

}
