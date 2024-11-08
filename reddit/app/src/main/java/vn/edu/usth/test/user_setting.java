package vn.edu.usth.test;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.core.content.ContextCompat; // Ensure this import is added

public class user_setting extends Fragment {

    // Track status here, outside of the OnClickListener
    private boolean isOnline = true; // Default to online

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_setting, container, false);




        return view;
    }
}
