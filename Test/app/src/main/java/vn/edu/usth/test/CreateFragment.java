package vn.edu.usth.test;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.zip.Inflater;


public class CreateFragment extends Fragment {

    private TextInputEditText titleInput;
    private TextInputEditText bodyInput;
    private Button nextButton;


    @Override
    public View onCreateView(LayoutInflater  inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_create, container,false);

        // Get the current theme mode from SharedPreferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean isDarkMode = preferences.getBoolean("isDarkMode", false);

        // Set the background color based on the theme
        if (isDarkMode) {
            view.setBackgroundColor(getResources().getColor(android.R.color.black)); // Dark mode background
        } else {
            view.setBackgroundColor(getResources().getColor(android.R.color.white)); // Light mode background
        }

        // Initialize the views!
        titleInput = view.findViewById(R.id.title_input);
        bodyInput = view.findViewById(R.id.body_input);
        nextButton = view.findViewById(R.id.next_button);

        nextButton.setBackgroundColor(getContext().getResources().getColor(android.R.color.holo_blue_dark));


        // Set click listener for the Next button
        nextButton.setOnClickListener(v -> {
            // Clear the text in both fields by making it blank
            titleInput.setText("");
            bodyInput.setText("");

            // Show a Toast to simulate "send" action
            Toast.makeText(getContext(), "Your post has been sent!", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}