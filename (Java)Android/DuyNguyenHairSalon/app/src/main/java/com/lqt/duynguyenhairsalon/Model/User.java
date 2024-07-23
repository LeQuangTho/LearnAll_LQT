package com.lqt.duynguyenhairsalon.Model;

public class User {
    private int ID_User;
    private String Name_User;
    private String Phone_Number_User;

    public User(int ID_User, String name_User, String phone_Number_User) {
        this.ID_User = ID_User;
        Name_User = name_User;
        Phone_Number_User = phone_Number_User;
    }

    public int getID_User() {
        return ID_User;
    }

    public void setID_User(int ID_User) {
        this.ID_User = ID_User;
    }

    public String getName_User() {
        return Name_User;
    }

    public void setName_User(String name_User) {
        Name_User = name_User;
    }

    public String getPhone_Number_User() {
        return Phone_Number_User;
    }

    public void setPhone_Number_User(String phone_Number_User) {
        Phone_Number_User = phone_Number_User;
    }
}
