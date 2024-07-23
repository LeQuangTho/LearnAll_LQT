package com.lqt.lequangtho14122000edit;

import java.io.Serializable;

public class Contact_181202289 implements Comparable<Contact_181202289>, Serializable {
    private int Id;
    private String Name;
    private String PhoneNumber;

    public Contact_181202289(int id, String name, String phoneNumber) {
        Id = id;
        Name = name;
        PhoneNumber = phoneNumber;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
    //Câu 3
    @Override
    public int compareTo(Contact_181202289 o) {
        return this.getName().compareTo(o.getName());
    }
}