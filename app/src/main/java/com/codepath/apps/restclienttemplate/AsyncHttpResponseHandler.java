package com.codepath.apps.restclienttemplate;

import com.codepath.asynchttpclient.AbsCallback;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

class AsyncHttpResponseHandler implements AbsCallback {
    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException e) {

    }

    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

    }
}
