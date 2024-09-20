package vn.edu.usth.test;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class ChatFragment extends Fragment {
    private RecyclerView receiveMessage;
    private ChatAdapter chatAdapter;
    private List<Chat> chatList;
    private EditText textmessage;
    private Button button_message;


    public ChatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        // Get the current theme mode from SharedPreferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean isDarkMode = preferences.getBoolean("isDarkMode", false);

        // Set the background color based on the theme
        if (isDarkMode) {
            view.setBackgroundColor(getResources().getColor(android.R.color.black)); // Dark mode background
        } else {
            view.setBackgroundColor(getResources().getColor(android.R.color.white)); // Light mode background
        }


        // The rest of your initialization code...
        textmessage = view.findViewById(R.id.text_message);
        button_message = view.findViewById(R.id.button_message);
        receiveMessage = view.findViewById(R.id.receiveMessage);

        // Initialize chatList if it wasn't initialized
        if (chatList == null) {
            chatList = new ArrayList<>();
        }

        // Set up the adapter and assign the data
        chatAdapter = new ChatAdapter();
        chatAdapter.setData(chatList);
        receiveMessage.setAdapter(chatAdapter);

        // Set LayoutManager to RecyclerView
        receiveMessage.setLayoutManager(new LinearLayoutManager(getContext()));

        button_message.setBackgroundColor(getContext().getResources().getColor(android.R.color.holo_blue_dark));

        button_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        return view;
    }


    private void sendMessage() {
        String stringMessage = textmessage.getText().toString();
        if (TextUtils.isEmpty(stringMessage)){
            return;
        }

        chatList.add(new Chat(stringMessage) );


        chatAdapter.notifyDataSetChanged();
        //to always see the last message we use scrollToPosition
        receiveMessage.scrollToPosition(chatList.size() -1);

        //re-set say something
        textmessage.setText("");
    }
}