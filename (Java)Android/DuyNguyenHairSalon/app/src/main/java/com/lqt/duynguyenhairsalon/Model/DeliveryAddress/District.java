package com.lqt.duynguyenhairsalon.Model.DeliveryAddress;

public class District {
    private int idDistrict;
    private String nameDistrict;

    public District(int idDistrict, String nameDistrict) {
        this.idDistrict = idDistrict;
        this.nameDistrict = nameDistrict;
    }

    public int getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(int idDistrict) {
        this.idDistrict = idDistrict;
    }

    public String getNameDistrict() {
        return nameDistrict;
    }

    public void setNameDistrict(String nameDistrict) {
        this.nameDistrict = nameDistrict;
    }
}
