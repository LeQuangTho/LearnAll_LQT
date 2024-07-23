package com.lqt.lequangtho_14122000;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Tho_Adapter extends RecyclerView.Adapter<Tho_Adapter.ContactViewHolder> {

    private Context context;
    private List<Contact_181202289> contactList;
    //private List<Contact_LeQuangTho> contactListFilter;
    private View view;
    private IClickContactRecyclerView iClickContactRecyclerView;

    public interface IClickContactRecyclerView {
        void OnContextMenuDeleteContact(int id);
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    public Tho_Adapter(Context context, IClickContactRecyclerView iClickContactRecyclerView) {
        this.context = context;
        this.iClickContactRecyclerView = iClickContactRecyclerView;
    }

    public void setData(List<Contact_181202289> contacts) {
        this.contactList = contacts;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact_181202289 contact = contactList.get(position);
        if (contact == null) {
            return;
        }

        holder.textViewId.setText(""+contact.getId());
        holder.textViewName.setText("" + contact.getName());
        holder.textViewPhone.setText("" + contact.getPhoneNumber());

        holder.constraintLayoutItemContact.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.add("Tho_Edit");

                menu.add("Tho_Delete").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        iClickContactRecyclerView.OnContextMenuDeleteContact(contact.getId());
                        return false;
                    }
                });
            }
        });
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