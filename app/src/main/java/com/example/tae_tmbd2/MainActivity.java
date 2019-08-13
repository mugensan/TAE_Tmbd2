package com.example.tae_tmbd2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

//import com.example.tae_tmbd2.model;

//import com.example.tae_tmbd2.model.result;
import com.example.tae_tmbd2.model.TmbdPopularModel;
import com.example.tae_tmbd2.network.RetrofitInstance;

import java.util.List;

import javax.security.auth.login.LoginException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_popular_list;
    private TmdbAdaptor adaptor;

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_popular_list = findViewById(R.id.rv_popular_list);

        TmdbClient tmdbClient = RetrofitInstance.getRetrofitInstance().create(TmdbClient.class);
        Call<TmbdPopularModel> call = tmdbClient.getRepos("1345e1dd35f900792734afba370eec11");

        call.enqueue(new Callback<TmbdPopularModel>() {
            @Override
            public void onResponse(Call<TmbdPopularModel> call, Response<TmbdPopularModel> response) {
                TmbdPopularModel tmbdPopularModel =response.body();


                Log.i(TAG, "onResponse: " +tmbdPopularModel.getResults().get(0).getTitle());
            }

            @Override
            public void onFailure(Call<TmbdPopularModel> call, Throwable t) {
                Log.i(TAG, "onFailure: "+t.getMessage());
            }
        });

    }
}
