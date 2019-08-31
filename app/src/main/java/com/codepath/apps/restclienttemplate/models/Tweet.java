package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *  Created by rhu on 5/23/17
 */
public class Tweet {

    // list out the attributes
    public  String body;
    public long uid; // database ID for the tweet
    public Object user;
    public String createdAt;
    public int username;

    // deserialize the JSON
    public static Tweet fromJSON(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();

        // extract the values from JSON
        tweet.body = jsonObject.getString("text");
        tweet.uid = jsonObject.getLong("id");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));
        return tweet;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

