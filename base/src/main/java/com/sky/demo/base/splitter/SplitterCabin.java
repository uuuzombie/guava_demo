package com.sky.demo.base.splitter;

import com.google.common.base.Splitter;
import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.Map;

public class SplitterCabin {

    public static Map<String,String> getCabins(String keyStr,String cabinStr){

        Map<String,String> keyToCabin = Maps.newHashMap();

        Iterable<String> keys = Splitter.on("~").omitEmptyStrings().trimResults().split(keyStr);
        Iterable<String> cabins = Splitter.on("~").omitEmptyStrings().trimResults().split(cabinStr);

        Iterator<String> iterator1 = keys.iterator();
        Iterator<String> iterator2 = cabins.iterator();

        while(iterator1.hasNext() && iterator2.hasNext()){
            Iterable<String> splitKeys = Splitter.on("/").omitEmptyStrings().trimResults().split(iterator1.next());
            Iterable<String> splitCabins = Splitter.on("/").omitEmptyStrings().trimResults().split(iterator2.next());

            Iterator<String> it1 = splitKeys.iterator();
            Iterator<String> it2 = splitCabins.iterator();
            while(it1.hasNext() && it2.hasNext()){
                keyToCabin.put(it1.next(),it2.next());

            }
        }

        return keyToCabin;
    }
}
