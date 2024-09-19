package vn.edu.usth.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class CommunitiesFragment extends Fragment {

    private ListView communitiesListView;
    private CommunityListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_communities, container, false);

        communitiesListView = view.findViewById(R.id.community_list_view);

        // Example data for Communities List
        ArrayList<Community> communitiesList = new ArrayList<>();
        communitiesList.add(new Community("DataScience ", "1,2M members", R.drawable.datascience_1));
        communitiesList.add(new Community("intj ", "9M members", R.drawable.intj_1));
        communitiesList.add(new Community("Leagueoflegends ", "2M members", R.drawable.lol_1));
        communitiesList.add(new Community("doge memes", "888K members", R.drawable.doge_meme));
        communitiesList.add(new Community("askReddit ", "760K members", R.drawable.ask_reddit_1));
        communitiesList.add(new Community("pics ", "624K members", R.drawable.gallery_1));
        communitiesList.add(new Community("funny ", "400K members", R.drawable.funny_1));
        communitiesList.add(new Community("Music ", "208K members", R.drawable.music_1));
        communitiesList.add(new Community("gaming  ","187K members", R.drawable.gaming_1));
        communitiesList.add(new Community("health care", "120K members", R.drawable.healt_care_1));
        communitiesList.add(new Community("Art", "98K members", R.drawable.art_1));
        communitiesList.add(new Community("Anime and cosplay", "64K members", R.drawable.anime_1));
        communitiesList.add(new Community("pokemon", "10k members", R.drawable.pokemon_1));
        communitiesList.add(new Community("NintendoSwitch", "7,1M members", R.drawable.nintendo_switch_icon_1));


        // Initialize the adapter and set it to the ListView
        adapter = new CommunityListAdapter(getActivity(), communitiesList);
        communitiesListView.setAdapter(adapter);

        return view;
    }
}