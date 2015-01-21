package com.example.student7.joanna.dane;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by student7 on 2015-01-21.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe implements Serializable {
    public int id;
    public int ownerId;
    public String title;
    public String introduction;
    public String ingredients;
    public String steps;
    public String created;
    public String preparationMinutes;
    public String cookingMinutes;
    public String servings;

}





