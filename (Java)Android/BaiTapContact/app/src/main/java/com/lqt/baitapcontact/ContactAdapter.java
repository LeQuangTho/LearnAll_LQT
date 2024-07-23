package com.lqt.baitapcontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

public class ContactAdapter extends BaseAdapter {

    private List<Contact> contactList;
    private Context context;
    private int layout;

    public ContactAdapter(List<Contact> contactList, Context context, int layout) {
        this.contactList = contactList;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return contactList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(layout, parent, false);

        CheckBox checkBoxStatus = (CheckBox) convertView.findViewById(R.id.checkbox_Status);
        TextView textViewName = (TextView) convertView.findViewById(R.id.textView_Name);
        TextView textViewPhoneNumber = (TextView) convertView.findViewById(R.id.textView_PhoneNumber);
        ConstraintLayout constraintLayout = (ConstraintLayout) convertView.findViewById(R.id.constraintLayout);

        Contact contact = contactList.get(position);

        checkBoxStatus.setChecked(contact.isStatus());
        textViewName.setText(contact.getName());
        textViewPhoneNumber.setText(contact.getPhoneNumber());
//        constraintLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                checkBoxStatus.setChecked(!contact.isStatus());
//                contactList.get(position).setStatus(!contact.isStatus());
//            }
//        });

        return convertView;
    }
}
