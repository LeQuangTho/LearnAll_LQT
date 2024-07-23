package com.lqt.phamvantien_181202290;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PhamVanTien_Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<com.lqt.phamvantien_181202290.HoaDon_PhamVanTien> listData;
    public PhamVanTien_Adapter(Context context, int layout, List<HoaDon_PhamVanTien> listData) {
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
        HoaDon_PhamVanTien hoadon = listData.get(position);
        view = LayoutInflater.from(context).inflate(layout, parent, false);

        TextView textViewTen = view.findViewById(R.id.textView_HoTen);
        TextView textViewSoPhong = view.findViewById(R.id.textView_SoPhong);
        TextView textViewTongTien = view.findViewById(R.id.textView_TongTien);

        textViewTen.setText(hoadon.getHoTenKhach());
        textViewSoPhong.setText("Số phòng: " + hoadon.getSoPhong());
        textViewTongTien.setText("" + (hoadon.getDonGia() * hoadon.getSoNgay()));

        return view;
    }
}
