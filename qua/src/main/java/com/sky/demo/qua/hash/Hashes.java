package com.sky.demo.qua.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.Hashing;
import com.sky.demo.qua.annotation.Difficulty;
import com.sky.demo.qua.annotation.Exercise;


/**
 * @author sy
 */
@Exercise(name = "Hashes", difficulty = Difficulty.EASY)
public abstract class Hashes {

    private Hashes() {
    }

    public static String md5(String string) {
        // TODO implement this
        Preconditions.checkNotNull(string);
        return Hashing.md5().hashUnencodedChars(string).toString();
    }

    /**
     *
     * {@see http://en.wikipedia.org/wiki/MurmurHash}
     * {@see http://jsperf.com/murmur3-performance}
     */
    public static String murmur3_32(String string, int seed) {
        // TODO implement this
        Preconditions.checkNotNull(string);
    	return Hashing.murmur3_32(seed).hashUnencodedChars(string).toString();
    }
}
