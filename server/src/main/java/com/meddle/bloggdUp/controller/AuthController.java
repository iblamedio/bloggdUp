package com.meddle.bloggdUp.controller;

import com.meddle.bloggdUp.config.AuthDTO;
import com.meddle.bloggdUp.config.RegisterDTO;
import com.meddle.bloggdUp.model.Blog;
import com.meddle.bloggdUp.repository.BlogRepository;
import com.meddle.bloggdUp.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private BlogService service;

    @Autowired
    private BlogRepository repo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthDTO data) {

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(data.login(), data.password());

        Authentication auth = authenticationManager.authenticate(token);

        return new ResponseEntity(HttpStatus.OK);

    }

    @PostMapping("/register")
    public ResponseEntity<Blog> register(@RequestBody RegisterDTO data) {
        if(repo.findByLogin(data.login()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPass = new BCryptPasswordEncoder().encode(data.password());

        Blog newBlog = new Blog(data.login(), encryptedPass, data.name());

        Blog response = service.addBlog(newBlog);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

}
