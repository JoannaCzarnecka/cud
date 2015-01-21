package com.example.student7.joanna.dane;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student7 on 2015-01-21.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentList {
    @JsonProperty("record")
    public List<Comment> records = new ArrayList<Comment>();
}