package com.lqt.lequangtho_181202289;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.List;
//Bài 3 Ảnh 3
public class Adapter_181202289 extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Taxi_LeQuangTho> listTaxi;
    public Adapter_181202289(Context context, int layout, List<Taxi_LeQuangTho> listTaxi) {
        this.context = context;
        this.layout = layout;
        this.listTaxi = listTaxi;
    }
    @Override
    public int getCount() {
        return listTaxi.size();
    }
    @Override
    public Object getItem(int position) {
        return listTaxi.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(context).inflate(layout, parent, false);

        TextView textViewSoXe = view.findViewById(R.id.textView_SoXe);
        TextView textViewQuangDuong = view.findViewById(R.id.textView_QuangDuong);
        TextView textViewTongTien = view.findViewById(R.id.textView_TongTien);

        Taxi_LeQuangTho taxi = listTaxi.get(position);

        textViewSoXe.setText(taxi.getSoXe());
        textViewQuangDuong.setText("" + taxi.getQuangDuong());
        textViewTongTien.setText(String.format("%.3f",(taxi.getDonGia() * taxi.getQuangDuong() * (100 - taxi.getKhuyenMai()) / 100)));

        return view;
    }
}
