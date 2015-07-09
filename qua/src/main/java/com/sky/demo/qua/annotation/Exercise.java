package com.sky.demo.qua.annotation;

import java.lang.annotation.*;

/**
 * used to identify an exercise
 * 
 * @author sy
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
public @interface Exercise {
    /**
     * name for this exercise. naming is really a hard thing.
     */
    String name();

    /**
     * how hard the exercise
     */
    Difficulty difficulty() default Difficulty.EASY;

    /**
     * related classes for this exercise. you can use them, or take them as references
     */
    Class<?>[] related() default {};
}
