package com.lqt.duynguyenhairsalon.Model;

public class BookingTime {
    private String mTime;
    private String timeCut;
    private boolean isSelected;
    private boolean isSelecting;


    public BookingTime(String mTime, boolean isSelected, String TimeCut) {
        this.mTime = mTime;
        this.isSelected = isSelected;
        this.timeCut = TimeCut;
        this.isSelecting = false;
    }

    public String getTimeCut() {
        return timeCut;
    }

    public void setTimeCut(String timeCut) {
        this.timeCut = timeCut;
    }

    public boolean isSelecting() {
        return isSelecting;
    }

    public void setSelecting(boolean selecting) {
        isSelecting = selecting;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
