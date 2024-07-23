package com.lqt.ghino.model;

import java.io.Serializable;
import java.util.ArrayList;

public class NguoiNo implements Serializable {
    private String tenNguoiNo, sdtNguoiNo, ngayNo;
    ArrayList<DichVu> listDV;

    public String getTenNguoiNo() {
        return tenNguoiNo;
    }

    public void setTenNguoiNo(String tenNguoiNo) {
        this.tenNguoiNo = tenNguoiNo;
    }

    public String getSdtNguoiNo() {
        return sdtNguoiNo;
    }

    public void setSdtNguoiNo(String sdtNguoiNo) {
        this.sdtNguoiNo = sdtNguoiNo;
    }

    public String getNgayNo() {
        return ngayNo;
    }

    public void setNgayNo(String ngayNo) {
        this.ngayNo = ngayNo;
    }

    public ArrayList<DichVu> getListDV() {
        return listDV;
    }

    public void setListDV(ArrayList<DichVu> listDV) {
        this.listDV = listDV;
    }

    public NguoiNo(String tenNguoiNo, String sdtNguoiNo, String ngayNo, ArrayList<DichVu> listDV) {
        this.tenNguoiNo = tenNguoiNo;
        this.sdtNguoiNo = sdtNguoiNo;
        this.ngayNo = ngayNo;
        this.listDV = listDV;
    }
}
