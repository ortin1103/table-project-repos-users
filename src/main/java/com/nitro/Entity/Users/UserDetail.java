package com.nitro.Entity.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;


@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetail {

    String name;
    String displayName;
    long id;
    String emailAddress;

    public UserDetail() {
    }

    public UserDetail(String displayName) {
        this.displayName = displayName;
    }

    public UserDetail(String name, String displayName, long id, String emailAddress) {
        this.name = name;
        this.displayName = displayName;
        this.id = id;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
