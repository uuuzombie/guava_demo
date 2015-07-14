package com.sky.demo.base.function;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.sky.demo.base.model.School;

/**
 * Created by rg on 15/7/12.
 */
public class SchoolUtil {

    //1、定义第一个功能函数，用于将School类转为地址字符串，即：f(school)=location
    public static Function<School,String> transferSchoolToString = new Function<School, String>() {
        @Override
        public String apply(School input) {
            if (input == null) {
                return "";
            }
            return input.getLocation();
        }
    };

    //2、定义第二个功能函数，用于转换大小写，即：f(string)=STRING
    public static Function<String,String> transferLowToUp = new Function<String, String>() {
        @Override
        public String apply(String input) {
            if (input == null) {
                return "";
            }
            return input.toUpperCase();
        }
    };

    //3、定义函数组合，将对每个元素执行f，然后对结果进行f2计算，即：result=f2(f(school))
    public static Function<School,String> transferMerge = Functions.compose(transferLowToUp, transferSchoolToString);

}
