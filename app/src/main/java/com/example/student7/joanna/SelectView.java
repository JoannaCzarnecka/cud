package com.example.student7.joanna;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.student7.joanna.adapter.CommentListAdapter;
import com.example.student7.joanna.dane.Comment;
import com.example.student7.joanna.dane.CommentList;
import com.example.student7.joanna.dane.Recipe;
import com.example.student7.joanna.dane.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by student7 on 2015-01-20.
 */
@EActivity(R.layout.activity_selectrecipe)
public class SelectView extends ActionBarActivity {

@Extra
Recipe recipe;
@Extra
User user;

@Extra
Bundle bundle;


//process dialog
ProgressDialog ringProgressDialog;

    //region background tasks
    @Bean
    @NonConfigurationInstance
    RestBackgroundComment restBackgroundComment;


    @Bean
    CommentListAdapter adapter;

    //region list with comments
    @ViewById
    ListView listComment;
    //endregion

//buttons
@ViewById
Button comment;
@ViewById
Button like;

//region TextVievs
@ViewById
TextView title;
@ViewById
TextView introduction;
@ViewById
TextView ingredients;
@ViewById
TextView created;
@ViewById
TextView preparationMinutes;
@ViewById
TextView cookingMinutes;
@ViewById
TextView servings;
@ViewById
TextView likes;
//endregion

    @AfterViews
    void init() {
        CommentList.set.adapter(adapter);

        //unpack bundle
        recipe = (Recipe)bundle.getSerializable("recipe");
        user = (User)bundle.getSerializable("user");

        //process dialog
        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Ładowanie...");
        ringProgressDialog.setIndeterminate(true);

        //for loading comments
        ringProgressDialog.show();

        //set textviews
        title.setText(recipe.title);
        introduction.setText(recipe.introduction);
        ingredients.setText(recipe.ingredients);
        created.setText(recipe.created);
        preparationMinutes.setText(recipe.preparationMinutes);
        cookingMinutes.setText(recipe.cookingMinutes);
        servings.setText(recipe.servings);


    }
}
