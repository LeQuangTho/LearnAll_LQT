package com.lqt.baitapbuoi1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.lqt.baitapbuoi1.R;
import com.lqt.baitapbuoi1.model.CauThu;
import com.lqt.baitapbuoi1.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class CustomBaseAdapter extends BaseAdapter implements Filterable {
    private Context context;
    private int resource;
    ArrayList<CauThu> cauThus;

    Filter filter;
    ArrayList<CauThu> filterList;

    public CustomBaseAdapter(Context context, int resource, ArrayList<CauThu> cauThus) {
        this.context = context;
        this.resource = resource;
        this.cauThus = cauThus;
        this.filterList = cauThus;
    }

    @Override
    public int getCount() {
        return cauThus.size();
    }

    @Override
    public Object getItem(int position) {
        return cauThus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, null);
            viewHolder = new ViewHolder();
            viewHolder.face = (ImageView) convertView.findViewById(R.id.ImageView_Face);
            viewHolder.name = (TextView) convertView.findViewById(R.id.TextView_Name);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        CauThu cauThu = cauThus.get(position);

        viewHolder.face.setImageResource(cauThu.getFace());
        viewHolder.name.setText(cauThu.getTen());
        return convertView;
    }

    class ViewHolder {
        ImageView face;
        TextView name;
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new CustomFilter();
        }
        return filter;
    }

    private class CustomFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                constraint = constraint.toString().toUpperCase();
                ArrayList<CauThu> filters = new ArrayList<>();
                for (int i = 0; i < filterList.size(); i++) {
                    if (filterList.get(i).getTen().toUpperCase().contains(constraint)) {
                        CauThu p = new CauThu(filterList.get(i).getTen(), filterList.get(i).getFace());
                        filters.add(p);
                    }
                    results.count = filters.size();
                    results.values = filters;
                }
            } else {
                results.count = filterList.size();
                results.values = filterList;
            }
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            cauThus = (ArrayList<CauThu>) results.values;
            notifyDataSetChanged();
        }
    }
}
