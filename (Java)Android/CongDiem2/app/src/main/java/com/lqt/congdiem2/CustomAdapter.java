package com.lqt.congdiem2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    MainActivity context;
    List<VeTau> veTauList;
    int resource;

    public CustomAdapter(MainActivity context, List<VeTau> contactList, int resource) {
        this.context = context;
        this.veTauList = contactList;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return veTauList.size();
    }

    @Override
    public Object getItem(int i) {
        return veTauList.get(i);
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

            //ánh xạ
            viewHolder.constraintLayoutItem = (ConstraintLayout) convertView.findViewById(R.id.constraintLayout_Item);
            viewHolder.textViewFrom = (TextView) convertView.findViewById(R.id.textView_staFrom);
            viewHolder.textViewTo = (TextView) convertView.findViewById(R.id.textView_staTo);
            viewHolder.textViewMoney = (TextView) convertView.findViewById(R.id.textView_Gia);
            viewHolder.textViewLoai = (TextView) convertView.findViewById(R.id.textView_Loai);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        VeTau veTau = veTauList.get(position);

        if(veTau.isDUO()){
            viewHolder.textViewMoney.setText(""+veTau.getMONEY()*2*0.95+" đ");
            viewHolder.textViewLoai.setText("Khứ hồi");
        } else{
            viewHolder.textViewMoney.setText(""+veTau.getMONEY()+" đ");
            viewHolder.textViewLoai.setText("Một chiều");
        }
        viewHolder.textViewFrom.setText(veTau.getStaFROM());
        viewHolder.textViewTo.setText(veTau.getStaTO());
        return convertView;
    }


    public class ViewHolder {
        ConstraintLayout constraintLayoutItem;
        TextView textViewFrom, textViewTo, textViewMoney, textViewLoai;
    }
}
