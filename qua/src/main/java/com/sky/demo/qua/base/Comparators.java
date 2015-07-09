package com.sky.demo.qua.base;

import com.google.common.primitives.Longs;
import com.sky.demo.qua.annotation.Difficulty;
import com.sky.demo.qua.annotation.Exercise;


import java.util.Comparator;

/**
 * @author sy
 */
@Exercise(name = "Comparators", difficulty = Difficulty.EASY, related = Longs.class)
public class Comparators {

    public static class LongComparator implements Comparator<LongHolder> {

        @Override
        public int compare(LongHolder o1, LongHolder o2) {
            // TODO fix this implementation, and write a unit test to prove that yours are correct
        	return Longs.compare(o1.value, o2.value);
        }
    }

    public static class LongHolder {
        private final long value;

        public LongHolder(long value) {
            this.value = value;
        }

        public long getValue() {
            return value;
        }
    }
}
