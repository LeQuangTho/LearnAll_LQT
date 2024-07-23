package com.lqt.duynguyenhairsalon.Model;

public class DayCut {
    private String stringDayCut;
    private String dateCut;

    public DayCut(String stringDayCut, String dateCut) {
        this.stringDayCut = stringDayCut;
        this.dateCut = dateCut;
    }

    public String getStringDayCut() {
        return stringDayCut;
    }

    public void setStringDayCut(String stringDayCut) {
        this.stringDayCut = stringDayCut;
    }

    public String getDateCut() {
        return dateCut;
    }

    public void setDateCut(String dateCut) {
        this.dateCut = dateCut;
    }
}
