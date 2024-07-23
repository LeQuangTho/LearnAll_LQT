package com.lqt.sqlitetrongandroid.model;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

import com.lqt.sqlitetrongandroid.R;

public class CustumAdapter2 extends ResourceCursorAdapter {
    public CustumAdapter2(Context context, int layout, Cursor c, int flags) {
        super(context, layout, c, flags);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textViewHoTen = (TextView) view.findViewById(R.id.textView_HoTen);
        TextView textViewNamSinh = (TextView) view.findViewById(R.id.textView_NamSinh);

        textViewHoTen.setText(cursor.getString(cursor.getColumnIndex(MyDBHelper.getHoTen())));
        textViewNamSinh.setText(cursor.getString(cursor.getColumnIndex(MyDBHelper.getNamSinh())));
    }

}
