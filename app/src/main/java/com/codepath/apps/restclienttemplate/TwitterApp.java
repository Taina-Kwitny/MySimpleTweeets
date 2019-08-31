package com.codepath.apps.restclienttemplate;

import android.app.Application;

import com.codepath.apps.restclienttemplate.models.SampleModelDao;

public class TwitterApp extends Application {

    public SampleModelDao getMyDatabase;

    public static Object getRestClient(){

        return null;
    }

    public SampleModelDao getMyDatabase(){
        return getMyDatabase;
    }
}
