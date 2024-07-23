package com.lqt.lequangtho_181202289_2;
//Câu 1. Ảnh 1
public class Contact_Tho implements Comparable<Contact_Tho>{
    private int Id;
    private String Name;
    private String PhoneNumber;

    public Contact_Tho(int id, String name, String phoneNumber) {
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
    public int compareTo(Contact_Tho o) {
        return this.getName().compareTo(o.getName());
    }
}