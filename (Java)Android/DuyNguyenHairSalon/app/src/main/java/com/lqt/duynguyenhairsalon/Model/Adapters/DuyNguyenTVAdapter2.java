package com.lqt.duynguyenhairsalon.Model.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lqt.duynguyenhairsalon.Activities.Other.PlayVideoYouTubeActivity;
import com.lqt.duynguyenhairsalon.Model.VideoYouTube;
import com.lqt.duynguyenhairsalon.R;

import java.util.List;

/*
 * Đây là adapter ở trong Play List
 * */
public class DuyNguyenTVAdapter2 extends RecyclerView.Adapter<DuyNguyenTVAdapter2.DuyNguyenTVPlayListViewHolder> {

    private List<VideoYouTube> playList;
    private Context context;

    public DuyNguyenTVAdapter2(Context context) {
        this.context = context;
    }

    public void setData(List<VideoYouTube> playList) {
        this.playList = playList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DuyNguyenTVPlayListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_play_list_video_youtube
                , parent
                , false);

        return new DuyNguyenTVPlayListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DuyNguyenTVPlayListViewHolder holder, int position) {
        VideoYouTube videoYouTube = playList.get(position);
        if (videoYouTube == null) {
            return;
        }

        Glide.with(context).load(videoYouTube.getThumbnail()).into(holder.imageViewThum);
        holder.textViewTitle.setText(videoYouTube.getTitle());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayVideoYouTubeActivity.class);
                intent.putExtra("ID_VIDEO", playList.get(position).getIdVideo());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (playList != null) {
            return playList.size();
        }
        return 0;
    }

    public class DuyNguyenTVPlayListViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewThum;
        TextView textViewTitle;
        ConstraintLayout constraintLayout;

        public DuyNguyenTVPlayListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewThum = itemView.findViewById(R.id.imageView_Thumnail);
            textViewTitle = itemView.findViewById(R.id.textView_Title);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
        }
    }
}
