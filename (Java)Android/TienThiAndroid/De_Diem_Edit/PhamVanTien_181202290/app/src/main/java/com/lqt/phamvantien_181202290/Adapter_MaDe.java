package com.lqt.phamvantien_181202290;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter_MaDe extends BaseAdapter{
    private Context context;
    private int layout;
    private List<ThiSinh_13072000> listData;
    private List<ThiSinh_13072000> listDataOld;
    private Filter filter;

    public Adapter_MaDe(Context context, int layout, List<ThiSinh_13072000> listData) {
        this.context = context;
        this.layout = layout;
        this.listData = listData;
        this.listDataOld = listData;
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
        ThiSinh_13072000 thisinh = listData.get(position);
        view = LayoutInflater.from(context).inflate(layout, parent, false);

        TextView textViewHoaTen = view.findViewById(R.id.textView_HoTen);
        TextView textViewSBD = view.findViewById(R.id.textView_SBD);
        TextView textViewTongDiem = view.findViewById(R.id.textView_TongDiem);

        textViewHoaTen.setText(thisinh.getHoTen());
        textViewSBD.setText("" + thisinh.getSBD());
        textViewTongDiem.setText("" + (thisinh.getToan() + thisinh.getLy() + thisinh.getHoa()));

        return view;
    }
}
