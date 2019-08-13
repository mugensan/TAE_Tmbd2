package com.example.tae_tmbd2;

//import com.example.tae_tmbd2.model.result;

import com.example.tae_tmbd2.model.TmbdPopularModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TmdbClient {

//    String api_key = "1345e1dd35f900792734afba370eec11";

    @GET("movie/popular")
//    Call<List<TmbdPopularModel>>getRepos(@Query("api_key") String api_key);
   // Call<TmdbPopularModel> getRepos(@Query("api_key") String api_key);
    Call<TmbdPopularModel> getRepos(@Query("api_key") String api_key);
}
