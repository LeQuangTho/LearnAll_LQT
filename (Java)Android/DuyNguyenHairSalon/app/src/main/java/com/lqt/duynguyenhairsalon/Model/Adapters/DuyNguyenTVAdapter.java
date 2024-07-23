package com.lqt.duynguyenhairsalon.Model.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lqt.duynguyenhairsalon.Activities.Other.PlayVideoYouTubeActivity;
import com.lqt.duynguyenhairsalon.Model.VideoYouTube;
import com.lqt.duynguyenhairsalon.R;

import java.util.List;

/*
 * Đây là adapter ở trong fragmenthome
 * */

public class DuyNguyenTVAdapter extends RecyclerView.Adapter<DuyNguyenTVAdapter.DuyNguyenTVViewHolder> {
    private List<VideoYouTube> mDuyNguyenTV;
    private Context context;

    public DuyNguyenTVAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<VideoYouTube> list) {
        this.mDuyNguyenTV = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DuyNguyenTVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_duy_nguyen_tv, parent, false);
        return new DuyNguyenTVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DuyNguyenTVViewHolder holder, int position) {
        VideoYouTube videoYouTube = mDuyNguyenTV.get(position);
        if (videoYouTube == null) {
            return;
        }
        Glide.with(context).load(mDuyNguyenTV.get(position).getThumbnail()).into(holder.imageViewDuyNguyenTV);
        holder.textView.setText(mDuyNguyenTV.get(position).getTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayVideoYouTubeActivity.class);
                intent.putExtra("ID_VIDEO", mDuyNguyenTV.get(position).getIdVideo());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mDuyNguyenTV != null) return mDuyNguyenTV.size();
        return 0;
    }

    public class DuyNguyenTVViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewDuyNguyenTV;
        private CardView cardView;
        private TextView textView;

        public DuyNguyenTVViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewDuyNguyenTV = itemView.findViewById(R.id.imageView_DuyNguyenTV);
            cardView = itemView.findViewById(R.id.cardView);
            textView = itemView.findViewById(R.id.textView_DuyNguyenTV);
        }
    }
}
