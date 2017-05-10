package com.sky.demo.qua.collect;

import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.sky.demo.qua.annotation.Difficulty;
import com.sky.demo.qua.annotation.Exercise;


import java.util.List;

/**
 * 种群计数
 * 
 * @author sy
 */
@Exercise(name = "GroupCounter", difficulty = Difficulty.NORMAL, related = {Multiset.class, Ordering.class})
public class GroupCounter<E> {

//    private Multiset multiset = new ConcurrentHashMultiset();

    public GroupCounter() {

    }

    /**
     * 添加计数, 应该保证并发安全
     */
    public void add(E ele) {
        // TODO implement this
    }

    /**
     * 获取topX
     */
    public List<E> getTop(int top) {
        // TODO implement this
        return null;
    }
}
