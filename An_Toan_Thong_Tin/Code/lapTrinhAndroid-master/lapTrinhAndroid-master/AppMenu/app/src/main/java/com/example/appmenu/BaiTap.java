package com.example.appmenu;

public class BaiTap {
    public String name;
    public String ngayLam;

    public BaiTap(String name, String ngayLam) {
        this.name = name;
        this.ngayLam = ngayLam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNgayLam() {
        return ngayLam;
    }

    public void setNgayLam(String ngayLam) {
        this.ngayLam = ngayLam;
    }
}
