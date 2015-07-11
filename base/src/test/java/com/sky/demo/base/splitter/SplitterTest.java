package com.sky.demo.base.splitter;

import com.google.common.base.Splitter;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by rg on 15/7/11.
 */
public class SplitterTest {
    @Test
    public void test_split(){
        String tmp = "foo , what,,,more,";

        String[] splitStr = tmp.split(",");
        System.out.println("String.split()");
        for (int i = 0; i < splitStr.length; i++) {
            System.out.println(splitStr[i]);
        }

        Iterable<String> splitStr2 = Splitter.on(",").split(tmp);
        System.out.println(splitStr2);

        Iterable<String> splitStr3 = Splitter.on(",").trimResults().split(tmp);
        System.out.println(splitStr3);

        Iterable<String> splitStr4 = Splitter.on(",").omitEmptyStrings().trimResults().split(tmp);
        System.out.println(splitStr4);
    }

    @Test
    public void test_split_cabin(){

        String tmp1 = "Y~";
        String tmp2 = "Y/B~";
        String tmp3 = "D~Y";
        String tmp4 = "Y/C~B/B";

        Iterable<String> splitStr1 = Splitter.on("~").omitEmptyStrings().trimResults().split(tmp1);
        Iterable<String> splitStr2 = Splitter.on("~").omitEmptyStrings().trimResults().split(tmp2);
        Iterable<String> splitStr3 = Splitter.on("~").omitEmptyStrings().trimResults().split(tmp3);
        Iterable<String> splitStr4 = Splitter.on("~").omitEmptyStrings().trimResults().split(tmp4);

        System.out.println(splitStr1);
        System.out.println(splitStr2);
        System.out.println(splitStr3);
        System.out.println(splitStr4);

        Set<String> cabins = Sets.newHashSet();

        for (String it : splitStr1){
            Iterable<String> split = Splitter.on("/").omitEmptyStrings().trimResults().split(it);
            for (String str:split) {
                cabins.add(str);
            }
        }

        for (String it : splitStr2){
            Iterable<String> split = Splitter.on("/").omitEmptyStrings().trimResults().split(it);
            for (String str:split) {
                cabins.add(str);
            }
        }

        for (String it : splitStr3){
            Iterable<String> split = Splitter.on("/").omitEmptyStrings().trimResults().split(it);
            for (String str:split) {
                cabins.add(str);
            }
        }

        for (String it : splitStr4){
            Iterable<String> split = Splitter.on("/").omitEmptyStrings().trimResults().split(it);
            for (String str:split) {
                cabins.add(str);
            }
        }
        System.out.println(cabins);
    }

    @Test
    public void test_split_cabin2(){
        List<String> listKeys = Arrays.asList("MU535~", "MU535/MU5081~", "CA535~CA536", "CA535/CA5555~CA536/CA3333");
        List<String> listCabins = Arrays.asList("Y~", "Y/B~", "D~Y", "Y/C~B/B");
        for(int i = 0;i < listKeys.size();++i) {
            Map<String,String> map = SplitterCabin.getCabins(listKeys.get(i),listCabins.get(i));
            System.out.println(map);
        }
    }

    @Test
    public void test_split_cabin3(){
        List<String> listKeys = Arrays.asList("MU535", "MU535/MU5081");
        List<String> listCabins = Arrays.asList("Y", "Y/B");
        for(int i = 0;i < listKeys.size();++i) {
            Map<String,String> map = SplitterCabin.getCabins(listKeys.get(i),listCabins.get(i));
            System.out.println(map);
        }
    }

    @Test
    public void test_Splitter_MapSplitter(){
        //String param = "http://kti.trade.qunar.com/inter/book/fill?fromTransfer=&digest=c56971c733e1122d098a45cf235f7e1e&mpk=&deptDate=2015-02-22&deptAirport=PEK&arriAirport=HKG&qt=26cb3af47904005A&flightQueryId=192.168.13.34%3A3e617e93%3A149cb375187%3A1a1b%3A1416453878661&d=xpdyE14T8UY%2B%2BhXV8nxiPUGhA9b5MzgUHlSu%2FifLUZmv0Fgh7bylewtIx7JOt%2BxQrQQCkgQBBIKXKY4Bz3wFvFb%2BG%2FpnpzmR4OOj8prxS8JZJoETrXcpdU0JPKus0%2Fjp9Hp3z80wxO4EGD5NhD%2FVZ%2BiXlLk6f7uQCLqyNVBmHYEwPvBusLf4kQ%3D%3D&isppr=true&prt=1&vtype=booking&k=0&deptTime=12%3A30&retTransfer=false";
        //String param = "cabin=D~D&isppr=true&prt=1&fromTransfer=false&digest=3769bdaa53915d7c2d1df22938e3325b&vtype=booking&flytype=2&returnDate=2015-01-16&deptTime=09:05~13:20&mpk=&price=10&tax=0.0&source=baidu.zhixin.hui&fromDate=2015-01-09&retTransfer=false&deptDate=2015-01-09~2015-01-16&toCity=HKG&deptAirport=PEK~HKG&pinfo=13#5&arriAirport=HKG~PEK&fromCity=PEK&qt=86cb827c9f01011&key=CZ310~CZ309&flightQueryId=10.86.37.112:-76b4f732:149cb7a883a:-7fed:1416458564271";
        String param = "cabin=Y&prt=0&fromTransfer=false&digest=9d77f60aef264a117eb33b5c7e058a71&vtype=booking&flytype=1&returnDate=&deptTime=13:30&mpk=&price=11&fromDate=2015-01-11&tax=0.0&retTransfer=false&deptDate=2015-01-11&toCity=HKG&deptAirport=PEK&pinfo=11#74&arriAirport=HKG&fromCity=PEK&qt=86d18db30d03005&key=CX391&flightQueryId=10.86.37.112:-58e01c6:149d11e6143:-7eb8:1416559964807";
        Map<String,String> map = Splitter.on("&").omitEmptyStrings().trimResults().withKeyValueSeparator("=").split(param);

        for (Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
