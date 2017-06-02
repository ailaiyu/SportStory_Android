package cn.sportstory.android.common.sqliteContract;

/**
 * Created by aaron on 2017/6/2.
 */

public final class UserInfoContract {

    private UserInfoContract() {}
    public static final String TABLE_NAME = "USR";

    public static final String COLUMN_NAME_ID = "u_id";
    public static final String COLUMN_NAME_NICKNAME = "nickname";
    public static final String COLUMN_NAME_GENDER = "gender";
    public static final String COLUMN_NAME_AGE = "age";
    public static final String COLUMN_NAME_WEIGHT = "weight";
    public static final String COLUMN_NAME_AVATAR = "avatar";
    public static final String COLUMN_NAME_PHONE = "phone";
    public static final String COLUMN_NAME_EMAIL = "email";
    public static final String COLUMN_NAME_BACKGROUND = "background";
    public static final String COLUMN_NAME_HEIGHT = "height";
    public static final String COLUMN_NAME_CITY = "city";
    public static final String COLUMN_NAME_PROVINCE = "province";
    public static final String COLUMN_NAME_DISTRICT = "district";
    public static final String COLUMN_NAME_ADDRESS = "address";
    public static final String COLUMN_NAME_ASSIGNMENT = "assignment";


    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_TABLE_USR =
            "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_NICKNAME + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_GENDER + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_AGE + INTEGER_TYPE + COMMA_SEP +
                    COLUMN_NAME_WEIGHT + INTEGER_TYPE + COMMA_SEP +
                    COLUMN_NAME_AVATAR + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_PHONE + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_EMAIL + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_BACKGROUND + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_HEIGHT + INTEGER_TYPE + COMMA_SEP +
                    COLUMN_NAME_CITY + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_PROVINCE + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_DISTRICT + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_ADDRESS + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_ASSIGNMENT + TEXT_TYPE + ")";


    private static final String SQL_DROP_TABLE_USR =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}
