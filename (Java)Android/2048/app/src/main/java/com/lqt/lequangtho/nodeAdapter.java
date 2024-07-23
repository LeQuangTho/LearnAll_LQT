package com.lqt.lequangtho;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class nodeAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private List<Node> nodeList;

    public nodeAdapter(Context context, int layout, List<Node> nodeList) {
        this.context = context;
        this.layout = layout;
        this.nodeList = nodeList;
    }

    @Override
    public int getCount() {
        return nodeList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgHinh;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.imgHinh = (ImageView) convertView.findViewById(R.id.imvNode);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Node node = nodeList.get(position);

        holder.imgHinh.setImageResource(node.getHinh());
        return convertView;
    }
}
