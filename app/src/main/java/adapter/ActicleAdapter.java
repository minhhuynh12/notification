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

import model.ActiclerItems;

/**
 * Created by MyPC on 16/09/2017.
 */

public class ActicleAdapter extends RecyclerView.Adapter<ActicleAdapter.ViewHolder> {
    ArrayList<ActiclerItems> acticlerItemsArrayList;
    Context context;

    public ActicleAdapter(ArrayList<ActiclerItems> acticlerItemses){
        acticlerItemsArrayList = acticlerItemses;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_acticlelist_items , parent , false);
        context = parent.getContext();
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvTitle.setText(acticlerItemsArrayList.get(position).title);
        holder.tvURL.setText(acticlerItemsArrayList.get(position).url);
    }

    @Override
    public int getItemCount() {
        return acticlerItemsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle , tvURL;
        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitleActicler);
            tvURL = itemView.findViewById(R.id.tvUrlActicler);
        }
    }
    public void updateList(List<ActiclerItems> items){
        acticlerItemsArrayList = (ArrayList<ActiclerItems>) items;
        notifyDataSetChanged();

    }
}
