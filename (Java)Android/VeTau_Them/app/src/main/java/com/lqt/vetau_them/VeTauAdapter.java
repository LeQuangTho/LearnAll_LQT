package com.lqt.vetau_them;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class VeTauAdapter extends BaseAdapter {

    private int layout;
    private List<VeTau> veTauList;
    private Context context;

    public VeTauAdapter(int layout, List<VeTau> veTauList, Context context) {
        this.layout = layout;
        this.veTauList = veTauList;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (veTauList != null){
            return veTauList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return veTauList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(layout, parent, false);

        TextView textViewLoTrinh = (TextView) convertView.findViewById(R.id.textView_LoTrinh);
        TextView textViewKhuHoi = (TextView) convertView.findViewById(R.id.textView_KhuHoi);
        TextView textViewDonGia = (TextView) convertView.findViewById(R.id.textView_DonGia);

        VeTau veTau = veTauList.get(position);

        textViewLoTrinh.setText(veTau.getGaDi() + " --> " +veTau.getGaDen());
        if(veTau.isKhuHoi()){
            textViewKhuHoi.setText("Khứ Hồi");
            textViewDonGia.setText("" + veTau.getDonGia() * 1.95);
        }else{
            textViewKhuHoi.setText("Một Chiều");
            textViewDonGia.setText("" + veTau.getDonGia());
        }
        return convertView;
    }
}
