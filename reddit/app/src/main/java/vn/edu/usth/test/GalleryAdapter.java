package vn.edu.usth.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class GalleryAdapter extends BaseAdapter {
    private List<Item> postList; // List of Item objects
    private Context context;
    private LayoutInflater inflater;

    public GalleryAdapter(Context context, List<Item> postList) {
        this.context = context;
        this.postList = postList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return postList.size();
    }

    @Override
    public Object getItem(int position) {
        return postList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate the layout for each item in the ListView
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_gallery, parent, false); // Create a custom item layout for each post
        }

        // Get the ImageView and load the image from the URL using Glide
        ImageView imageView = convertView.findViewById(R.id.gallery_image);
        TextView tagsTextView = convertView.findViewById(R.id.tags_text);
        TextView likesTextView = convertView.findViewById(R.id.likes_text);

        // Get the current item
        Item item = postList.get(position);

        // Load the image using Glide (ensure you have Glide added in your dependencies)
        Glide.with(context).load(item.getImageUrl()).into(imageView);

        // Set tags and likes text
        tagsTextView.setText(item.getTags());
        likesTextView.setText("Likes: " + item.getLikes());

        return convertView;
    }
}
