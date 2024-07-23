package com.lqt.duynguyenhairsalon.SharedPreferences;

import android.content.Context;

import com.google.android.youtube.player.internal.f;

/*
 *
 * Class này quản lí tất cả các Shared Preferences trong Project
 *
 * */
public class DataLocalManager {
    private static final String PREF_FISRT_INSTALL = "PREF_FISRT_INSTALL";
    private static final String PREF_USER_NAME = "PREF_USER_NAME";
    private static final String PREF_ID_USER = "PREF_ID_USER";
    private static final String PREF_IS_LOGGED = "PREF_IS_LOGGED";
    private static final String PREF_IS_ADMIN = "PREF_IS_ADMIN";
    private static final String PREF_PROVINCE_NAME = "PREF_PROVINCE_NAME";
    private static final String PREF_DISTRICT_NAME = "PREF_DISTRICT_NAME";
    private static final String PREF_WARD_NAME = "PREF_WARD_NAME";
    private static final String PREF_PROVINCE_ID = "PREF_PROVINCE_ID";
    private static final String PREF_DISTRICT_ID = "PREF_DISTRICT_ID";
    private static final String PREF_WARD_ID = "PREF_WARD_ID";


    /*
     *Sử dụng Singleton Pattern để tồn tại duy nhất 1 instance
     * sử dụng cơ chế nhiều mày in nhưng chỉ có duy nhất một
     * bộ phận quản lí máy in đó
     * https://viblo.asia/p/hoc-singleton-pattern-trong-5-phut-4P856goOKY3
     *
     * */
    private static DataLocalManager instance;
    private MySharedPreferences mySharedPreferences;


    public static void init(Context context) {
        instance = new DataLocalManager();
        instance.mySharedPreferences = new MySharedPreferences(context);
    }

    //Lazy initialization
    public static DataLocalManager getInstance() {
        if (instance == null) {
            instance = new DataLocalManager();
        }
        return instance;
    }

    public static void setFisrtInstall(boolean isFisrt) {
        DataLocalManager.getInstance().mySharedPreferences.putBooleanValue(PREF_FISRT_INSTALL, isFisrt);
    }

    public static boolean getFisrtInstall() {
        return DataLocalManager.getInstance().mySharedPreferences.getBooleanValue(PREF_FISRT_INSTALL);
    }

    public static void setPrefUserName(String userName) {
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_USER_NAME, userName);
    }

    public static String getPrefUserName() {
        return DataLocalManager.getInstance().mySharedPreferences.getStringValue(PREF_USER_NAME);
    }

    public static void setPrefIdUser(String userName) {
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_ID_USER, userName);
    }

    public static String getPrefIdUser() {
        return DataLocalManager.getInstance().mySharedPreferences.getStringValue(PREF_ID_USER);
    }

    public static void setPrefIsLogged(boolean isLogged) {
        DataLocalManager.getInstance().mySharedPreferences.putBooleanValue(PREF_IS_LOGGED, isLogged);
    }

    public static boolean getPrefIsLogged() {
        return DataLocalManager.getInstance().mySharedPreferences.getBooleanValue(PREF_IS_LOGGED);
    }

    public static void setPrefIsAdmin(boolean isLAdmin) {
        DataLocalManager.getInstance().mySharedPreferences.putBooleanValue(PREF_IS_ADMIN, isLAdmin);
    }

    public static boolean getPrefIsAdmin() {
        return DataLocalManager.getInstance().mySharedPreferences.getBooleanValue(PREF_IS_ADMIN);
    }

    public static void setPrefProvinceName(String province) {
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_PROVINCE_NAME, province);
    }

    public static String getPrefProvinceName() {
        return DataLocalManager.getInstance().mySharedPreferences.getStringValue(PREF_PROVINCE_NAME);
    }

    public static void setPrefDistrictName(String district) {
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_DISTRICT_NAME, district);
    }

    public static String getPrefDistrictName() {
        return DataLocalManager.getInstance().mySharedPreferences.getStringValue(PREF_DISTRICT_NAME);
    }

    public static void setPrefWardName(String ward) {
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_WARD_NAME, ward);
    }

    public static String getPrefWardName() {
        return DataLocalManager.getInstance().mySharedPreferences.getStringValue(PREF_WARD_NAME);
    }

    public static void setPrefProvinceId(String province) {
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_PROVINCE_ID, province);
    }

    public static String getPrefProvinceId() {
        return DataLocalManager.getInstance().mySharedPreferences.getStringValue(PREF_PROVINCE_ID);
    }

    public static void setPrefDistrictId(String district) {
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_DISTRICT_ID, district);
    }

    public static String getPrefDistrictId() {
        return DataLocalManager.getInstance().mySharedPreferences.getStringValue(PREF_DISTRICT_ID);
    }

    public static void setPrefWardId(String ward) {
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_WARD_ID, ward);
    }

    public static String getPrefWardId() {
        return DataLocalManager.getInstance().mySharedPreferences.getStringValue(PREF_WARD_ID);
    }

    public static void resetSharaPreferences(){
        DataLocalManager.getInstance().mySharedPreferences.putBooleanValue(PREF_FISRT_INSTALL, false);
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_USER_NAME, "");
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_ID_USER, "");
        DataLocalManager.getInstance().mySharedPreferences.putBooleanValue(PREF_IS_LOGGED, false);
        DataLocalManager.getInstance().mySharedPreferences.putBooleanValue(PREF_IS_ADMIN, false);
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_PROVINCE_NAME, "");
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_DISTRICT_NAME, "");
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_WARD_NAME, "");
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_PROVINCE_ID, "");
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_DISTRICT_ID, "");
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_WARD_ID, "");
    }
}
