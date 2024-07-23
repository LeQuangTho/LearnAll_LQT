package com.lqt.ghino;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {
    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //hàm thực thi dữ liệu
    public void QueryData(String SQL){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(SQL);
    }

    //hàm lấy dữ liệu ra con trỏ
    public Cursor getData(String SQL){
        SQLiteDatabase database = getWritableDatabase();
        return database.rawQuery(SQL,null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
