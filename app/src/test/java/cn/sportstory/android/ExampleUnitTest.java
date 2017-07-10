package cn.sportstory.android;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testSplit() throws Exception {
        String imageUrls="http://hahhah";
        String[] imageUrlArray=imageUrls.split(";");
        List<String> imageUrlList=new ArrayList<>();
        Collections.addAll(imageUrlList,imageUrlArray);

        System.out.println("array length : "+ imageUrlArray.length);
        System.out.println("list size : "+imageUrlList.size());
    }
}