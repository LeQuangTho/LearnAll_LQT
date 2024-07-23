package com.lqt.baitap1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TraiCayAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TraiCay> traiCayList;

    public TraiCayAdapter(Context context, int layout, List<TraiCay> traiCayList) {
        this.context = context;
        this.layout = layout;
        this.traiCayList = traiCayList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public List<TraiCay> getTraiCayList() {
        return traiCayList;
    }

    public void setTraiCayList(List<TraiCay> traiCayList) {
        this.traiCayList = traiCayList;
    }

    @Override
    public int getCount() {
        return traiCayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class ViewHolder {
        ImageView hinhAnh;
        TextView tenQua, moTaQua;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            viewHolder = new ViewHolder();

            viewHolder.tenQua = (TextView) convertView.findViewById(R.id.tbName);
            viewHolder.moTaQua = (TextView) convertView.findViewById(R.id.tbMoTa);
            viewHolder.hinhAnh = (ImageView) convertView.findViewById(R.id.hinhTraiCay);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        TraiCay traiCay = traiCayList.get(position);
        viewHolder.tenQua.setText(traiCay.getTenTraiCay().toString());
        viewHolder.moTaQua.setText(traiCay.getMoTaTraiCay());
        viewHolder.hinhAnh.setImageResource(traiCay.getHinhTraiCay());


        return convertView;
    }
}
