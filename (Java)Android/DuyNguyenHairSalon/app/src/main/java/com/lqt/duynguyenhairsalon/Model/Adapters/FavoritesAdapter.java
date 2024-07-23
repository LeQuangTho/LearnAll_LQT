package com.lqt.duynguyenhairsalon.Model.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lqt.duynguyenhairsalon.Model.ItemFavorites;
import com.lqt.duynguyenhairsalon.R;

import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder> {

    private Context context;
    private List<ItemFavorites> itemFavorites;

    public FavoritesAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ItemFavorites> itemFavorites) {
        this.itemFavorites = itemFavorites;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_favorites_grid_recyclerview
                , parent
                , false);
        return new FavoritesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesViewHolder holder, int position) {
        if (holder == null) {
            return;
        }

        ItemFavorites favorites = itemFavorites.get(position);

        holder.imageView.setImageResource(favorites.getImageFavorites());
        holder.textView.setText("" + favorites.getNameFavorites());
    }

    @Override
    public int getItemCount() {
        if (itemFavorites != null) {
            return itemFavorites.size();
        }
        return 0;
    }

    public class FavoritesViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public FavoritesViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_ItemFavorites);
            textView = itemView.findViewById(R.id.textView_ItemFavorites);
        }
    }
}
