package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<SinhVien> implements Filterable {
    public ListAdapter(Context context, int resource, List<SinhVien> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.activity_dong_sinh_vien, null);
        }
        SinhVien sv = getItem(position);
        if (sv != null) {
            TextView textViewFullName = (TextView) view.findViewById(R.id.textViewFullName);
            TextView textViewBirthYear = (TextView) view.findViewById(R.id.textViewBirthYear);
            textViewFullName.setText(sv.getFullName());
            textViewBirthYear.setText(sv.getBirthYear() + "");
        }
        return view;
    }
}
