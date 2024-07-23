package com.lqt.baitapbuoi1.model;

public class CauThu {
    private String ten;
    private int face;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        this.face = face;
    }

    public CauThu(String ten, int face) {
        this.ten = ten;
        this.face = face;
    }
}
