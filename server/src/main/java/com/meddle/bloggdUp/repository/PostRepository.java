package com.meddle.bloggdUp.repository;

import com.meddle.bloggdUp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
