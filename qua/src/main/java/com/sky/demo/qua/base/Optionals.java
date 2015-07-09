package com.sky.demo.qua.base;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.sky.demo.qua.annotation.Difficulty;
import com.sky.demo.qua.annotation.Exercise;


/**
 * @author sy
 */
@Exercise(name = "Optionals", difficulty = Difficulty.NORMAL, related = { Optional.class, Function.class })
public abstract class Optionals {

    private Optionals() {
    }

    public static <R> Functions.Function0<Optional<R>> lift0(Functions.Function0<R> function) {
        // TODO implement this
    	// new 判断  返回
    	
//    	final Functions.Function0<R> f = function;
//    	
//    	return new Function0<Optional<R>>() {
//    		
//		};
    	
        return null;
    }

    /**
     * @see {@link #lift3}
     */
    public static <R, T1> Functions.Function1<Optional<R>, Optional<T1>> lift1(Functions.Function1<R, T1> function) {
        // TODO implement this
        return null;
    }

    /**
     * @see {@link #lift3}
     */
    public static <R, T1, T2> Functions.Function2<Optional<R>, Optional<T1>, Optional<T2>> lift2(
            Functions.Function2<R, T1, T2> function) {
        // TODO implement this
        return null;
    }

    /**
     * lift an ordinary function to make it optional-friendly( Accepts Optional arguments, and return and optional
     * value)
     * 
     * @param function the function to be left
     * @param <R> type for return value
     * @param <T1> type for first argument
     * @param <T2> type for second argument
     * @param <T3> type for third argument
     */
    public static <R, T1, T2, T3> Functions.Function3<Optional<R>, Optional<T1>, Optional<T2>, Optional<T3>> lift3(
            Functions.Function3<R, T1, T2, T3> function) {
        // TODO implement this
        return null;
    }
}
