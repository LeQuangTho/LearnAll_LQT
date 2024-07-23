package com.lqt.phamvantien_181202290;
import java.io.Serializable;

public class HoaDon_PhamVanTien implements Serializable, Comparable<HoaDon_PhamVanTien> {
    private int ID;
    private String HoTenKhach;
    private int SoPhong, DonGia, SoNgay;
    public HoaDon_PhamVanTien(int ID, String hoTenKhach, int soPhong, int donGia, int soNgay) {
        this.ID = ID;
        HoTenKhach = hoTenKhach;
        SoPhong = soPhong;
        DonGia = donGia;
        SoNgay = soNgay;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getHoTenKhach() {
        return HoTenKhach;
    }
    public void setHoTenKhach(String hoTenKhach) {
        HoTenKhach = hoTenKhach;
    }
    public int getSoPhong() {
        return SoPhong;
    }
    public void setSoPhong(int soPhong) {
        SoPhong = soPhong;
    }
    public int getDonGia() {
        return DonGia;
    }
    public void setDonGia(int donGia) {
        DonGia = donGia;
    }
    public int getSoNgay() {
        return SoNgay;
    }
    public void setSoNgay(int soNgay) {
        SoNgay = soNgay;
    }
    @Override
    public int compareTo(HoaDon_PhamVanTien o) {
        return (this.DonGia * this.SoNgay) - (o.DonGia * o.SoNgay);
    }
}
