package com.lqt.kiemtra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ContactAdapter extends BaseAdapter{
    MainActivity context;
    List<Contact> contactList;
    int resource;

    public ContactAdapter(MainActivity context, List<Contact> contactList, int resource) {
        this.context = context;
        this.contactList = contactList;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int i) {
        return contactList.get(i);
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
            viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.CheckBox_Contact);
            viewHolder.nameContact = (TextView) convertView.findViewById(R.id.TextView_Ten);
            viewHolder.numContact = (TextView) convertView.findViewById(R.id.TextView_Contact);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Contact contact = contactList.get(position);

        viewHolder.checkBox.setChecked(contact.isCheck());
        viewHolder.nameContact.setText(contact.getHoTen());
        viewHolder.numContact.setText(contact.getSdt());

        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.sua(contactList.get(position).getId(),contactList.get(position).isCheck());
                Toast.makeText(context, "Đã sửa", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    class ViewHolder {
        CheckBox checkBox;
        TextView nameContact, numContact;
    }
}
