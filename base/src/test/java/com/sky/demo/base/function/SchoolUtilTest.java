package com.sky.demo.base.function;


import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sky.demo.base.model.School;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SchoolUtilTest {

    private List<School> schoolList = Lists.newArrayList();

    @Before
    public void setUp(){
        schoolList.addAll(Arrays.asList(
                School.newInstance("school 1", "street 1"),
                School.newInstance("school 2", "street 2"),
                School.newInstance("school 3", "street 3")));
    }



    @Test
    public void test_Function_School_to_String(){
        System.out.println(schoolList);

        //将School类转为地址字符串
        List<String> list = Lists.transform(schoolList,new Function<School, String>() {
            @Override
            public String apply(School input) {
                if (input == null){
                    return "";
                }
                return input.getLocation();
            }
        });
        System.out.println(list);
    }

    @Test
    public void test_Function_Merge(){
        System.out.println(schoolList);

        List<String> upList = Lists.transform(schoolList,SchoolUtil.transferMerge);
        System.out.println(upList);
    }

    @Test
    public void test_Function_forMap(){
        System.out.println(schoolList);

        Map<School , String> map = Maps.newHashMap();
        map.put(schoolList.get(0),"hangtian");
        //map.put(schoolList.get(1),"tielu");

        List<String> list = Lists.transform(schoolList, Functions.forMap(map, "UnKnown"));
        System.out.println(list);
    }

}
