package com.sky.demo.qua.collect;

import com.google.common.collect.*;
import com.sky.demo.qua.annotation.Difficulty;
import com.sky.demo.qua.annotation.Exercise;


import java.util.Comparator;
import java.util.List;

/**
 * 种群计数
 * 
 * @author sy
 */
@Exercise(name = "GroupCounter", difficulty = Difficulty.NORMAL, related = {Multiset.class, Ordering.class})
public class GroupCounter<E> {

    private Multiset<E> multiset = ConcurrentHashMultiset.create();  // HashMultiset unsafe

    public GroupCounter() {
    }

    /**
     * 添加计数, 应该保证并发安全
     */
    public void add(E ele) {
        // TODO implement this
        multiset.add(ele);
    }

    /**
     * 获取topX
     */
    public List<E> getTop(int top) {
        // TODO implement this

        Iterable<Multiset.Entry<E>> entriesSortedByCount =
                Multisets.copyHighestCountFirst(multiset).entrySet();

//        Iterable<Multiset.Entry<E>> entriesSortedByValue =
//                ImmutableSortedMultiset.copyOf(multiset).entrySet();

//        List<E> list = Lists.asList(entriesSortedByCount.);
        return null;
    }
}
