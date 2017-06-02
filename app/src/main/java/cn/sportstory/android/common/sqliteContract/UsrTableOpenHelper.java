package cn.sportstory.android.common.sqliteContract;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import cn.sportstory.android.common.bean.UserBean;
import cn.sportstory.android.common.tools.DateUtils;

/**
 * Created by aaron on 2017/6/2.
 */

public class UsrTableOpenHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "sportstory.db";

    public UsrTableOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsrTableContract.SQL_CREATE_TABLE_USR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UsrTableContract.SQL_DROP_TABLE_USR);
        onCreate(db);
    }

    /**
     * 插入用户表
     * @param bean
     * @return
     */
    public long insert(UserBean bean){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UsrTableContract.COLUMN_NAME_ID, bean.getUid());
        values.put(UsrTableContract.COLUMN_NAME_NICKNAME, bean.getNickname());
        values.put(UsrTableContract.COLUMN_NAME_GENDER, bean.getGender());
        values.put(UsrTableContract.COLUMN_NAME_AGE, DateUtils.getAge(bean.getBirthday()));
        values.put(UsrTableContract.COLUMN_NAME_WEIGHT, bean.getWeight());
        values.put(UsrTableContract.COLUMN_NAME_AVATAR, bean.getAvatar());
        values.put(UsrTableContract.COLUMN_NAME_PHONE, bean.getPhone());
        values.put(UsrTableContract.COLUMN_NAME_EMAIL, bean.getEmail());
        values.put(UsrTableContract.COLUMN_NAME_BACKGROUND, bean.getBackground());
        values.put(UsrTableContract.COLUMN_NAME_HEIGHT, bean.getStature());
        values.put(UsrTableContract.COLUMN_NAME_CITY, bean.getCity());
        values.put(UsrTableContract.COLUMN_NAME_PROVINCE, bean.getProvince());
        values.put(UsrTableContract.COLUMN_NAME_DISTRICT, bean.getDistrict());
        values.put(UsrTableContract.COLUMN_NAME_ADDRESS, bean.getAddress());
        values.put(UsrTableContract.COLUMN_NAME_ASSIGNMENT, bean.getAssignment());
        return db.insert(UsrTableContract.TABLE_NAME, null, values);
    }
}
