package vn.edu.usth.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class FriendListFragment extends Fragment {

    private ListView friendsListView;
    private FriendListAdapter adapter;



    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_friend_list_fragment, container, false);

        friendsListView = view.findViewById(R.id.friends_list_view);

        // Example data for Friends List
        ArrayList<Friend> friendsList = new ArrayList<>();
        friendsList.add(new Friend("Friend 1","acitve: online", R.drawable.friend_icon_1));
        friendsList.add(new Friend("Friend 2","acitve: offline", R.drawable.friend_icon_2));
        friendsList.add(new Friend("Friend 3", "acitve: online",R.drawable.friend_icon_3));
        friendsList.add(new Friend("Friend 4","acitve: online" ,R.drawable.friend_icon_4));
        friendsList.add(new Friend("Friend 5", "acitve: offline",R.drawable.friend_icon_5));
        friendsList.add(new Friend("Friend 6","acitve: online", R.drawable.friend_icon_6));
        friendsList.add(new Friend("Friend 7","acitve: offline", R.drawable.friend_icon_7));
        friendsList.add(new Friend("Friend 8", "acitve: online",R.drawable.friend_icon_8));
        friendsList.add(new Friend("Friend 9","acitve: online" ,R.drawable.friend_icon_9));
        friendsList.add(new Friend("Friend 10", "acitve: offline",R.drawable.friend_icon_10));
        friendsList.add(new Friend("Friend 11","acitve: offline", R.drawable.friend_icon_11));
        friendsList.add(new Friend("Friend 12", "acitve: online",R.drawable.friend_icon_12));
        friendsList.add(new Friend("Friend 13","acitve: online" ,R.drawable.friend_icon_13));
        friendsList.add(new Friend("Friend 14", "acitve: offline",R.drawable.friend_icon_14));
        friendsList.add(new Friend("Friend 15","acitve: online", R.drawable.friend_icon_15));
        friendsList.add(new Friend("Friend 16","acitve: offline", R.drawable.friend_icon_16));
        friendsList.add(new Friend("Friend 17", "acitve: online",R.drawable.friend_icon_17));
        friendsList.add(new Friend("Friend 18","acitve: online" ,R.drawable.friend_icon_18));
        friendsList.add(new Friend("Friend 19", "acitve: offline",R.drawable.friend_icon_19));
        friendsList.add(new Friend("Friend 20", "acitve: offline",R.drawable.friend_icon_20));

        adapter = new FriendListAdapter(getActivity(), friendsList);
        friendsListView.setAdapter(adapter);

        return view;



    }
}
