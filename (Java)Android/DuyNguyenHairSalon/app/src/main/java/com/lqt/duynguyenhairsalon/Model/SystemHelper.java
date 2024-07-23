package com.lqt.duynguyenhairsalon.Model;

import android.content.Context;
import android.util.DisplayMetrics;

public class SystemHelper {
    private Context context;

    public SystemHelper(Context context) {
        this.context = context;
    }

    /*
     * Hàm conver dp sang px
     * */
    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
