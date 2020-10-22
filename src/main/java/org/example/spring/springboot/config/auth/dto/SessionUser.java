package org.example.spring.springboot.config.auth.dto;

import lombok.Getter;

@Getter
public class SessionUser {

    private String name;
    private String email;
    private String picture;

    public SessionUser(String name, String email, String picture) {
        this.name = name;
        this.email = email;
        this.picture = picture;
    }
}
