package com.example.student7.joanna.dane;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by student7 on 2015-01-21.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {
    public int id;
    public int recipeId;
    public int ownerId;
    public String text;
    public String created;
}
