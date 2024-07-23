package com.lqt.duynguyenhairsalon.Model.DeliveryAddress;

public class Ward {
    private int idWard;
    private String nameWard;

    public Ward(int idWard, String nameWard) {
        this.idWard = idWard;
        this.nameWard = nameWard;
    }

    public int getIdWard() {
        return idWard;
    }

    public void setIdWard(int idWard) {
        this.idWard = idWard;
    }

    public String getNameWard() {
        return nameWard;
    }

    public void setNameWard(String nameWard) {
        this.nameWard = nameWard;
    }
}
