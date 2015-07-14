package com.sky.demo.collect;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.Collection;
import java.util.Map;

/**
 * Created by rg on 15/7/11.
 */
public class MultimapTest {

    @Test
    public void test_Multimap(){
        Multimap<Integer, String> multimap = ArrayListMultimap.create();
        for (int i = 0; i < 5; i++) {
            multimap.put(i, "a" + String.valueOf(i + 10));
        }

        for (int i = 0; i < 10; i++) {
            multimap.put(i, "a" + String.valueOf(i));
        }

        System.out.println(multimap.size());
        System.out.println(multimap);                   //Multimap可重复键值对

        Map<Integer, Collection<String>> map = multimap.asMap();        //map不可重复键值对，将Multimap转换到map中
        for (Map.Entry<Integer, Collection<String>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            System.out.println(key + ":" + entry.getValue());
        }
    }
}
