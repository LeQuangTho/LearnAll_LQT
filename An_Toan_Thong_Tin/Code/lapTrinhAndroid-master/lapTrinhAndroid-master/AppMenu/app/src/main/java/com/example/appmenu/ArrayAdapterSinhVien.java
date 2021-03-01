package com.example.appmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ArrayAdapterSinhVien extends ArrayAdapter<SinhVien> {
    public ArrayAdapterSinhVien( Context context, int resource,  List<SinhVien> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.item_sinh_vien,null);
        }
        SinhVien sv = getItem(position);
        if(sv != null){
            // Ánh xạ
            TextView textViewFullName = (TextView) view.findViewById(R.id.textViewFullName);
            TextView textViewBirthYear = (TextView) view.findViewById(R.id.textViewBirthYear);
            textViewFullName.setText(sv.getFullName());
            textViewBirthYear.setText(sv.getBirthYear() + "");
        }
        return view;
    }
}
