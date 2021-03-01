package com.example.timekeeping;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuView;

import java.util.List;

public class CustomArrayAdapter extends ArrayAdapter<Item> {
    public CustomArrayAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.activity_item_list_view, null);
        }
        Item item = getItem(position);
        if (item != null) {
            // Anh Xa
            TextView textViewDay, textViewHasWorked, textViewOvretime;
            textViewDay = (TextView) view.findViewById(R.id.textViewDay);
            textViewHasWorked = (TextView) view.findViewById(R.id.textViewHasWorked);
            textViewOvretime = (TextView) view.findViewById(R.id.textViewOvertime);
            textViewDay.setText(item.getDate() + "");
            if (item.getHasWorked() == 0) {
                textViewHasWorked.setText("Nghỉ");
                textViewHasWorked.setTextColor(Color.parseColor("#FF0000"));
            } else {
                if (item.getHasWorked() == 8) {
                    textViewHasWorked.setText("Đi làm");
                } else {
                    textViewHasWorked.setText("Làm " + item.getHasWorked() + " tiếng");
                }
            }
            if (item.getOvertime() == 0) {
                textViewOvretime.setText("");
            } else {
                textViewOvretime.setText("tăng ca " + item.getOvertime() + " tiếng");
            }
        }
        return view;
    }
}
