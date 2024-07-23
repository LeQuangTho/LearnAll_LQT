package com.lqt.sqlitetrongandroid.model;

public class Student {
    private int ID;
    private int NamSinh;
    private String HoTen;

    public Student(int ID, int namSinh, String hoTen) {
        this.ID = ID;
        NamSinh = namSinh;
        HoTen = hoTen;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(int namSinh) {
        NamSinh = namSinh;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }
}
