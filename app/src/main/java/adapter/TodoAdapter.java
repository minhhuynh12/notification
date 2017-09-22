package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mypc.notification.R;

import java.util.ArrayList;
import java.util.List;

import model.TodoItems;
import model.TodoResponseItems;

/**
 * Created by MyPC on 21/09/2017.
 */

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder>{
    List<TodoItems> todoItemsArrayList;
    Context context;
    public TodoAdapter (List<TodoItems> todoItemses, OnItemsListener onItemsListener){
        todoItemsArrayList = todoItemses;
        this.onItemsListener = onItemsListener;

    }
    @Override
    public TodoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_todo_json_items, parent , false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TodoAdapter.ViewHolder holder, final int position) {
        holder.txtIdTodo.setText(todoItemsArrayList.get(position).title);
        holder.txtIdTodo.setText(todoItemsArrayList.get(position).title);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemsListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return todoItemsArrayList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitleTodo;
        TextView txtIdTodo;

        public ViewHolder(View itemView) {
            super(itemView);
            txtIdTodo = itemView.findViewById(R.id.txtIdTodo);
            txtTitleTodo = itemView.findViewById(R.id.txtTitleTodo);
        }
    }
    public void update(List<TodoItems> items){
        todoItemsArrayList = (ArrayList<TodoItems>) items;
        notifyDataSetChanged();

    }

    public interface OnItemsListener{
         void onClick(int pos);
    }
    OnItemsListener onItemsListener;
}
