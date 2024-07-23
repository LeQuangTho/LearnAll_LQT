package com.lqt.vetau_them;

import java.io.Serializable;

public class VeTau  implements Comparable<VeTau>, Serializable {
    private int ID_VeTau;
    private String GaDi;
    private String GaDen;
    private int DonGia;
    private boolean KhuHoi;

    public VeTau(int ID_VeTau, String gaDi, String gaDen, int donGia, boolean khuHoi) {
        this.ID_VeTau = ID_VeTau;
        GaDi = gaDi;
        GaDen = gaDen;
        DonGia = donGia;
        KhuHoi = khuHoi;
    }

    public int getID_VeTau() {
        return ID_VeTau;
    }

    public void setID_VeTau(int ID_VeTau) {
        this.ID_VeTau = ID_VeTau;
    }

    public String getGaDi() {
        return GaDi;
    }

    public void setGaDi(String gaDi) {
        GaDi = gaDi;
    }

    public String getGaDen() {
        return GaDen;
    }

    public void setGaDen(String gaDen) {
        GaDen = gaDen;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int donGia) {
        DonGia = donGia;
    }

    public boolean isKhuHoi() {
        return KhuHoi;
    }

    public void setKhuHoi(boolean khuHoi) {
        KhuHoi = khuHoi;
    }

    @Override
    public int compareTo(VeTau o) {
        return this.ID_VeTau - o.getID_VeTau();
    }
}
