package cn.sportstory.android.common.sqliteContract;

/**
 * Created by aaron on 2017/6/2.
 */

public interface UsrTableContract {


     String TABLE_NAME = "USR";

     String COLUMN_NAME_ID = "u_id";
     String COLUMN_NAME_NICKNAME = "nickname";
     String COLUMN_NAME_GENDER = "gender";
     String COLUMN_NAME_AGE = "age";
     String COLUMN_NAME_WEIGHT = "weight";
     String COLUMN_NAME_AVATAR = "avatar";
     String COLUMN_NAME_PHONE = "phone";
     String COLUMN_NAME_EMAIL = "email";
     String COLUMN_NAME_BACKGROUND = "background";
     String COLUMN_NAME_HEIGHT = "height";
     String COLUMN_NAME_CITY = "city";
     String COLUMN_NAME_PROVINCE = "province";
     String COLUMN_NAME_DISTRICT = "district";
     String COLUMN_NAME_ADDRESS = "address";
     String COLUMN_NAME_ASSIGNMENT = "assignment";


    String INTEGER_TYPE = " INTEGER";
    String TEXT_TYPE = " TEXT";
    String COMMA_SEP = ",";
    public static final String SQL_CREATE_TABLE_USR =

            "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_NICKNAME + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_GENDER + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_AGE + INTEGER_TYPE + COMMA_SEP +
                    COLUMN_NAME_WEIGHT + INTEGER_TYPE + COMMA_SEP +
                    COLUMN_NAME_AVATAR + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_PHONE + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_EMAIL + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_BACKGROUND + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_HEIGHT + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_CITY + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_PROVINCE + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_DISTRICT + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_ADDRESS + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_ASSIGNMENT + TEXT_TYPE + ")";



     String SQL_DROP_TABLE_USR =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}
