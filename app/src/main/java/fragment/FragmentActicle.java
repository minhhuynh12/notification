package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypc.notification.R;

import java.util.ArrayList;
import java.util.List;

import adapter.ActicleAdapter;
import model.ActiclerItems;
import model.ActiclerResponseItems;
import model.ComicItems;
import remote.ApiServiceActicler;
import remote.ApiUtilsActicler;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MyPC on 16/09/2017.
 */

public class FragmentActicle extends BaseFragment {
    ActicleAdapter mAdapter;
    RecyclerView mRecyclerView;
    ApiServiceActicler mService;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_acticlelist, null);
        mRecyclerView = view.findViewById(R.id.recyclerActicle);



        mService = ApiUtilsActicler.getService();




        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new ActicleAdapter(new ArrayList<ActiclerItems>());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        load();

        return view;
    }

    public void load(){
        mService.getListResponse().enqueue(new Callback<ActiclerResponseItems>() {
            @Override
            public void onResponse(Call<ActiclerResponseItems> call, Response<ActiclerResponseItems> response) {
                List<ActiclerItems> list = response.body().getList;
                mAdapter.updateList(list);
            }

            @Override
            public void onFailure(Call<ActiclerResponseItems> call, Throwable t) {
                Log.d("fail", t.toString());
            }
        });
    }
}
