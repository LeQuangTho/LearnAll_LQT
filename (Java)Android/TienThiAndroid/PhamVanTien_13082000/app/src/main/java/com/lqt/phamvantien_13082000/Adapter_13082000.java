package com.lqt.phamvantien_13082000;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;
//Bài 3 Ảnh 2
public class Adapter_13082000 extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Taxi_13082000> listData;
    public Adapter_13082000(Context context, int layout, List<Taxi_13082000> listData) {
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
        Taxi_13082000 taxi = listData.get(position);
        textViewSoXe.setText(taxi.getSoXe());
        textViewQuangDuong.setText(String.format(Locale.US, "Quãng đường: %.3f",taxi.getQuangDuong()));
        textViewTongTien.setText(String.format(Locale.US, "%.3f",(taxi.getDonGia() * taxi.getQuangDuong() * (100 - taxi.getKhuyenMai()) / 100)));
        return view;
    }
}
