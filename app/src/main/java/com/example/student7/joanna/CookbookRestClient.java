package com.example.student7.joanna;

import com.example.student7.joanna.dane.Comment;
import com.example.student7.joanna.dane.Recipe;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.RequiresHeader;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.RestClientHeaders;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Created by student7 on 2015-01-21.
 */
@Rest(rootUrl = "http://pegaz.wzr.ug.edu.pl:8080/rest",
        converters = { MappingJackson2HttpMessageConverter.class })
@RequiresHeader({"X-Dreamfactory-Application-Name"})
public interface CookbookRestClient extends RestClientHeaders {


    //Get&Post for selecting/adding recipes
    @Get("/db/recipes")
    CookbookRestClient getCookBook();

    @RequiresHeader({"X-Dreamfactory-Application-Name", "X-Dreamfactory-Session-Token"})
    @Post("/db/recipes")
    void addRecipe(Recipe recipe);


}

