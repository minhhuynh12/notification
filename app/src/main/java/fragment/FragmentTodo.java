package fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypc.notification.FragmentInteraction;
import com.example.mypc.notification.R;

import java.util.ArrayList;
import java.util.List;

import adapter.TodoAdapter;
import extras.Enumes;
import model.TodoItems;

import model.TodoResponseItems;
import remote.ApiServerTodo;
import remote.ApiServiceTodo;
import remote.ApiUtilsTodo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MyPC on 21/09/2017.
 */

public class FragmentTodo extends BaseFragment {
    RecyclerView mRecyclerView;
    TodoAdapter mAdapter;
    ApiServiceTodo mService;
    FragmentInteraction mInteraction;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todo_json, null);
        mRecyclerView = view.findViewById(R.id.recyclerTodo);

        load();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);


        return view;
    }

    private void load() {
        mService = ApiUtilsTodo.getServiceTodo();
        mService.getListRepsonseTodo().enqueue(new Callback<List<TodoItems>>() {
            @Override
            public void onResponse(Call<List<TodoItems>> call, final Response<List<TodoItems>> response) {

                //mAdapter.update(response.body());
                mAdapter = new TodoAdapter(response.body(), new TodoAdapter.OnItemsListener() {
                    @Override
                    public void onClick(int pos) {

//                        response.body().get(pos).id.valueOf();

                        Bundle bundle = new Bundle();
                        bundle.putString("id", response.body().get(pos).id.toString());
                        mInteraction.openFragmnet(Enumes.FragmentType.FRAGMENT_TODOBYID, bundle , Enumes.Direction.RIGHT_IN);

                    }
                });
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<TodoItems>> call, Throwable t) {

            }
        });
    }

//    public void loadDataID(int id) {
//        mService = ApiUtilsTodo.getServiceTodo().getListRepsonseTodoById()
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mInteraction = (FragmentInteraction) context;
    }
}
