package com.lqt.ghino.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lqt.ghino.R;
import com.lqt.ghino.model.DichVu;

import java.util.ArrayList;

public class CustomAdapterListDichVu extends BaseAdapter {
    Context context;
    int resource;
    ArrayList<DichVu> listDV;

    public CustomAdapterListDichVu(Context context, int resource, ArrayList<DichVu> listDV) {
        this.context = context;
        this.resource = resource;
        this.listDV = listDV;
    }

    @Override
    public int getCount() {
        return listDV.size();
    }

    @Override
    public Object getItem(int position) {
        return listDV.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, null);

            holder = new ViewHolder();
            holder.textView_TenDV = convertView.findViewById(R.id.TextView_Ten_DV);
            holder.textView_DonGiaDV = convertView.findViewById(R.id.TextView_DonGiaDV);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView_TenDV.setText(listDV.get(position).getTenDichVu());
        holder.textView_DonGiaDV.setText("" + listDV.get(position).getDonGia());
        return convertView;
    }

    private class ViewHolder {
        TextView textView_TenDV, textView_DonGiaDV;
    }
}
