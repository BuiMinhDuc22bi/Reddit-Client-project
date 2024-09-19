package vn.edu.usth.test;

public class Notification {
    private String notificationName;
    private int notificationImage;
    private String notificationText;  // Add this field for notification title

    // Updated constructor
    public Notification(String notificationName, int notificationImage, String notificationText) {
        this.notificationName = notificationName;
        this.notificationImage = notificationImage;
        this.notificationText = notificationText;
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
}
