package com.nitro.Entity.Users;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @JsonProperty("user")
    UserDetail user;
    String permission;

    public User() {
    }

    public User(UserDetail user, String permission) {
        this.user = user;
        this.permission = permission;
    }

    public UserDetail getUser() {
        return user;
    }

    public void setUser(UserDetail user) {
        this.user = user;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}