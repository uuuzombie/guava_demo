package com.sky.demo.qua.primitive;

import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.sky.demo.qua.annotation.Difficulty;
import com.sky.demo.qua.annotation.Exercise;


import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;

/**
 * @author sy
 */
@Exercise(name = "PrimitiveAllInOne", difficulty = Difficulty.EASY)
public abstract class PrimitiveAllInOne {

    private PrimitiveAllInOne() {

    }

    public static byte[] toByteArray(long value) {
        // TODO implement this
    	return Longs.toByteArray(value);
    }

    public static long longFromByteArray(byte[] bytes) {
        // TODO implement this
    	return Longs.fromByteArray(bytes);
    }

    public static byte[] toByteArray(int value) {
        // TODO implement this
    	return Ints.toByteArray(value);
    }

    public static int intFromByteArray(byte[] bytes) {		//int
        // TODO implements this
    	return Ints.fromByteArray(bytes);
    }

    public static byte[] toByteArray(float value) {
        // TODO implement this
    	return ByteBuffer.allocate(4).putFloat(value).array();
    }

    public static float floatFromByteArray(byte[] bytes) {
        // TODO implement this
    	return ByteBuffer.wrap(bytes).getFloat();
    	
    }

    public static byte[] toByteArray(double value) {
        // TODO implement this
    	return ByteBuffer.allocate(8).putDouble(value).array();
    }

    public static double doubleFromByteArray(byte[] bytes) {
        // TODO implement this
    	return ByteBuffer.wrap(bytes).getDouble();
    }

    public static int[] toArray(Collection<? extends Number> collection) {
        // TODO implement this
    	return Ints.toArray(collection);
    }

    public static List<Integer> asList(int... values) {
        // TODO implement this
        return Ints.asList(values);
    }

    public static int indexOf(int[] array, int value) {
        // TODO implement this
    	return Ints.indexOf(array, value);
    }
}
