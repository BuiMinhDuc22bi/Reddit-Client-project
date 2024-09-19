package vn.edu.usth.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FeedListFragment extends Fragment {

    private ListView feedListView;
    private FeedListAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_feed_list_adapter, container, false);

        feedListView = view.findViewById(R.id.feeds_list_view);

        // Example data for Feed List
        ArrayList<Feed> feedList = new ArrayList<>();
        feedList.add(new Feed("Absolute peak @@", R.drawable.dragon_ball_1));
        feedList.add(new Feed("Can bro cook???", R.drawable.presentation_meme_1));
        feedList.add(new Feed("uga uga uga ???", R.drawable.monkey_1));
        feedList.add(new Feed("quack quack !!!!", R.drawable.duck_1));
        feedList.add(new Feed("chicken.mp3", R.drawable.chiken_1));
        feedList.add(new Feed("Wrong 'kungflu' panda", R.drawable.panda_shock_1));
        feedList.add(new Feed("woof woof woof", R.drawable.dog_shock_1));
        feedList.add(new Feed("meow meow meow!!!", R.drawable.cat_shock_1));
        feedList.add(new Feed("oh my gotto!!!", R.drawable.soc_meme_1));
        feedList.add(new Feed("Damn even bear is scared now !@#$%^&*", R.drawable.bear_schok_2));

        // Setting up the FeedListAdapter for Feed List
        adapter = new FeedListAdapter(getActivity(), feedList);
        feedListView.setAdapter(adapter);

        return view;
    }

}








