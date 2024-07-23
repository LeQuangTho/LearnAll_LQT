package com.lqt.phamvantien_181202290;
import java.io.Serializable;

public class ThiSinh_13072000 implements Serializable, Comparable<ThiSinh_13072000> {
    private String SBD;
    private String HoTen;
    private double Toan, Ly, Hoa;
    public ThiSinh_13072000(String SBD, String hoTen, double toan, double ly, double hoa) {
        this.SBD = SBD;
        HoTen = hoTen;
        Toan = toan;
        Ly = ly;
        Hoa = hoa;
    }
    public String getSBD() {
        return SBD;
    }
    public void setSBD(String SBD) {
        this.SBD = SBD;
    }
    public String getHoTen() {
        return HoTen;
    }
    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }
    public double getToan() {
        return Toan;
    }
    public void setToan(double toan) {
        Toan = toan;
    }
    public double getLy() {
        return Ly;
    }
    public void setLy(double ly) {
        Ly = ly;
    }
    public double getHoa() {
        return Hoa;
    }
    public void setHoa(double hoa) {
        Hoa = hoa;
    }
    @Override
    public int compareTo(ThiSinh_13072000 o) {
        return this.HoTen.compareTo(o.HoTen);
    }
}
