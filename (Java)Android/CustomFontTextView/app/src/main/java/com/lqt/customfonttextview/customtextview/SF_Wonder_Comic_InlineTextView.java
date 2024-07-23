package com.lqt.customfonttextview.customtextview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class SF_Wonder_Comic_InlineTextView extends AppCompatTextView {
    public SF_Wonder_Comic_InlineTextView(@NonNull Context context) {
        super(context);
        setFontTextView();
    }

    public SF_Wonder_Comic_InlineTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFontTextView();
    }

    public SF_Wonder_Comic_InlineTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFontTextView();
    }

    private void setFontTextView() {
        Typeface typeface = Until.getSf_wonder_comic_inlineTypeface(getContext());
        setTypeface(typeface);
    }
}
