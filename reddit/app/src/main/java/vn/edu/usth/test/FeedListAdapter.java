package vn.edu.usth.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class FeedListAdapter extends ArrayAdapter<Article> {

    private Context context;
    private List<Article> articles;

    public FeedListAdapter(Context context) {
        super(context, 0);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_feed_item, parent, false);
        }

        Article article = getItem(position);

        TextView title = convertView.findViewById(R.id.feed_title);
        ImageView image = convertView.findViewById(R.id.feed_image);

        title.setText(article.getTitle());

        // Load image using Glide
        if (article.getUrlToImage() != null) {
            Glide.with(context)
                    .load(article.getUrlToImage())
                    .into(image);
        } else {
            image.setImageResource(R.drawable.sunny); // Set a default image
        }

        return convertView;
    }

    // Method to update the list of articles
    public void setFeeds(List<Article> newArticles) {
        clear();
        addAll(newArticles);
        notifyDataSetChanged();
    }
}