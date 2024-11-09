package vn.edu.usth.test;

public class Notification {
    private String notificationName;
    private int notificationImage;
    private String notificationText;
    private int postId;
    private int postImage;
    private String postText;

    // Updated constructor
    public Notification(String notificationName, int notificationImage, String notificationText, int postId, int postImage, String postText) {
        this.notificationName = notificationName;
        this.notificationImage = notificationImage;
        this.notificationText = notificationText;
        this.postId = postId;
        this.postImage = postImage;
        this.postText = postText;
    }

    public String getNotificationName() {
        return notificationName;
    }

    public void setNotificationName(String notificationName) {
        this.notificationName = notificationName;
    }

    public int getNotificationImage() {
        return notificationImage;
    }

    public void setNotificationImage(int notificationImage) {
        this.notificationImage = notificationImage;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getPostImage() {
        return postImage;
    }

    public void setPostImage(int postImage) {
        this.postImage = postImage;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }
}