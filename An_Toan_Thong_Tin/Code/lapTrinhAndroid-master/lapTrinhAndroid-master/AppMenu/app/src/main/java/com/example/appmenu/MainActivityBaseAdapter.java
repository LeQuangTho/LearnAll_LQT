package com.example.appmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivityBaseAdapter extends BaseAdapter implements Filterable {
    private ArrayList<BaiTap> arrBaiTap;
    private Context context;

    private ArrayList<BaiTap> arrFilterBaiTap;
    private CustomeFilter customeFilter;

    public MainActivityBaseAdapter(ArrayList<BaiTap> arrBaiTap, Context context) {
        this.arrBaiTap = arrBaiTap;
        this.context = context;
        this.arrFilterBaiTap = arrBaiTap;
    }

    @Override
    public int getCount() {
        return arrBaiTap.size();
    }

    @Override
    public Object getItem(int position) {
        return arrBaiTap.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.item_bai_tap, null);
        }
        BaiTap bt = (BaiTap) getItem(position); // ép kiểu
        if (bt != null) {
            //Ánh xạ
            TextView textViewName = (TextView) view.findViewById(R.id.textViewName);
            TextView textViewNgayLam = (TextView) view.findViewById(R.id.textViewNgayLam);
            textViewName.setText(bt.getName());
            textViewNgayLam.setText(bt.getNgayLam());
        }
        return view;
    }


    @Override
    public Filter getFilter() {
        if (customeFilter == null) {
            customeFilter = new CustomeFilter();
        }
        return customeFilter;
    }

    private class CustomeFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                constraint = constraint.toString().toUpperCase();
                ArrayList<BaiTap> arrayList = new ArrayList<BaiTap>();
                for (int i = 0; i < arrFilterBaiTap.size(); i++) {
                    if (arrFilterBaiTap.get(i).getName().toUpperCase().contains(constraint)) {
                        BaiTap bt = new BaiTap(arrFilterBaiTap.get(i).getName(), arrFilterBaiTap.get(i).getNgayLam());
                        arrayList.add(bt);
                    }
                }
                results.count = arrayList.size();
                results.values = arrayList;
            } else {
                results.count = arrFilterBaiTap.size();
                results.values = arrFilterBaiTap;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            arrBaiTap = (ArrayList<BaiTap>) results.values;
            notifyDataSetChanged();
        }
    }


}
