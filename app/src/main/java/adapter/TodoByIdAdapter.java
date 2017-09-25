package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mypc.notification.R;

import java.util.List;

import model.TodoItems;

/**
 * Created by MyPC on 22/09/2017.
 */

public class TodoByIdAdapter extends RecyclerView.Adapter<TodoByIdAdapter.ViewHolder> {
    TodoItems todoItemsList;
    Context context;
    public TodoByIdAdapter(TodoItems items ){
        todoItemsList = items;
    }

    @Override
    public TodoByIdAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_todo_byid_items , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TodoByIdAdapter.ViewHolder holder, int position) {
        holder.tvIDTodoById.setText(todoItemsList.id);
        holder.tvUserIDTodoByID.setText(todoItemsList.userId);
        holder.tvTitleTodoById.setText(todoItemsList.title);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserIDTodoByID , tvIDTodoById , tvTitleTodoById;
        public ViewHolder(View itemView) {
            super(itemView);
            tvUserIDTodoByID = itemView.findViewById(R.id.tvUserIDTodoByID);
            tvIDTodoById = itemView.findViewById(R.id.tvIDTodoById);
            tvTitleTodoById = itemView.findViewById(R.id.tvTitleTodoById);
        }
    }
}
