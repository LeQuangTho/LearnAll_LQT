package com.lqt.phamvantien_181202290;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

//Bài 3 Ảnh 3
public class Adapter_181202290 extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Taxi_PhamVanTien> listData;
    public Adapter_181202290(Context context, int layout, List<Taxi_PhamVanTien> listData) {
        this.context = context;
        this.layout = layout;
        this.listData = listData;
    }
    @Override
    public int getCount() {
        return listData.size();
    }
    @Override
    public Object getItem(int position) {
        return listData.get(position);
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

        Taxi_PhamVanTien taxi = listData.get(position);

        textViewSoXe.setText(taxi.getSoXe());
        textViewQuangDuong.setText("" + taxi.getQuangDuong());
        textViewTongTien.setText(String.format(Locale.US, "%.3f",(taxi.getDonGia() * taxi.getQuangDuong() * (100 - taxi.getKhuyenMai()) / 100)));

        return view;
    }
}
