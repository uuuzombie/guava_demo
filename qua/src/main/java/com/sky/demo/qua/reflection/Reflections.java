package com.sky.demo.qua.reflection;

import com.google.common.reflect.TypeToken;
import com.sky.demo.qua.annotation.Difficulty;
import com.sky.demo.qua.annotation.Exercise;


/**
 * @author sy
 */
public class Reflections {

    /**
     * <p>
     * get the parameterized type of given class
     * </p>
     * <p>
     * for example: <code>
     *      class TestClazz extends Clazz<Test> {}
     * 
     *      getParameterizedType( TestClazz.class); //this should return Class<Test>
     * </code>
     * </p>
     * 
     * @throws IllegalArgumentException if we cannot determine the corresponding type
     * @return the parameterized type for the given class
     */
    @Exercise(name = "getParameterizedType using guava", difficulty = Difficulty.HARD, related = TypeToken.class)
    public Class<?> getParameterizedType(Class<? extends Clazz> klass) {
        // TODO implement this
        return null;
    }

    /**
     * the result should be identical to {@link #getParameterizedType(Class)}, but you should implement is without using
     * classes in guava ( you can find the solution with reading the corresponding code in
     * {@link com.google.common.reflect.TypeToken})
     *
     * @throws IllegalArgumentException if we cannot determine the corresponding type
     * @return the parameterized type for the given class
     */
    @Exercise(name = "getParameterizedType without guava", difficulty = Difficulty.HARD, related = TypeToken.class)
    public Class<?> getParameterizedTypeWithoutGuava(Class<? extends Clazz> klass) {
        // TODO implement this
        return null;
    }

    public static class Clazz<T> {

    }

}
