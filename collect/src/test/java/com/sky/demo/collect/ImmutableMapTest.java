package com.sky.demo.collect;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Map;

/**
 * Created by rg on 2016/6/6.
 */
public class ImmutableMapTest {

    @Test
    public void test_of() {
        // looking for of() with > 5 entries? Use the builder instead
        ImmutableMap<String, String> immutableMap = ImmutableMap.of("k1", "v1", "k2", "v2",
                "k3", "v3", "k4", "v4", "k5", "v5");

        System.out.println(immutableMap);
    }

    @Test
    public void test_builder() {
        // looking for of() with > 5 entries? Use the builder instead
        ImmutableMap.Builder<String, String> mapBuilder = new ImmutableMap.Builder<String, String>();
        ImmutableMap<String, String> immutableMap = mapBuilder.put("k1", "v1")
                .put("k2", "v2").put("k3", "v3").put("k4", "v4").put("k5", "v5").put("k6", "v6").build();

        System.out.println(immutableMap);
    }





}
