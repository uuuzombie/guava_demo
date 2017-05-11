package com.sky.demo.concurrent;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Monitor;

import java.util.List;

/**
 * Created by user on 17/5/11.
 */
public class MonitorDemo {

    private List<String> list = Lists.newArrayList();
    private static final int MAX_SIZE = 10;

    private Monitor monitor = new Monitor();  //监视器

    private Monitor.Guard guard = new Monitor.Guard(monitor) {
        @Override
        public boolean isSatisfied() {
            return list.size() < MAX_SIZE;
        }
    };


    public void add(String item) throws InterruptedException {

        monitor.enterWhen(guard);  //Guard(形如Condition)，不满足则阻塞

        try {
            list.add(item);
        } finally {
            monitor.leave();
        }

    }


}
