package com.sky.demo.qua.base;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import org.javatuples.Pair;
import org.javatuples.Triplet;

import javax.annotation.Nullable;

/**
 * @author sy
 */
@SuppressWarnings("ConstantConditions")
public abstract class Functions {
    
    private Functions() {
    }

    public static abstract class Function0<R> implements Function<Void, R> {

        public abstract R apply();

        @Nullable
        @Override
        public R apply(@Nullable Void input) {
            return this.apply();
        }
    }


    public static abstract class Function1<R, T1> implements Function<T1, R> {

    }

    public static abstract class Function2<R, T1, T2> implements Function<Pair<T1, T2>, R> {

        public abstract R apply(T1 t1, T2 t2);

        @Override
        public R apply(@Nullable Pair<T1, T2> input) {
            Preconditions.checkArgument(input != null, "input cannot be null");
            //noinspection ConstantConditions
            return this.apply(input.getValue0(), input.getValue1());
        }
    }

    public static abstract class Function3<R, T1, T2, T3> implements Function<Triplet<T1, T2, T3>, R> {

        public abstract R apply(T1 t1, T2 t2, T3 t3);

        @Nullable
        @Override
        public R apply(@Nullable Triplet<T1, T2, T3> input) {
            Preconditions.checkArgument(input != null, "input cannot be null");
            //noinspection ConstantConditions
            return this.apply(input.getValue0(), input.getValue1(), input.getValue2());
        }
    }

}
