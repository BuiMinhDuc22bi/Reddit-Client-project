package vn.edu.usth.test;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class UserPagerAdapter extends FragmentStateAdapter {

    public UserPagerAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FeedListFragment();
            case 1:
                return new FriendListFragment();
            case 2:
                return  new GalleryFragment();

            default:
                return new FeedListFragment(); // Default fragment
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
