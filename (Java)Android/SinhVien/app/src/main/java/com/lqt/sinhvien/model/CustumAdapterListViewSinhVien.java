package com.lqt.sinhvien.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lqt.sinhvien.R;

import java.util.List;
import java.util.zip.Inflater;

public class CustumAdapterListViewSinhVien extends BaseAdapter {
    Context context;
    List<SinhVien> sinhVienList;
    int Layout;

    public CustumAdapterListViewSinhVien(Context context, List<SinhVien> sinhVienList, int layout) {
        this.context = context;
        this.sinhVienList = sinhVienList;
        Layout = layout;
    }

    @Override
    public int getCount() {
        return sinhVienList.size();
    }

    @Override
    public Object getItem(int i) {
        return sinhVienList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(Layout, null);

            holder.textView_Hoten = (TextView) view.findViewById(R.id.TextView_Hoten);
            holder.textView_Namsinh = (TextView) view.findViewById(R.id.TextView_Namsinh);
            holder.textView_Diachi = (TextView) view.findViewById(R.id.TextView_Diachi);

            view.setTag(holder);
        }else
        {
            holder = (ViewHolder) view.getTag();
        }

        SinhVien sinhVien = sinhVienList.get(i);
        holder.textView_Hoten.setText(""+sinhVien.getHoTenSinhVien());
        holder.textView_Namsinh.setText(""+sinhVien.getNamSinhSinhVien());
        holder.textView_Diachi.setText(""+sinhVien.getDiaChiSinhVien());

        return view;
    }

    private class ViewHolder{
        TextView textView_Hoten, textView_Namsinh, textView_Diachi;
    }
}
