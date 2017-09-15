package fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypc.notification.R;
import com.google.android.gms.common.api.Api;

import java.util.List;

import adapter.TypiCodeAdapter;
import model.Post;
import remote.ApiServer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MyPC on 14/09/2017.
 */

public class FragmentTypiCode extends BaseFragment {
    private TypiCodeAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        ArrayList<Post> typiCodeItemsesList = new ArrayList<>();
//        typiCodeItemsesList.add(new Post("1", "2", "Minh Huynh", "Huynh Minh"));
//        typiCodeItemsesList.add(new Post("1", "2", "Minh Huynh", "Huynh Minh"));
//        typiCodeItemsesList.add(new Post("1", "2", "Minh Huynh", "Huynh Minh"));
//        typiCodeItemsesList.add(new Post("1", "2", "Minh Huynh", "Huynh Minh"));

        View view = inflater.inflate(R.layout.fragemnt_typicode, null);

        mRecyclerView = view.findViewById(R.id.recyclerTypiCode);

        loadApi();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new TypiCodeAdapter();
        mRecyclerView.setAdapter(mAdapter);

        return view.getRootView();
    }

    private void loadApi() {
        Call<List<Post>> listCall = ApiServer.getApiService().getListPost();
        listCall.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    mAdapter.addAllPost(response.body());
                } else {
                    int responeCode = response.code();
                    // Check
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {

            }
        });

    }

    private void loadDetailPost(int id) {
        Call<Post> callPost = ApiServer.getApiService().getPostDetail(id);
        callPost.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                Post post = response.body();
//                tvTitle.setText(post.title);
            }

            @Override
            public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {

            }
        });
    }


}
