package vn.edu.usth.test;

import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApiService {

    @GET("everything")
    Call<ArticleResponse> getArticles(
            @Query("q") String query, // Search query parameter
            @Query("apiKey") String apiKey // Your API Key
    );
}