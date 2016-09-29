package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.JokeList;
import com.example.androidlibrary.JokeActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void tellJokeJava(View view) {


        Toast.makeText(this, JokeList.getYourJoke(), Toast.LENGTH_SHORT).show();
    }
    public void tellJokeActivity(View view) {


        Intent intent  = new Intent(this, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE,JokeList.getYourJoke());
        startActivity(intent);

    }
public void tellJokeGCE(View v){

    new GetJokeFromGCEAsync(this).execute();
}

}
