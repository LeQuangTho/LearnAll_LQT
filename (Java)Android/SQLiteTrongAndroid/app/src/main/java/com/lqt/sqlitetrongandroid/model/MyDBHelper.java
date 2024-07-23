package com.lqt.sqlitetrongandroid.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {

    //khai báo tên csdl và tên bảng
    private static final String DBname = "mydb.db";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "SinhVien";
    private static final String ID = "_id";
    private static final String HoTen = "hoten";
    private static final String NamSinh = "namsinh";
    private SQLiteDatabase myDB;

    public MyDBHelper(@Nullable Context context) {
        super(context, DBname, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" + ID
                + "AUTO_INCREMENT INTEGER PRIMARY KEY, " + HoTen + " TEXT NOT NULL, "
                + NamSinh + " INTEGER NOT NULL"+")";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //open db
    public void openDB(){
        myDB = getWritableDatabase();
    }

    //closedb
    public void closeDB(){
        if(myDB !=  null && myDB.isOpen()){
            myDB.close();
        }
    }

    // Viết các phương thức insert,update, delete
    public long Insert(int iD, String hoTen, int namSinh){
        //Nhập qua ContentValues
        ContentValues values = new ContentValues();
        values.put(ID,iD);
        values.put(HoTen,hoTen);
        values.put(NamSinh,namSinh);
        return myDB.insert(TABLE_NAME, null, values);
    }

    public long Update(int iD, String hoTen, int namSinh){
        //Nhập qua ContentValues
        ContentValues values = new ContentValues();
        values.put(ID,iD);
        values.put(HoTen,hoTen);
        values.put(NamSinh,namSinh);
        String where = ID + " = " + iD;
        return myDB.update(TABLE_NAME, values, where, null);
    }

    public long Delete(int iD){
        //Nhập qua ContentValues
        ContentValues values = new ContentValues();
        values.put(ID,iD);
        String where = ID + " = " + iD;
        return myDB.delete(TABLE_NAME, where, null);
    }

    public static String getId(){
        return ID;
    }

    public static String getHoTen(){
        return HoTen;
    }

    public static String getNamSinh(){
        return NamSinh;
    }

    public Cursor Load(){
        String query = "SELECT * from " + TABLE_NAME;
        return myDB.rawQuery(query, null);
    }
}
