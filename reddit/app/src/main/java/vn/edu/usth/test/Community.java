package vn.edu.usth.test;


public class Community {
    private String community_name;
    private String community_numbers;
    private int community_image;


    // Constructor
    public Community(String community_name, String community_numbers, int community_image) {
        this.community_name = community_name;
        this.community_numbers = community_numbers;
        this.community_image = community_image;
    }

    // Getter methods
    public String getCommunityName() {
        return community_name;
    }

    public String getCommunityNumbers() {
        return community_numbers;
    }

    public int getCommunityImage() {
        return community_image;
    }

    // Setter methods
    public void setCommunityName(String community_name) {
        this.community_name = community_name;
    }

    public void setCommunityNumbers(String community_numbers) {
        this.community_numbers = community_numbers;
    }

    public void setCommunityImage(int community_image) {
        this.community_image = community_image;
    }
}