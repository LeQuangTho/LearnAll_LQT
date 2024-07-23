package com.lqt.baitap1;

public class TraiCay {
    private String tenTraiCay;
    private String moTaTraiCay;
    private int hinhTraiCay;

    public String getTenTraiCay() {
        return tenTraiCay;
    }

    public void setTenTraiCay(String tenTraiCay) {
        this.tenTraiCay = tenTraiCay;
    }

    public String getMoTaTraiCay() {
        return moTaTraiCay;
    }

    public void setMoTaTraiCay(String moTaTraiCay) {
        this.moTaTraiCay = moTaTraiCay;
    }

    public int getHinhTraiCay() {
        return hinhTraiCay;
    }

    public void setHinhTraiCay(int hinhTraiCay) {
        this.hinhTraiCay = hinhTraiCay;
    }

    public TraiCay(String tenTraiCay, String moTaTraiCay, int hinhTraiCay) {
        this.tenTraiCay = tenTraiCay;
        this.moTaTraiCay = moTaTraiCay;
        this.hinhTraiCay = hinhTraiCay;
    }
}
