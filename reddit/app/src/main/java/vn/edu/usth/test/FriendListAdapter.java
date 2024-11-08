package vn.edu.usth.test;



import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class FriendListAdapter extends ArrayAdapter<Friend> {

    public FriendListAdapter(Context context, List<Friend> friends) {
        super(context, 0, friends);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // If convertView is null, inflate a new layout from friend_item.xml
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.friend_item, parent, false);
        }

        Friend friend = getItem(position);
        TextView friend_name = convertView.findViewById(R.id.friend_name);
        TextView friend_status = convertView.findViewById(R.id.friend_status);
        ImageView friend_image = convertView.findViewById(R.id.friend_image);


        // Set friend name
        friend_name.setText(friend.getName());
        // Set friend status
        friend_status.setText(friend.getStatus());
        // Set friend image
        friend_image.setImageResource(friend.getImageResource());
        return convertView;
    }

}


