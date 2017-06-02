package cn.sportstory.android.common.tools;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;

import java.util.Calendar;

import cn.sportstory.android.R;

/**
 * Created by aaron on 2017/6/2.
 */

public class DateUtils {

    public static int[] constellations = {
            R.string.constellation_0,
            R.string.constellation_1,
            R.string.constellation_2,
            R.string.constellation_3,
            R.string.constellation_4,
            R.string.constellation_5,
            R.string.constellation_6,
            R.string.constellation_7,
            R.string.constellation_8,
            R.string.constellation_9,
            R.string.constellation_10,
            R.string.constellation_11,
    };

    /**
     * 计算年龄
     * @param date
     * @return
     */
    public static int getAge(String date){

        if (TextUtils.isEmpty(date))
            return 0;
        Calendar calendar = Calendar.getInstance();
        int birthY = Integer.parseInt(date.split("-")[0]);
        int birthM = Integer.parseInt(date.split("-")[1]);
        int birthD = Integer.parseInt(date.split("-")[2]);
        int todayY = calendar.get(Calendar.YEAR);
        int todayM = calendar.get(Calendar.MONTH);
        int todayD = calendar.get(Calendar.DATE);

        int age = todayY - birthY;
        if (birthM > todayM){
            return --age ;
        }else if (birthM == todayM ){
            if (birthD > todayD)
                return --age;
            else
                return age;
        }else {
            return age;
        }
    }

    /**
     * 根据日期获取对应星座名 按系统设置返回中英文名字
     * @param date
     * @param context
     * @return
     */
    public static String getConstellation(String date, Context context){
        int index = getConstellationId(date);
        return context.getApplicationContext().getString(constellations[index]);
    }


    /**
     * 计算星座位置， 第几个星座
     * @param birthday
     * @return
     */
    public static int getConstellationId(String birthday){
        if (birthday == null)
            return -1;
        int month = Integer.parseInt(birthday.split("-")[1]);
        int date = Integer.parseInt(birthday.split("-")[2]);
        if ((month == 1 && date >= 21) || (month == 2 && date < 19)) {
            return 0;
        } else if ((month == 2 && date >= 19) || (month == 3 && date < 19)) {
            return 1;
        } else if ((month == 3 && date >= 21) || (month == 4 && date < 21)) {
            return 2;
        } else if ((month == 4 && date >= 21) || (month == 5 && date < 22)) {
            return 3;
        } else if ((month == 5 && date >= 22) || (month == 6 && date < 22)) {
            return 4;
        } else if ((month == 6 && date >= 22) || (month == 7 && date < 23)) {
            return 5;
        } else if ((month == 7 && date >= 23) || (month == 8 && date < 23)) {
            return 6;
        } else if ((month == 8 && date >= 23) || (month == 9 && date < 24)) {
            return 7;
        } else if ((month == 9 && date >= 24) || (month == 10 && date < 24)) {
            return 8;
        } else if ((month == 10 && date >= 24) || (month == 11 && date < 23)) {
            return 9;
        } else if ((month == 11 && date >= 23) || (month == 12 && date < 22)) {
            return 10;
        } else if ((month == 12 && date >= 22) || (month == 1 && date < 21)) {
            return 11;
        } else {
            return -1;
        }
    }

}
