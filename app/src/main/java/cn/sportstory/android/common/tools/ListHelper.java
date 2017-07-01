package cn.sportstory.android.common.tools;

import java.util.List;

/**
 * Created by aaron on 2017/7/1.
 */

public class ListHelper {
    public static boolean isEmpty(List list) {
        if (list == null || list.size() == 0)
            return true;
        return false;
    }

    public static int CountOfList(List list){
        return list == null ? 0 : list.size();
    }

}
