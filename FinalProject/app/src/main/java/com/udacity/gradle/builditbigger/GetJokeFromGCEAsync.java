package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;


import com.example.JokeList;
import com.example.androidlibrary.JokeActivity;
import com.example.jibin.myapplication.backend.jokeApi.JokeApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by jibin on 28/09/16.
 */

public class GetJokeFromGCEAsync extends AsyncTask<Void,Void,String> {

    private static JokeApi myApiService = null;
    private Context context;
    private ProgressDialog progressDialog ;

    public GetJokeFromGCEAsync(Context ctx){
        context = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getString(R.string.plz_wait));

        if(context instanceof MainActivity) {
            progressDialog.show();
        }
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("https://third-faculty-144808.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }


        try {
            String message = myApiService.getJoke().execute().getData();
            return message;
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {

        progressDialog.dismiss();
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();

        Intent intent  = new Intent(context, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE, result);
        context.startActivity(intent);
    }
}
