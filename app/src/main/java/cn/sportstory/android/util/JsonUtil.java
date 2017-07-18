package cn.sportstory.android.util;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Tamas on 2017/7/17.
 */

public class JsonUtil {
    public static    <T> List<T> getListFromJSON(String json, Class<T[]> type) {
        T[] list = new Gson().fromJson(json, type);
        return Arrays.asList(list);
    }
}
