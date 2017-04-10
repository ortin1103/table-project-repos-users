package com.nitro.Entity.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nitro.Entity.Users.User;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListlUser {
    List<User> values;

    public List<User> getValues() {
        return values;
    }

    public void setValues(List<User> values) {
        this.values = values;
    }
}
