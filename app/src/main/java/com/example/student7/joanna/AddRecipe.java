package com.example.student7.joanna;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.student7.joanna.dane.Recipe;
import com.example.student7.joanna.dane.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;
import org.springframework.util.StringUtils;

@EActivity(R.layout.activity_add_recipe)
public class AddRecipe extends ActionBarActivity {

    @Extra
    User user;

    @Bean
    @NonConfigurationInstance
    RestBackgroundAddRecipe restBackgroundAddRecipe;

    //region EditTexts
    @ViewById
    EditText title;
    @ViewById
    EditText introduction;
    @ViewById
    EditText ingredients;
    @ViewById
    EditText Steps;
    @ViewById
    EditText servings;
    @ViewById
    EditText preparationMinutes;
    @ViewById
    EditText cookingMinutes;
    //endregion


    @AfterViews
    void init() {

    }


    @Click
    void addrecipeClicked(){
        //check for required fields
        //TODO: if doesn't work well...
        if(StringUtils.hasText(title.getText().toString()) == true ||
                StringUtils.hasText(introduction.getText().toString()) == true ||
                StringUtils.hasText(Steps.getText().toString()) == true ||
                StringUtils.hasText(servings.getText().toString()) == true){

            //new class
            Recipe recipe = new Recipe();
            recipe.title = title.getText().toString();
            recipe.introduction = introduction.getText().toString();
            recipe.ingredients = ingredients.getText().toString();
            recipe.steps = Steps.getText().toString();
            recipe.servings = servings.getText().toString();
            recipe.preparationMinutes = preparationMinutes.getText().toString();
            recipe.cookingMinutes = cookingMinutes.getText().toString();
            //owner id
            recipe.ownerId = user.id;

            //POST operation
            restBackgroundAddRecipe.addRecipe(recipe,user);

            //go back to MainView intention and pass user instance
            MainView_.intent(this).user(user).start();
        } else{
            Toast.makeText(this, "Uzupełnij wymagane pola!", Toast.LENGTH_LONG).show();
        }
    }


    public void showSuccess(){
        Toast.makeText(this,"Dodano przepis!",Toast.LENGTH_LONG).show();
    }

    public void showError(Exception e){
        Toast.makeText(this, "Niestety, błąd\n" + e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace(); //debug
    }
}
