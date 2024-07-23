package com.lqt.phamvantien_made;

import java.io.Serializable;

//Câu 1 - ảnh 1
public class Taxi_MaDe implements Comparable<Taxi_MaDe>, Serializable {
    private int Id;
    private String SoXe;
    private double QuangDuong;
    private int DonGia;
    private int KhuyenMai;
    public Taxi_MaDe(int id, String soXe, double quangDuong, int donGia, int khuyenMai) {
        Id = id;
        SoXe = soXe;
        QuangDuong = quangDuong;
        DonGia = donGia;
        KhuyenMai = khuyenMai;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getSoXe() {
        return SoXe;
    }
    public void setSoXe(String soXe) {
        SoXe = soXe;
    }
    public double getQuangDuong() {
        return QuangDuong;
    }
    public void setQuangDuong(double quangDuong) {
        QuangDuong = quangDuong;
    }
    public int getDonGia() {
        return DonGia;
    }
    public void setDonGia(int donGia) {
        DonGia = donGia;
    }
    public int getKhuyenMai() {
        return KhuyenMai;
    }
    public void setKhuyenMai(int khuyenMai) {
        KhuyenMai = khuyenMai;
    }
    @Override
    public int compareTo(Taxi_MaDe o) {
        return this.SoXe.compareTo(o.getSoXe());
    }
}
