package com.example.student7.joanna;

import com.example.student7.joanna.dane.Comment;
import com.example.student7.joanna.dane.Recipe;
import com.example.student7.joanna.dane.User;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

/**
 * Created by student7 on 2015-01-21.
 */
@EBean
public class RestBackgroundAddComment {
    @RootContext
    CommentView activity; //activity with listview

    @RestService
    CookbookRestClient restClient; //use that cool interface


    //load recipes in background withoud blocking main application ;-)
    @Background
    void addComment(User user, Recipe recipe, String text){
        try{
            //rest client headers for POST
            restClient.setHeader("X-Dreamfactory-Application-Name", "cookbook");
            restClient.setHeader("X-Dreamfactory-Session-Token", user.sessionId);

            //new class
            Comment comment = new Comment();
            comment.recipeId = recipe.id;
            comment.ownerId = user.id;
            comment.text = text;

            restClient.addComment(comment);
        } catch(Exception e){
            publishError(e);
        }

    }


    //background updating -> sth failed
    @UiThread
    void publishError(Exception e){
        activity.showError(e);
    }



}
