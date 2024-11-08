package vn.edu.usth.test;

public class Friend {
    private String friend_name;
    private int friend_image;
    private String friend_status;

    public Friend(String friend_name, String friend_status, int friend_image) {
        this.friend_name = friend_name;
        this.friend_image = friend_image;
        this.friend_status = friend_status;
    }



    public String getName() {
        return friend_name;
    }

    public String getStatus() {
        return friend_status;
    }

    public int getImageResource() {
        return friend_image;
    }
}