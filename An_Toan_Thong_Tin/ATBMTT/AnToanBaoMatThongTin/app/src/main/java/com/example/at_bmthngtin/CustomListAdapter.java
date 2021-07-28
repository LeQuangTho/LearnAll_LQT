package com.example.at_bmthngtin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomListAdapter extends ArrayAdapter<itemMenu> {
    public CustomListAdapter(@NonNull Context context, int resource, @NonNull List<itemMenu> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.activity_menu_item,null);
        }
        itemMenu item = getItem(position);
        if (item != null){
            TextView textView = (TextView) view.findViewById(R.id.textViewName);
            textView.setText(item.getName() + "");
        }
        return view;
    }
}
