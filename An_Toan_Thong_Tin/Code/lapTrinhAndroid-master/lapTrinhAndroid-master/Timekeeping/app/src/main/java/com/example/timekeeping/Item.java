package com.example.timekeeping;


public class Item {
    private double hasWorked;
    private double overtime;
    private String date;

    public Item(double hasWorked, double overtime, String date) {
        this.hasWorked = hasWorked;
        this.overtime = overtime;
        this.date = date;
    }

    public double getHasWorked() {
        return hasWorked;
    }

    public void setHasWorked(double hasWorked) {
        this.hasWorked = hasWorked;
    }

    public double getOvertime() {
        return overtime;
    }

    public void setOvertime(double overtime) {
        this.overtime = overtime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
