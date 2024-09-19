package vn.edu.usth.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends Fragment {
    private RecyclerView receive_notification;
    private NotificationAdapter notificationAdapter;
    private List<Notification> notificationList;

    public NotificationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        // Connect RecyclerView
        receive_notification = view.findViewById(R.id.receive_notification);

        // Initialize notification list
        notificationList = new ArrayList<>();
        notificationList.add(new Notification("Friend_1", R.drawable.friend_icon_1, "OMG"));
        notificationList.add(new Notification("Friend_16", R.drawable.friend_icon_16, "let'go!!"));
        notificationList.add(new Notification("NintendoSwitch", R.drawable.nintendo_switch_icon_1, "check it out!!"));
        notificationList.add(new Notification("doge memes", R.drawable.doge_meme, "bark bark bark!"));
        // Initialize the adapter with the notification list
        notificationAdapter = new NotificationAdapter(notificationList);

        // Set the adapter and layout manager to the RecyclerView
        receive_notification.setAdapter(notificationAdapter);
        receive_notification.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}
