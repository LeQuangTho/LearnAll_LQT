package com.lqt.kiemtrade01;

import android.content.Context;
import android.os.Build;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> implements Filterable {
    private Context context;
    private List<Contact> contactList;
    private List<Contact> contactListFilter;
    private View view;
    private IClickContactRecyclerView iClickContactRecyclerView;

    public interface IClickContactRecyclerView {
        void OnClickItemClick(int position);
        void OnContextMenuDeleteContact(int position);
        void OnContextMenuEditContact(int position);
    }

    public ContactAdapter(Context context, IClickContactRecyclerView iClickContactRecyclerView) {
        this.context = context;
        this.iClickContactRecyclerView = iClickContactRecyclerView;
    }

    public void setData(List<Contact> contacts) {
        this.contactList = contacts;
        this.contactListFilter = contacts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        if (contact == null) {
            return;
        }

        holder.checkBoxStatus.setChecked(contact.isStatus());
        holder.textViewName.setText("" + contact.getName());
        holder.textViewPhone.setText("" + contact.getPhoneNumber());
        holder.constraintLayoutItemContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iClickContactRecyclerView.OnClickItemClick(position);
            }
        });

        // Riêng đối với recycler view thì thêm thế này
        holder.constraintLayoutItemContact.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.add("Delete").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        iClickContactRecyclerView.OnContextMenuDeleteContact(contact.getId());
                        return false;
                    }
                });
                menu.add("Edit").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        iClickContactRecyclerView.OnContextMenuEditContact(contact.getId());
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
        TextView textViewName, textViewPhone;
        CheckBox checkBoxStatus;
        ConstraintLayout constraintLayoutItemContact;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.textView_Name);
            textViewPhone = (TextView) itemView.findViewById(R.id.textView_Phone);
            checkBoxStatus = (CheckBox) itemView.findViewById(R.id.checkbox_Status);
            constraintLayoutItemContact = (ConstraintLayout) itemView.findViewById(R.id.constraintLayout_ItemContact);
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String stringSearch = constraint.toString();
                if (stringSearch.isEmpty()) {
                    contactList = contactListFilter;
                } else {
                    List<Contact> contactList1 = new ArrayList<>();
                    for (Contact contact : contactList) {
                        if (contact.getName().toLowerCase().contains(stringSearch)) {
                            contactList1.add(contact);
                        }
                    }
                    contactList = contactList1;
                }

                FilterResults results = new FilterResults();
                results.values = contactList;

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                contactList = (List<Contact>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
