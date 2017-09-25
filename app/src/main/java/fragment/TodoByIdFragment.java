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

import adapter.TodoByIdAdapter;
import model.TodoItems;
import remote.ApiServiceTodo;
import remote.ApiUtilsTodo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MyPC on 22/09/2017.
 */

public class TodoByIdFragment extends BaseFragment {
    TodoByIdAdapter mAdapter;
    RecyclerView mRecyclerView;
    ApiServiceTodo mService;
    String value;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todo_byid , null);
        mRecyclerView = view.findViewById(R.id.recyclerTodoByID);

        Bundle bundle = this.getArguments();
        value = bundle.getString("User_id");

        loadApiQuery(value);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    private void loadApiQuery(String value) {
        Log.d("Aaaaa" , "value " + value);
        mService = ApiUtilsTodo.getServiceTodo();
        mService.getListResponseQuery(value).enqueue(new Callback<List<TodoItems>>() {
            @Override
            public void onResponse(Call<List<TodoItems>> call, Response<List<TodoItems>> response) {
                mAdapter = new TodoByIdAdapter(response.body());
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<TodoItems>> call, Throwable t) {

            }
        });
    }

    private void loadApi(String value) {
        mService = ApiUtilsTodo.getServiceTodo();
        mService.getListRepsonseTodoById(value).enqueue(new Callback<TodoItems>() {
            @Override
            public void onResponse(Call<TodoItems> call, Response<TodoItems> response) {
                Log.d("aaaaa" , "dsdsdsdsdd");
//                mAdapter = new TodoByIdAdapter(response.body());
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<TodoItems> call, Throwable t) {

            }


        });
    }

}
