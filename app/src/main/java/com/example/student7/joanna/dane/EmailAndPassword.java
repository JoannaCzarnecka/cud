package com.example.student7.joanna.dane;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by student7 on 2015-01-21.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailAndPassword {
    public String email;
    public String password;
}
