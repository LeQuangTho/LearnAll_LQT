package com.lqt.baitapbuoi1.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lqt.baitapbuoi1.R;
import com.lqt.baitapbuoi1.model.Contact;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {

    Context context;
    List<Contact> contactList;
    int resource;

    public ContactAdapter(@NonNull Context context, int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.contactList = objects;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder = null;

        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imgContac = (ImageView) convertView.findViewById(R.id.img_contact);
            viewHolder.nameContact = (TextView) convertView.findViewById(R.id.title_contact);
            viewHolder.numContact = (TextView) convertView.findViewById(R.id.content_contact);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Contact contact = contactList.get(position);
        
        viewHolder.imgContac.setImageResource(contact.getImage());
        viewHolder.nameContact.setText(contact.getName());
        viewHolder.numContact.setText(contact.getNumPhone());

        return convertView;
    }

    class ViewHolder {
        ImageView imgContac;
        TextView nameContact, numContact;
    }
}
