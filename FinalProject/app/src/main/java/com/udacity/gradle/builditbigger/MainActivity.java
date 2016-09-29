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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
