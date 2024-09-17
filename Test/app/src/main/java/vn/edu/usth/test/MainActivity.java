package vn.edu.usth.test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        // Get the Login button and set an onClick listener
        Button loginButton = findViewById(R.id.login_button);  // Assuming login_button is the ID of your button

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When the login button is clicked, navigate to UserProfileActivity
                Intent intent = new Intent(MainActivity.this, UserProfile.class);
                startActivity(intent);
            }
        });


    }

    public MainActivity() {
        super();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Reddit", "onStart here");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Reddit", "onStop here");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Reddit", "onDestroy here");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Reddit", "onPause here");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Reddit", "onResume here");
    }
}
