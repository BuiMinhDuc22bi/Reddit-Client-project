package vn.edu.usth.test;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Feed {
    private String title;
    private int imageResource;
    private int upvotes;
    private int downvotes;
    private int share;
    private List<String> comments;  // List to store comments

    public Feed(String title, int imageResource) {
        this.title = title;
        this.imageResource = imageResource;
        this.upvotes = 0;
        this.downvotes = 0;
        this.comments = new ArrayList<>();
        this.share = 0;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResource() {
        return imageResource;
    }
    // Getters
    public int getUpvotes() {
        return upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public List<String> getComments() {
        return comments;
    }

    public int getShare(){return share;}

    // Increment methods
    public void incrementUpvotes() {
        this.upvotes++;
    }

    public void incrementDownvotes() {
        this.downvotes++;
    }

    public void incrementShares(){this.share++;}

    public void addComment(String comment) {
        this.comments.add(comment);
    }


}