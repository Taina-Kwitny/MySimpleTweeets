package com.codepath.apps.restclienttemplate;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

/**
 * Created by rhu on 5/15/17
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

public class TweetAdapter extends  RecyclerView.Adapter<TweetAdapter.ViewHolder> {

 private List<Tweet> mTweets;
  Context context;

    // pass in the Tweets array in the constructor
    public  TweetAdapter(List<Tweet> tweets) { mTweets = tweets; }


    // inflate the layout and cache the findViewByids into a ViewHolder
    @Override
    public TweetAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
         context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View tweetView = inflater.inflate(R.layout.item_tweet, parent, false);

        ViewHolder viewHolder = new ViewHolder(tweetView);
        return viewHolder;
    }


    // bind the values based on the position of the element

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {

         // get the data according to position
        Tweet tweet = mTweets.get(position);

        //set view data according to the model
        holder.tvUsername.setText(tweet.user.name);
        holder.tvBody.setText(tweet.body);

        Glide.with(context).load(tweet.user.profileImageUrl).into(holder.ivProfileImage);

    }
    @Override
     public int getItemCount() { return mTweets.size(); }

    // create ViewHolder class

    public static class  ViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivProfileImage;
        public TextView tvUsername;
        public  TextView tvBody;

        public  ViewHolder(View itemView){
            super(itemView);

            // perfom findViewById lookups

            ivProfileImage = (ImageView) itemView.findViewById(R.id.ivProfileImage);
            tvUsername = (TextView) itemView.findViewById(R.id.tvUserName);
            tvBody = (TextView) itemView.findViewById(R.id.tvBody)
        }
    }
}
