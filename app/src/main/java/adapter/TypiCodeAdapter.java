package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mypc.notification.R;

import java.util.ArrayList;
import java.util.List;

import model.Post;

/**
 * Created by MyPC on 14/09/2017.
 */

public class TypiCodeAdapter extends RecyclerView.Adapter<TypiCodeAdapter.ViewHolder> {
    private Context context;
    private List<Post> listPosts;

    public TypiCodeAdapter() {
        listPosts = new ArrayList<>();
    }

    public void addPost(Post post) {
        listPosts.add(post);
    }

    public void addAllPost(List<Post> posts) {
        for (Post post : posts) {
            addPost(post);
        }
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_typicode_items, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TypiCodeAdapter.ViewHolder holder, int position) {
        /*holder.tvUserId.setText(listPosts.get(position).title);
        holder.tvID.setText(listPosts.get(position).title);*/
        holder.tvTitle.setText(listPosts.get(position).title);
        holder.tvBody.setText(listPosts.get(position).body);

    }

    @Override
    public int getItemCount() {
        return listPosts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserId, tvID, tvTitle, tvBody;

        public ViewHolder(View itemView) {
            super(itemView);
            tvUserId = itemView.findViewById(R.id.tvUserIdTypeCode);
            tvID = itemView.findViewById(R.id.tvIdTypiCode);
            tvTitle = itemView.findViewById(R.id.tvTitleTypeCode);
            tvBody = itemView.findViewById(R.id.tvBodyTypiCode);
        }
    }

    public void updateAnswers(List<Post> itemses) {
        notifyDataSetChanged();
    }
}
