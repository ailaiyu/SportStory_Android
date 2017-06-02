package cn.sportstory.android.common.tools;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by aaron on 2017/6/2.
 */

public class SharedPreferenceHelper {
    public static final int DEFAULT_INT = 0;
    public static final float DEFAULT_FLOAT = 0f;
    public static final long DEFAULT_LONG = 0;
    public static final String DEFAULT_STRING = "";


    public static void writeString(String key, String value, String fileName, Context context){
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void writeInt(String key, int value, String fileName, Context context){
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    public static void writeFloat(String key, float value, String fileName, Context context){
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    public static void writeBoolean(String key, boolean value, String fileName, Context context){
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static void writeLong(String key, long value, String fileName, Context context){
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public static int getInt(String key, String fileName, Context context){
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, DEFAULT_INT);
    }

    public static String getString(String key, String fileName, Context context){
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, DEFAULT_STRING);
    }

    public static float getFloat(String key, String fileName, Context context){
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sharedPreferences.getFloat(key, DEFAULT_INT);
    }

    public static long getLong(String key, String fileName, Context context){
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(key, DEFAULT_INT);
    }
}
