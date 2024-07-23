package com.lqt.sinhvien.model;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private int idSinhVien, namSinhSinhVien;
    private String hoTenSinhVien, diaChiSinhVien;

    public SinhVien(int idSinhVien, int namSinhSinhVien, String hoTenSinhVien, String diaChiSinhVien) {
        this.idSinhVien = idSinhVien;
        this.namSinhSinhVien = namSinhSinhVien;
        this.hoTenSinhVien = hoTenSinhVien;
        this.diaChiSinhVien = diaChiSinhVien;
    }

    public String getHoTenSinhVien() {
        return hoTenSinhVien;
    }

    public void setHoTenSinhVien(String hoTenSinhVien) {
        this.hoTenSinhVien = hoTenSinhVien;
    }

    public int getIdSinhVien() {
        return idSinhVien;
    }

    public void setIdSinhVien(int idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    public int getNamSinhSinhVien() {
        return namSinhSinhVien;
    }

    public void setNamSinhSinhVien(int namSinhSinhVien) {
        this.namSinhSinhVien = namSinhSinhVien;
    }

    public String getDiaChiSinhVien() {
        return diaChiSinhVien;
    }

    public void setDiaChiSinhVien(String diaChiSinhVien) {
        this.diaChiSinhVien = diaChiSinhVien;
    }
}
