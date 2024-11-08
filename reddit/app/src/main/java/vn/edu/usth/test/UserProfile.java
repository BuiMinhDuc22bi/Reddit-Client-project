package vn.edu.usth.test;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class UserProfile extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        // Get the current theme mode from SharedPreferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isDarkMode = preferences.getBoolean("isDarkMode", false);

        // Apply the saved theme mode
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES); // Dark mode
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); // Light mode
        }

        // Initialize the TabLayout and ViewPager
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager2 viewPager = findViewById(R.id.view_pager);

        UserPagerAdapter adapter = new UserPagerAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText(R.string.Gallery);
                            break;
                        case 1:
                            tab.setText(R.string.News);
                            break;
                        case 2:
                            tab.setText(R.string.friends);
                            break;
                    }
                }).attach();

        // Initialize the DrawerLayout and Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Setup ActionBarDrawerToggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Set Navigation Item Selected Listener
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                if (item.getItemId() == R.id.nav_change_theme) {
                    // Handle Change Theme menu click
                    toggleTheme();
                    drawerLayout.closeDrawer(GravityCompat.START); // Close the drawer
                    return true;
                }
                return false;
            }
        });

        // Initialize Bottom Navigation View
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                if (item.getItemId() == R.id.navigation_Home) {
                    selectedFragment = new HomeFragment();
                } else if (item.getItemId() == R.id.navigation_Communities) {
                    selectedFragment = new CommunitiesFragment();
                } else if (item.getItemId() == R.id.navigation_Create) {
                    selectedFragment = new CreateFragment();
                } else if (item.getItemId() == R.id.navigation_Chat) {
                    selectedFragment = new ChatFragment();
                } else if (item.getItemId() == R.id.navigation_Inbox) {
                    selectedFragment = new InboxFragment();
                }

                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, selectedFragment)
                            .addToBackStack(null)  // Add this transaction to the back stack
                            .commit();
                    return true;
                }
                return false;
            }

        });
    }

    // Method to toggle theme
    private void toggleTheme() {
        // Get the current theme mode from SharedPreferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isDarkMode = preferences.getBoolean("isDarkMode", false);

        // Toggle between light and dark mode
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); // Switch to light theme
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES); // Switch to dark theme
        }

        // Save the new theme mode to SharedPreferences
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isDarkMode", !isDarkMode); // Save the new state
        editor.apply();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            // Pop the back stack
            getSupportFragmentManager().popBackStack();
        } else {
            // No fragments in back stack, so finish activity
            super.onBackPressed();
        }
    }
}
