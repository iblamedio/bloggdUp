package com.meddle.bloggdUp.repository;

import com.meddle.bloggdUp.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
