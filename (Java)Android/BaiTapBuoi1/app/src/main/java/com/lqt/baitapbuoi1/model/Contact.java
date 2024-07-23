package com.lqt.baitapbuoi1.model;

public class Contact {
    private int Image;
    private String name, numPhone;
    private detailContact detail;

    public detailContact getDetail() {
        return detail;
    }

    public void setDetail(detailContact detail) {
        this.detail = detail;
    }

    public Contact(int image, String name, String numPhone, detailContact detail) {
        this.Image = image;
        this.name = name;
        this.numPhone = numPhone;
        this.detail = detail;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        this.Image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumPhone() {
        return numPhone;
    }

    public void setNumPhone(String numPhone) {
        this.numPhone = numPhone;
    }
}
