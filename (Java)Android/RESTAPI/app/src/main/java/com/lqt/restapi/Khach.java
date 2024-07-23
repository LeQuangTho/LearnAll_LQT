package com.lqt.restapi;

public class Khach {
    private String ID, Name, Address, PhoneNumber;

    public Khach(String ID, String name, String address, String phoneNumber) {
        this.ID = ID;
        Name = name;
        Address = address;
        PhoneNumber = phoneNumber;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
