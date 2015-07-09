package com.sky.demo.qua.math;

import com.google.common.math.DoubleMath;
import com.google.common.math.IntMath;
import com.sky.demo.qua.annotation.Difficulty;
import com.sky.demo.qua.annotation.Exercise;

import java.math.RoundingMode;

/**
 * @author sy
 */
@Exercise(name = "MathAllInOne", difficulty = Difficulty.EASY)
public abstract class MathAllInOne {

    private MathAllInOne() {

    }

    public static int fuzzilyCompareDouble(double v1, double v2, double tolerance) {
        // TODO implement this
    	return DoubleMath.fuzzyCompare(v1, v2, tolerance);
    }

    /**
     * Returns the greatest common divisor of {@code a, b}. Returns {@code 0} if {@code a == 0 && b == 0}.
     * 
     * @throws IllegalArgumentException if {@code a < 0} or {@code b < 0}
     */
    public static int gcd(int a, int b) {
        // TODO implement this
    	return IntMath.gcd(a, b);
    }

    /**
     * Returns the least common multiple of {@code a, b}, Returns {@code 0} if {@code a == 0 && b == 0}
     * 
     * @throws IllegalArgumentException if {@code a < 0} or {@code b < 0}
     */
    public static int lcm(int a, int b) {
        // TODO implement this
    	int gcm = IntMath.gcd(a, b);
    	
    	if (gcm != 0) {
			return a * b / gcm;
		} else {
			return 0;
		}
    }

    /**
     * Returns the arithmetic mean of {@code x} and {@code y}.
     * 
     */
    public static int mean(int a, int b) {
        // TODO implement this
        //return (a + b) / 2; // this is wrong, why?
    	return IntMath.mean(a, b);
    }

    /**
     * Returns {@code n} choose {@code k}(C{k, n}), also known as the binomial coefficient of {@code n} and {@code k},
     * or {@link Integer#MAX_VALUE} if the result does not fit in an {@code int}.
     * 
     * @throws IllegalArgumentException if {@code n < 0}, {@code k < 0} or {@code k > n}
     */
    public static int binomial(int n, int k) {
        // TODO implement this
    	return IntMath.binomial(n, k);
    }

    /**
     * Returns {@code true} if {@code x} represents a power of two.
     * 
     * <p>
     * This differs from {@code Integer.bitCount(x) == 1}, because {@code Integer.bitCount(Integer.MIN_VALUE) == 1}, but
     * {@link Integer#MIN_VALUE} is not a power of two.
     */
    public static boolean isPowerOfTwo(int x) {
        // TODO implement this
    	return IntMath.isPowerOfTwo(x);
    }

    /**
     * Returns the result of dividing {@code p} by {@code q}, rounding towards negative infinity
     */
    public static int divFloor(int p, int q) {
        // TODO implement this
    	return IntMath.divide(p, q, RoundingMode.FLOOR);
    }

    /**
     * Returns the result of dividing {@code p} by {@code q}, rounding towards positive infinity
     */
    public static int divCeiling(int p, int q) {
        // TODO implement this
    	return IntMath.divide(p, q, RoundingMode.CEILING);
    }
}
