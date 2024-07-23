package com.lqt.congdiem1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    MainActivity context;
    List<SanPham> sanPhamsList;
    int resource;

    public CustomAdapter(MainActivity context, List<SanPham> contactList, int resource) {
        this.context = context;
        this.sanPhamsList = contactList;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return sanPhamsList.size();
    }

    @Override
    public Object getItem(int i) {
        return sanPhamsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder = null;

        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.KM = (TextView) convertView.findViewById(R.id.textView_KM);
            viewHolder.nameSanPham = (TextView) convertView.findViewById(R.id.textView_Name);
            viewHolder.moneySanPham = (TextView) convertView.findViewById(R.id.textView_Money);
            viewHolder.constraintLayout = (ConstraintLayout) convertView.findViewById(R.id.Contrain);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        SanPham sanPham = sanPhamsList.get(position);

        if(sanPham.isKM()){
            viewHolder.KM.setVisibility(View.INVISIBLE);
            viewHolder.moneySanPham.setText(""+sanPham.getMoney()*0.8+" đ");
        } else{
            viewHolder.KM.setVisibility(View.VISIBLE);
            viewHolder.moneySanPham.setText(""+sanPham.getMoney()+" đ");
        }
        viewHolder.nameSanPham.setText(sanPham.getName());

//        viewHolder.constraintLayout.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//
//                return false;
//            }
//        });
        return convertView;
    }


    class ViewHolder {
        ConstraintLayout constraintLayout;
        TextView nameSanPham, moneySanPham, KM;
    }

}
