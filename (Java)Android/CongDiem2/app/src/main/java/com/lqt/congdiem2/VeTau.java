package com.lqt.congdiem2;

import java.io.Serializable;

public class VeTau implements Serializable {
    private int ID;
    private String staFROM,staTO;
    private int MONEY;
    private boolean DUO;

    public VeTau(int ID, String staFROM, String staTO, int MONEY, boolean DUO) {
        this.ID = ID;
        this.staFROM = staFROM;
        this.staTO = staTO;
        this.MONEY = MONEY;
        this.DUO = DUO;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getStaFROM() {
        return staFROM;
    }

    public void setStaFROM(String staFROM) {
        this.staFROM = staFROM;
    }

    public String getStaTO() {
        return staTO;
    }

    public void setStaTO(String staTO) {
        this.staTO = staTO;
    }

    public int getMONEY() {
        return MONEY;
    }

    public void setMONEY(int MONEY) {
        this.MONEY = MONEY;
    }

    public boolean isDUO() {
        return DUO;
    }

    public void setDUO(boolean DUO) {
        this.DUO = DUO;
    }
}
