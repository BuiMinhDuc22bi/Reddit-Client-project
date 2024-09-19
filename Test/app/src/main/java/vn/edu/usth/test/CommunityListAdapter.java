package vn.edu.usth.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CommunityListAdapter extends ArrayAdapter<Community> {

    public CommunityListAdapter(Context context, List<Community> communities) {
        super(context, 0, communities);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate the layout if it's null
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.community_item, parent, false);
        }

        // Get the Community item for this position
        Community community = getItem(position);

        // Find the views
        TextView orderedNumber = convertView.findViewById(R.id.ordered_number);
        TextView community_name = convertView.findViewById(R.id.community_name);
        TextView community_number = convertView.findViewById(R.id.community_number);
        ImageView community_image = convertView.findViewById(R.id.community_image);
        Button join_button = convertView.findViewById(R.id.join_button);

        // Check if the community item is null
        if (community != null) {
            // Set the community details and ordered numbers to the views
            orderedNumber.setText(String.valueOf(position + 1));
            community_name.setText(community.getCommunityName());
            community_number.setText(community.getCommunityNumbers());
            community_image.setImageResource(community.getCommunityImage());

            // Set the join button color to black
            join_button.setBackgroundColor(getContext().getResources().getColor(android.R.color.holo_blue_dark));
            join_button.setTextColor(getContext().getResources().getColor(android.R.color.white));

            // Set click listener for the join button
            join_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Show a Toast message when the button is clicked
                    Toast.makeText(getContext(), "You have joined " + community.getCommunityName(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        return convertView;
    }
}