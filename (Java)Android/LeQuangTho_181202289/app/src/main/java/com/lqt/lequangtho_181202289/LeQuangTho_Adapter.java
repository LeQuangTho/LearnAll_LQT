package com.lqt.lequangtho_181202289;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LeQuangTho_Adapter extends RecyclerView.Adapter<LeQuangTho_Adapter.ContactViewHolder> {

    private Context context;
    private List<Contact_LeQuangTho> contactList;
    //private List<Contact_LeQuangTho> contactListFilter;
    private View view;


    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    public LeQuangTho_Adapter(Context context) {
        this.context = context;

    }

    public void setData(List<Contact_LeQuangTho> contacts) {
        this.contactList = contacts;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact_LeQuangTho contact = contactList.get(position);
        if (contact == null) {
            return;
        }

        holder.textViewId.setText(""+contact.getId());
        holder.textViewName.setText("" + contact.getName());
        holder.textViewPhone.setText("" + contact.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        if (contactList != null) {
            return contactList.size();
        }
        return 0;
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewPhone, textViewId;
        ConstraintLayout constraintLayoutItemContact;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.textView_Name);
            textViewPhone = (TextView) itemView.findViewById(R.id.textView_Phone);
            textViewId = (TextView) itemView.findViewById(R.id.textView_Id);
            constraintLayoutItemContact = (ConstraintLayout) itemView.findViewById(R.id.constraintLayout_ItemContact);
        }
    }
}
