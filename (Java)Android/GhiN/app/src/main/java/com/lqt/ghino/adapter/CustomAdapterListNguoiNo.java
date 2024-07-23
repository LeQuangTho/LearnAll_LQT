package com.lqt.ghino.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lqt.ghino.R;
import com.lqt.ghino.model.NguoiNo;

import java.util.ArrayList;

public class CustomAdapterListNguoiNo extends BaseAdapter implements Filterable {
    Context context;
    ArrayList<NguoiNo> listNguoiNo;
    int resource;

    Filter filter;
    ArrayList<NguoiNo> filterList;

    public CustomAdapterListNguoiNo(Context context, ArrayList<NguoiNo> listNguoiNo, int resource) {
        this.context = context;
        this.listNguoiNo = listNguoiNo;
        this.resource = resource;
        this.filterList = listNguoiNo;
    }

    @Override
    public int getCount() {
        return listNguoiNo.size();
    }

    @Override
    public Object getItem(int position) {
        return listNguoiNo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, null);
            holder = new ViewHolder();

            holder.textView_Ten = (TextView) convertView.findViewById(R.id.TextView_Ten);
            holder.textView_SDT = (TextView) convertView.findViewById(R.id.TextView_SDT);
            holder.textView_NgayNo = (TextView) convertView.findViewById(R.id.TextView_NgayNo);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView_Ten.setText(listNguoiNo.get(position).getTenNguoiNo());
        holder.textView_SDT.setText(listNguoiNo.get(position).getSdtNguoiNo());
        holder.textView_NgayNo.setText(listNguoiNo.get(position).getNgayNo());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new CustomFilter();
        }
        return filter;
    }

    private class ViewHolder {
        TextView textView_Ten, textView_SDT, textView_NgayNo;
    }

    private class CustomFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint != null & constraint.length() > 0) {
                //chuyển hết kí tự nhập vào EditText thành chữa hoa;
                constraint = constraint.toString().toUpperCase();
                //tọa 1 list tạm thời để lưu kết quả tìm kiếm được
                ArrayList<NguoiNo> filters = new ArrayList<>();

                //bắt đầu tìm
                for (int i = 0; i < filterList.size(); i++) {
                    if (filterList.get(i).getTenNguoiNo().toUpperCase().contains(constraint)) {
                        filters.add(new NguoiNo(filterList.get(i).getTenNguoiNo(),
                                filterList.get(i).getSdtNguoiNo(),
                                filterList.get(i).getNgayNo(),
                                filterList.get(i).getListDV()));
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
            listNguoiNo = (ArrayList<NguoiNo>) results.values;
            notifyDataSetChanged();
        }
    }
}
