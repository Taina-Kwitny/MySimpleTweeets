package com.codepath.apps.restclienttemplate;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codepath.apps.restclienttemplate.models.Tweet;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Response;

public class TimelineActivity extends AppCompatActivity {


    private TwitterClient client;
            TweetAdapter tweetAdapter;
            ArrayList<Tweet> tweets;
            RecyclerView rvTweets;
    private Object Throwable;
    private String string;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        client = (TwitterClient) TwitterApp.getRestClient();

        //find the RecyclerView
        rvTweets = (RecyclerView) findViewById(R.id.rvtweet);
        //init the arraylist (data source)
        tweets = new ArrayList<>();
        // construct the adapter from this datasource
        tweetAdapter = new TweetAdapter(tweets);
        //RecyclerView setup (Layout manager, use adapter)
        rvTweets.setLayoutManager(new LinearLayoutManager(this));
        // set the adapter
        rvTweets.setAdapter(tweetAdapter);
        populateTimeline();
    }

//    private void populateTimeline() {
//        client.getHomeTimeline(new JsonHttpResponseHandler() {
//            public void setStatusCode(int statusCode) {
//                this.statusCode = statusCode;
//            }
//
//            public int getStatusCode() {
//                return statusCode;
//            }
//
//            public void setHeaders(Headers[] headers) {
//                this.headers = headers;
//            }
//
//            public Headers[] getHeaders() {
//                return headers;
//            }
//
//            @Override
//            public void onSuccess(int statusCode, Headers headers, JSON json) {
//
//            }
//
//            @Override
//            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
//
//            }
//
//            private int statusCode;
//            private Headers[] headers;
//
//
//            public void onSuccess(int statusCode, Headers[] headers, JSONObject response) {
//                this.statusCode = statusCode;
//                this.headers = headers;
//                Log.d("TwitterClient", response.toString());
//            }
//
//            public void onSuccess(int statusCode, Headers[]headers, JSONArray response) {
//                this.statusCode = statusCode;
//                this.headers = headers;
//                //         Log.d("TwitterClient", response.toString());
//                // iterate through the JSON array
//                // for each entry, deserialize the JSON object
//
//                for (int i = 0; i < response.length(); i++) {
//                    // convert each object to a Tweet model
//                    // add that Tweet model to our data source
//                    // notify the adapter that we've added an item
//                    try {
//                        Tweet tweet = Tweet.fromJSON(response.getJSONObject(i));
//                        tweets.add(tweet);
//                        tweetAdapter.notifyItemInserted(tweets.size() - 1);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//
//            }
//
//
//            public void onSuccess(int statusCode,Headers[], String responseString, Throwable throwable) {
//                Log.d("TwitterClient", responseString);
//                throwable.addSuppressed((java.lang.Throwable) Throwable);
//            }
//
//
//            public void onFailure(int statusCode, Headers[] headers, Throwable throwable, JSONObject errorResponse) {
//                Log.d("TwitterClient", errorResponse.toString());
//                throwable.printStackTrace();
//            }
//
//            public void onFailure(int statusCode, Headers[] headers, Throwable throwable , String response) {
//                super.onFailure(statusCode, headers, string response);
//
//            }
//        });
//    }

    private void populateTimeline(){
        client.getHomeTimeline(new AsyncHttpResponseHandler() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.d("Succes", response.toString());
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                super.onFailure(call, e);
            }
        });
    }

}

