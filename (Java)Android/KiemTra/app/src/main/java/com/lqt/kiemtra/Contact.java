package com.lqt.kiemtra;

public class Contact {
    int id;
    private boolean Check;
    private String HoTen, Sdt;

    public Contact(int id, boolean check, String hoTen, String sdt) {
        this.id = id;
        Check = check;
        HoTen = hoTen;
        Sdt = sdt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCheck() {
        return Check;
    }

    public void setCheck(boolean check) {
        Check = check;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }
}
