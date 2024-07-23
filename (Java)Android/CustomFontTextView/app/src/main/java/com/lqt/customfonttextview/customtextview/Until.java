package com.lqt.customfonttextview.customtextview;

import android.content.Context;
import android.graphics.Typeface;

public class Until {
    private static Typeface exoticaTypeface;
    private static Typeface pacificoTypeface;
    private static Typeface sf_wonder_comic_inlineTypeface;
    private static Typeface top_secretTypeface;
    private static Typeface true_crimesTypeface;

    public static Typeface getExoticaTypeface(Context context) {
        if(exoticaTypeface == null){
            exoticaTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/Exotica.ttf");
        }
        return exoticaTypeface;
    }

    public static Typeface getPacificoTypeface(Context context) {
        if(pacificoTypeface == null){
            pacificoTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/Pacifico.ttf");
        }
        return pacificoTypeface;
    }

    public static Typeface getSf_wonder_comic_inlineTypeface(Context context) {
        if(sf_wonder_comic_inlineTypeface == null){
            sf_wonder_comic_inlineTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/SF_Wonder_Comic_Inline.ttf");
        }
        return sf_wonder_comic_inlineTypeface;
    }

    public static Typeface getTop_secretTypeface(Context context) {
        if(top_secretTypeface == null){
            top_secretTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/Top_Secret.ttf");
        }
        return top_secretTypeface;
    }

    public static Typeface getTrue_crimesTypeface(Context context) {
        if(true_crimesTypeface == null){
            true_crimesTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/true-crimes.ttf");
        }
        return true_crimesTypeface;
    }


}
