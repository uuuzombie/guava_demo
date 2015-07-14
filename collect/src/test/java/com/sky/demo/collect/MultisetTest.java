package com.sky.demo.collect;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import org.junit.Test;

import java.util.Set;

/**
 * Created by rg on 15/7/11.
 */
public class MultisetTest {

    @Test
    public void test_Multiset(){
        Multimap<Integer, String> multimap = ArrayListMultimap.create();
        for (int i = 0; i < 10; i++) {
            multimap.put(i, "a" + String.valueOf(i));
        }

        for (int i = 0; i < 5; i++) {
            multimap.put(i, "a" + String.valueOf(i + 10));
        }

        Multiset<Integer> multiset = multimap.keys();   //Multiset可重复集合
        System.out.println(multiset.size());
        System.out.println(multiset);

        Set<Integer> set = multimap.keySet();       //Set不重复集合
        System.out.println(set.size());
        System.out.println(set);

    }

}
