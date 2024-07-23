package com.lqt.baitap2_gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class OVuongAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<HinhAnh> hinhAnhs;

    public OVuongAdapter(Context context, int layout, List<HinhAnh> hinhAnhs) {
        this.context = context;
        this.layout = layout;
        this.hinhAnhs = hinhAnhs;
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

    public List<HinhAnh> getHinhAnhs() {
        return hinhAnhs;
    }

    public void setHinhAnhs(List<HinhAnh> hinhAnhs) {
        this.hinhAnhs = hinhAnhs;
    }

    @Override
    public int getCount() {
        return hinhAnhs.size();
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
        TextView ovuong;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layout, null);

            viewHolder.ovuong = (TextView) convertView.findViewById(R.id.Ovuong);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        HinhAnh hinhAnh = hinhAnhs.get(position);

        viewHolder.ovuong.setText(hinhAnh.getTenAnh());
        return convertView;
    }
}
