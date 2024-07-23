package com.lqt.baitapbuoi1.model;

public class detailContact {
    private String diachi;
    private String email, congty;

    public detailContact(String diachi, String email, String congty) {
        this.diachi = diachi;
        this.email = email;
        this.congty = congty;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCongty() {
        return congty;
    }

    public void setCongty(String congty) {
        this.congty = congty;
    }
}
