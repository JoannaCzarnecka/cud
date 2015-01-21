package com.example.student7.joanna.dane;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by student7 on 2015-01-21.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CookBook {

    @JsonProperty("record")
    public List<Recipe> records = new ArrayList<Recipe>();
}
