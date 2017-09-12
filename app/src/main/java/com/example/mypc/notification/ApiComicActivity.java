package com.example.mypc.notification;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import adapter.ApiComicAdapter;
import model.ComicItems;
import model.ComicResponse;
import remote.ApiUtils;
import remote.SOService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MyPC on 10/09/2017.
 */

public class ApiComicActivity extends Activity {
    private ApiComicAdapter apiComicAdapter;
    private RecyclerView recyclerView;
    private SOService mService;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_api_comic);
        mService = ApiUtils.getSOService();
        recyclerView = findViewById(R.id.recyclerComic);
        apiComicAdapter = new ApiComicAdapter(this , new ArrayList<ComicItems>(0));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(apiComicAdapter);
        recyclerView.setHasFixedSize(true);

        loadApi();

    }

    private void loadApi() {
        mService.getAnswersObjects().enqueue(new Callback<ComicResponse>() {
            @Override
            public void onResponse(Call<ComicResponse> call, Response<ComicResponse> response) {
                List<ComicItems> list = response.body().comicItemses;
                apiComicAdapter.updateAnswers(list);

            }

            @Override
            public void onFailure(Call<ComicResponse> call, Throwable t) {
                Log.d("MainActivity1", t.toString());
            }
        });

    }
}
