package com.meddle.bloggdUp.service;

import com.auth0.jwt.algorithms.Algorithm;
import com.meddle.bloggdUp.model.Blog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(Blog blog) {

        try {
            Algorithm algorithm = Algorithm.HMAC256("");
        } catch() {

        }
    }

}
