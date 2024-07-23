package com.lqt.tienpham_made;
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

public class Adapter_MaDe extends BaseAdapter implements Filterable {
    private Context context;
    private int layout;
    private List<HoaDon_13072000> listData;
    private List<HoaDon_13072000> listDataOld;
    private Filter filter;

    public Adapter_MaDe(Context context, int layout, List<HoaDon_13072000> listData) {
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
        HoaDon_13072000 hoadon = listData.get(position);
        view = LayoutInflater.from(context).inflate(layout, parent, false);

        TextView textViewTen = view.findViewById(R.id.textView_HoTen);
        TextView textViewSoPhong = view.findViewById(R.id.textView_SoPhong);
        TextView textViewTongTien = view.findViewById(R.id.textView_TongTien);

        textViewTen.setText(hoadon.getHoTenKhach());
        textViewSoPhong.setText("Số phòng: " + hoadon.getSoPhong());
        textViewTongTien.setText("" + (hoadon.getDonGia() * hoadon.getSoNgay()));

        return view;
    }

    @Override
    public Filter getFilter() {
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                String keySearch = constraint.toString();
//                if (keySearch.isEmpty()) {
//                    listData = listDataOld;
//                } else {
//                    int sum = Integer.parseInt(keySearch);
//                    List<HoaDon_13072000> listSearch = new ArrayList<>();
//                    for (HoaDon_13072000 hoadon : listData) {
//                        if((hoadon.getDonGia() * hoadon.getSoNgay()) >sum){
//                            listSearch.add(hoadon);
//                        }
//                    }
//                    listData = listSearch;
//                }
//
//                FilterResults results = new FilterResults();
//                results.values = listData;
//
//                return results;
//            }
//
//            @Override
//            protected void publishResults(CharSequence constraint, FilterResults results) {
//                listData = (List<HoaDon_13072000>) results.values;
//                notifyDataSetChanged();
//            }
//        };
        if(filter == null)
            filter = new MyFilter();
        return filter;
    }

    private class MyFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String keySearch = constraint.toString();
            if (keySearch.isEmpty()) {
                listData = listDataOld;
            } else {
                int sum = Integer.parseInt(keySearch);
                List<HoaDon_13072000> listSearch = new ArrayList<>();
                for (HoaDon_13072000 hoadon : listDataOld) {
                    if((hoadon.getDonGia() * hoadon.getSoNgay()) >sum){
                        listSearch.add(hoadon);
                    }
                }
                listData = listSearch;
            }

            FilterResults results = new FilterResults();
            results.values = listData;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listData = (List<HoaDon_13072000>) results.values;
            notifyDataSetChanged();
        }
    }
}
