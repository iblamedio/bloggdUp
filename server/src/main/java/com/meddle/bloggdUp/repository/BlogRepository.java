package com.meddle.bloggdUp.repository;

import com.meddle.bloggdUp.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    public UserDetails findByLogin(String login);
}
