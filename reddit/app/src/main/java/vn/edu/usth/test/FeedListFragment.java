package vn.edu.usth.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import androidx.fragment.app.Fragment;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import com.kwabenaberko.newsapilib.models.Article;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FeedListFragment extends Fragment {

    private ListView feedListView;
    private FeedListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_feed_list_adapter, container, false);
        feedListView = view.findViewById(R.id.feeds_list_view);

        // Initialize the adapter
        adapter = new FeedListAdapter(getContext());
        feedListView.setAdapter(adapter);

        // Fetch the articles
        fetchArticles();

        return view;
    }

    private void fetchArticles() {
        Retrofit retrofit = RetrofitClient.getInstance();
        NewsApiService apiService = retrofit.create(NewsApiService.class);
        Call<ArticleResponse> call = apiService.getArticles("anime", "43538acc152c408887abc9bf4e716091");

        call.enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Transform the News API's Article objects into your custom Article objects
                    List<vn.edu.usth.test.Article> articles = new ArrayList<>();
                    for (com.kwabenaberko.newsapilib.models.Article apiArticle : response.body().getArticles()) {
                        vn.edu.usth.test.Article customArticle = new vn.edu.usth.test.Article();
                        customArticle.setTitle(apiArticle.getTitle());
                        customArticle.setDescription(apiArticle.getDescription());
                        customArticle.setUrl(apiArticle.getUrl());
                        customArticle.setUrlToImage(apiArticle.getUrlToImage());

                        articles.add(customArticle);
                    }

                    // Set the transformed list to the adapter
                    adapter.setFeeds(articles);
                } else {
                    Toast.makeText(getActivity(), "Failed to fetch articles", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}