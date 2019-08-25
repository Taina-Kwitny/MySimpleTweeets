package com.codepath.apps.restclienttemplate.models;


import org.json.JSONException;
import org.json.JSONObject;

public class User {
    // list the attributes
    public string name;
    public long uid;
    private string screenName;
    public string profileImageUrl;

    // deserialized tje JSON
    public  static  User fromJSON(JSONObject json)throws JSONException {
  User user = new User();
// extract and fill the values
user.name = json.getString("name");
user.uid = json.getLong("id");
 user.screenName = json.getString("screen_name");

   return user;
}
 }