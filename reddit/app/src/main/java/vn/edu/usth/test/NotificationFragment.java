package vn.edu.usth.test;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends Fragment implements NotificationClickListener {
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
        notificationList.add(new Notification("No_One", R.drawable.friend_icon_1, "OMG", 1, R.drawable.bear_schok_2, "1st time see bear?"));
        notificationList.add(new Notification("Heh", R.drawable.friend_icon_16, "let's go!!", 2, R.drawable.cozy_1, "chill..."));
        notificationList.add(new Notification("NintendoSwitch", R.drawable.nintendo_switch_icon_1, "check it out!!", 3, R.drawable.doge_meme, "See more..."));
        notificationList.add(new Notification("doge memes", R.drawable.doge_meme, "bark bark bark!", 4, R.drawable.dog_shock_2, "tat ca la tai duck"));
        notificationList.add(new Notification("Who_Know", R.drawable.duck_1, "Biet ong Lao khong?", 5, R.drawable.duck_1, "Lao gi cung ton"));
        notificationList.add(new Notification("Lmao", R.drawable.cat_shock_1, "Meow :3", 6, R.drawable.cat_1, "Cat lover"));
        notificationList.add(new Notification("STH_NEWS", R.drawable.art_1, "check it out!!", 7, R.drawable.dragon_ball_1, "heh :)))))"));
        notificationList.add(new Notification("YO", R.drawable.anime_1, "wow!", 8, R.drawable.flower_1, "Love it!"));
        notificationList.add(new Notification("Iva", R.drawable.intj_1, "LVA nhung chu i viet hoa", 8, R.drawable.chiken_1, "That a long story..."));
        notificationList.add(new Notification("Y Va", R.drawable.love_1, "Francais si vous plait", 8, R.drawable.dog_shock_2, "Why :<"));
        notificationList.add(new Notification("Eva", R.drawable.healt_care_1, "Doc giong Iva nen dat name la Eva", 8, R.drawable.funny_1, "Lmeo"));
        notificationList.add(new Notification("Le Viet N", R.drawable.soc_meme_1, "Loi chu A :<", 8, R.drawable.lol_1, "Not the 1st time..."));
        notificationList.add(new Notification("Duck", R.drawable.panda_shock_1, "Just Duck", 8, R.drawable.monkey_1, "TAT CA LA TAI DUCKKKKK!!!!!!"));

        // Initialize the adapter with the notification list and listener
        notificationAdapter = new NotificationAdapter(notificationList, this);

        // Set the adapter and layout manager to the RecyclerView
        receive_notification.setAdapter(notificationAdapter);
        receive_notification.setLayoutManager(new LinearLayoutManager(getContext()));

        // Get the current theme mode from SharedPreferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean isDarkMode = preferences.getBoolean("isDarkMode", false);

        // Set the background color based on the theme
        if (isDarkMode) {
            view.setBackgroundColor(getResources().getColor(android.R.color.black)); // Dark mode background
        } else {
            view.setBackgroundColor(getResources().getColor(android.R.color.white)); // Light mode background
        }

        return view;
    }

    @Override
    public void onNotificationClick(Notification notification) {
        // Handle the notification click event to show the corresponding post
        PostFragment postFragment = PostFragment.newInstance(notification.getPostId(), notification.getPostImage(), notification.getPostText());
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, postFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}