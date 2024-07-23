package com.lqt.baitap1;

public class Student {
    private String hoten;
    private int namsinh;
    private String diachi;

    public Student(String hoten, int namsinh, String diachi) {
        this.hoten = hoten;
        this.namsinh = namsinh;
        this.diachi = diachi;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
