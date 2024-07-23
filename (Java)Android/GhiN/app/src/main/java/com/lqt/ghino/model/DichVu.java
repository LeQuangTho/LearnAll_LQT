package com.lqt.ghino.model;

import java.io.Serializable;

public class DichVu implements Serializable {
    private String tenDichVu;
    private int donGia;

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public DichVu(String tenDichVu, int donGia) {
        this.tenDichVu = tenDichVu;
        this.donGia = donGia;
    }
}
