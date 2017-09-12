package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mypc.notification.R;

import java.util.List;

import model.ComicItems;

/**
 * Created by MyPC on 10/09/2017.
 */

public class ApiComicAdapter extends RecyclerView.Adapter<ApiComicAdapter.ViewHolder> {
    private List<ComicItems> comicItemsList;
    private Context context;

    public ApiComicAdapter(Context context , List<ComicItems> posts ){
        comicItemsList = posts;
        context = context;
    }

    @Override
    public ApiComicAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.load_api_comic_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(postView , this.comicItemsList);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ApiComicAdapter.ViewHolder holder, int position) {
        holder.tvTitleComic.setText(comicItemsList.get(position).title);
        holder.tvAuthorComic.setText(comicItemsList.get(position).author);
        holder.tvStatusComic.setText(comicItemsList.get(position).status);
        holder.tvTranslotorsComic.setText(comicItemsList.get(position).translators);
    }

    @Override
    public int getItemCount() {
        return comicItemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitleComic;
        TextView tvAuthorComic;
        TextView tvStatusComic;
        TextView tvTranslotorsComic;

        public ViewHolder(View itemView, List<ComicItems> comicItemsList) {
            super(itemView);
            tvTitleComic = itemView.findViewById(R.id.tvTitleComic);
            tvAuthorComic = itemView.findViewById(R.id.tvAuthorComic);
            tvStatusComic = itemView.findViewById(R.id.tvStatusComic);
            tvTranslotorsComic = itemView.findViewById(R.id.tvTranslotorsComic);
        }
    }
    public void updateAnswers(List<ComicItems> items) {
        comicItemsList = items;
        notifyDataSetChanged();
    }

}
