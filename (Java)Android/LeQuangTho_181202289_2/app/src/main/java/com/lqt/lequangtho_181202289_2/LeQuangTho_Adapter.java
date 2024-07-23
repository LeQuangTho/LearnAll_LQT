package com.lqt.lequangtho_181202289_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class LeQuangTho_Adapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Contact_Tho> contactList;

    public LeQuangTho_Adapter(Context context, int layout, List<Contact_Tho> contactList) {
        this.context = context;
        this.layout = layout;
        this.contactList = contactList;
    }

    @Override
    public int getCount() {
        if (contactList != null){
            return contactList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contact_Tho contact = contactList.get(position);
        convertView = LayoutInflater.from(context).inflate(layout, parent, false);
        TextView textViewId = convertView.findViewById(R.id.textView_Id);
        TextView textViewName = convertView.findViewById(R.id.textView_Name);
        TextView textViewPhone = convertView.findViewById(R.id.textView_Phone);

        textViewId.setText("" + contact.getId());
        textViewName.setText("" + contact.getName());
        textViewPhone.setText("" + contact.getPhoneNumber());

        return convertView;
    }
}
