package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

import junit.framework.Assert;

/**
 * Created by jibin on 29/09/16.
 */

public class AsyncTaskTest extends AndroidTestCase {


    public void testgetJokeAsyncTask(){

        String joke =null;

        GetJokeFromGCEAsync jokeFromGCEAsync = new GetJokeFromGCEAsync(getContext());
        jokeFromGCEAsync.execute();
        try{
            joke = jokeFromGCEAsync.get();
            Log.d("GetJokeFromGCEAsync", "joke is   " + joke);
        }catch (Exception e){
            e.printStackTrace();
        }
        assertNotNull(joke);
    }
}
