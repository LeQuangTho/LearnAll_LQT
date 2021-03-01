package com.example.customlistview;

public class SinhVien {
    public String fullName;
    public int birthYear;
    public int img;

    public SinhVien(String fName, int bYear, int img) {
        fullName = fName;
        this.birthYear = bYear;
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}
