package com.sergiojavierre.dao.tweets;

import com.sergiojavierre.entities.Tweet;

import java.util.List;

public interface DAOTweets {

    public void tuiter(Tweet tweet);
    public List<Tweet> read();

}
