package com.example.androidlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView tv = (TextView)findViewById(R.id.jokeView);

        if(getIntent().hasExtra(JOKE)){
            tv.setText(getIntent().getStringExtra(JOKE));
        }

    }
}
