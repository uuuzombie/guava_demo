package com.sky.demo.concurrent;

import org.junit.Test;

/**
 * Created by user on 17/5/10.
 */
public class MonitorTest {


    @Test
    public void test_add() throws InterruptedException {

        MonitorDemo monitorDemo = new MonitorDemo();

        for (int i = 0; i < 20; i++) {
            monitorDemo.add(String.valueOf(i));
        }

    }
}
