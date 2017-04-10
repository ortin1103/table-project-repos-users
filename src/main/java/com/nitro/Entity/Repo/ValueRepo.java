package com.nitro.Entity.Repo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValueRepo {
    List<Repo> values;

    public List<Repo> getValues() {
        return values;
    }

    public void setValues(List<Repo> values) {
        this.values = values;
    }

}
