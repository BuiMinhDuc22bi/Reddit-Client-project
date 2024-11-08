package vn.edu.usth.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private ListView listView;
    private GalleryAdapter postAdapter;
    private List<Item> postList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery_layout, container, false);

        listView = view.findViewById(R.id.gallery_list_view);

        postList = new ArrayList<>();
        postAdapter = new GalleryAdapter(getContext(), postList);
        listView.setAdapter(postAdapter);

        fetchData();

        return view;
    }

    private void fetchData() {
        String url = "https://pixabay.com/api/?key=46961969-8c8e5132f44a616678335370a&q=animal&image_type=photo&pretty=true";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String imageUrl = jsonObject.getString("webformatURL");
                                int likes = jsonObject.getInt("likes");
                                String tags = jsonObject.getString("tags");

                                Item post = new Item(imageUrl, tags, likes);
                                postList.add(post);
                            }

                            postAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // Initialize requestQueue if not already initialized
        Volley.newRequestQueue(getContext()).add(jsonObjectRequest);
    }
}
