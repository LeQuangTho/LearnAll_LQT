package com.lqt.congdiem1;

public class SanPham {
    private int ID;
    private String Name;
    private int Money;
    private boolean KM;

    public SanPham(int ID, String name, int money, boolean KM) {
        this.ID = ID;
        Name = name;
        Money = money;
        this.KM = KM;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getMoney() {
        return Money;
    }

    public void setMoney(int money) {
        Money = money;
    }

    public boolean isKM() {
        return KM;
    }

    public void setKM(boolean KM) {
        this.KM = KM;
    }
}
