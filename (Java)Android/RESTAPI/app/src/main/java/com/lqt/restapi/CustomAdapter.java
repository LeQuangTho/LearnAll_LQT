package com.lqt.restapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomHolder>{
    List<Khach> khaches;
    Context context;

    public CustomAdapter(Context context) {
        this.context = context;
    }

    void setData(List<Khach> khaches){
        this.khaches = khaches;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate( R.layout.item_khach,parent,false);
        return new CustomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position) {
        Khach khach = khaches.get(position);

        if (khach == null){
            return;
        }

        holder.textViewName.setText(""+khach.getName());
        holder.textViewDiaChi.setText(""+khach.getAddress());
        holder.textViewSDT.setText(""+khach.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        if (khaches != null){
            return khaches.size();
        }
        return 0;
    }

    public class CustomHolder extends RecyclerView.ViewHolder{
        TextView textViewName, textViewDiaChi, textViewSDT;
        public CustomHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.textView_Name);
            textViewDiaChi = (TextView) itemView.findViewById(R.id.textView_DiaChi);
            textViewSDT = (TextView) itemView.findViewById(R.id.textView_SDT);
        }
    }
}
