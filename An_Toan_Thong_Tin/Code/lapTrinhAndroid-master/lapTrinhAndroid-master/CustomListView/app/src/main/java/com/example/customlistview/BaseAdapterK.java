package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BaseAdapterK extends BaseAdapter implements Filterable {
    private Context context; //context
    private ArrayList<SinhVien> dsSinhVien; //data source of the list adapter

    private CustomFilter filter;
    private ArrayList<SinhVien> filterList;

    public BaseAdapterK(Context context, ArrayList<SinhVien> dsSinhVien) {
        this.context = context;
        this.dsSinhVien = dsSinhVien;
        this.filterList = dsSinhVien;
    }

    @Override
    public int getCount() {
        return dsSinhVien.size();
    }

    @Override
    public Object getItem(int position) {
        return dsSinhVien.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.activity_dong_sinh_vien, null);
        }
        SinhVien p = (SinhVien) getItem(position);
        if (p != null) {
            // Anh xa + Gan gia tri
            TextView textViewFullName = (TextView) view.findViewById(R.id.textViewFullName);
            TextView textViewBirthYear = (TextView) view.findViewById(R.id.textViewBirthYear);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            imageView.setImageResource(p.getImg());
            textViewFullName.setText(p.getFullName());
            textViewBirthYear.setText(p.getBirthYear() + "");

        }
        return view;
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new CustomFilter();
        }
        return filter;
    }

    private class CustomFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                constraint = constraint.toString().toUpperCase();
                ArrayList<SinhVien> arrayList = new ArrayList<SinhVien>();
                for (int i = 0; i < filterList.size(); i++) {
                    if (filterList.get(i).getFullName().toUpperCase().contains(constraint)) {
                        SinhVien sv = new SinhVien(filterList.get(i).getFullName(), filterList.get(i).getBirthYear(), filterList.get(i).getImg());
                        arrayList.add(sv);
                    }
                }
                results.count = arrayList.size();
                results.values = arrayList;
            } else {
                results.count = filterList.size();
                results.values = filterList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            dsSinhVien = (ArrayList<SinhVien>) results.values;
            notifyDataSetChanged();
        }
    }


}
