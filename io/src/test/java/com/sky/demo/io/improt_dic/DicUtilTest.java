package com.sky.demo.io.improt_dic;

import com.sky.demo.io.import_dic.DicUtil;
import org.junit.Test;

import java.util.Map;

/**
 * Created by rongguang on 2015/9/8.
 */
public class DicUtilTest {

    @Test
    public void test_importDic() {
        String path = "/dic.txt";

        Map<String, Integer> result = DicUtil.importDic(path);
        System.out.println(result);
    }
}
