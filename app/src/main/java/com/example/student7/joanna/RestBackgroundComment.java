package com.example.student7.joanna;

import com.example.student7.joanna.dane.CommentList;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

/**
 * Created by student7 on 2015-01-21.
 */
@EBean
public class RestBackgroundComment {
    @RootContext
    SelectView activity; //activity with listview

    @RestService
    CookbookRestClient restClient; //use that cool interface


    //load recipes in background withoud blocking main application ;-)
    @Background
    void getComment(String path){
        try {
            restClient.setHeader("X-Dreamfactory-Application-Name", "cookbook");
            CommentList commentList = restClient.getComment(path);
            publishResult(commentList);
        } catch (Exception e){ //TODO: avoid using that form of catching exceptions
            publishError(e);
        }
    }

    //background updating
    @UiThread
    void publishResult(CommentList commentList){
        activity.updateComments(commentList);
    }
    //background updating -> sth failed
    @UiThread
    void publishError(Exception e){
        activity.showError(e);
    }



}
