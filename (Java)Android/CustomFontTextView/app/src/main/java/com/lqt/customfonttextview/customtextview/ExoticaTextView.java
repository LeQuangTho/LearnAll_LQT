package com.lqt.customfonttextview.customtextview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class ExoticaTextView extends AppCompatTextView {
    public ExoticaTextView(@NonNull Context context) {
        super(context);
        setFontTextView();
    }

    public ExoticaTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFontTextView();
    }

    public ExoticaTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFontTextView();
    }

    private void setFontTextView(){
        Typeface typeface = Until.getExoticaTypeface(getContext());
        setTypeface(typeface);
    }
}
