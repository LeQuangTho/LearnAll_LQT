package com.lqt.lequangtho;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class OsoAdapter extends ArrayAdapter<Integer> {
    private Context context;
    private ArrayList<Integer> arr;


    public OsoAdapter(@NonNull Context context, int resource, @NonNull List<Integer> objects) {
        super(context, resource, objects);
        this.context = context;
        this.arr = new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_o_vuong, null);
        }
        if (arr.size() > 0) {
            OVuong oVuong = (OVuong) convertView.findViewById(R.id.itemOVuong);
            oVuong.setText("" + arr.get(position));
        }
        return convertView;
    }
}
