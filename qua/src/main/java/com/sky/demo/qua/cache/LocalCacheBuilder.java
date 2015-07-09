package com.sky.demo.qua.cache;

import com.google.common.cache.LoadingCache;
import com.sky.demo.qua.annotation.Difficulty;
import com.sky.demo.qua.annotation.Exercise;


import java.util.concurrent.TimeUnit;

/**
 * <p>
 * LocalCache的Builder。使用例子如下
 * </p>
 * <code>
 *     LocalCache<T> cache = LocalCacheBuilder.from(new LocalCacheLoader<T>(){...}).preload(true).build();
 * </code>
 * 
 */
@Exercise(name = "LocalCacheBuilder", related = { LoadingCache.class }, difficulty = Difficulty.NIGHT_MARE)
public class LocalCacheBuilder<T> {

    public LocalCacheBuilder<T> from(LocalCacheLoader<? super T> loader) {
        // TODO implement this
        return this;
    }

    /**
     * 是否预读取
     * 
     * @param preload or not
     * @return the builder itself
     */
    public LocalCacheBuilder<T> preload(boolean preload) {
        // TODO implement this
        return this;
    }

    /**
     * 在多久没有访问之后刷新数据.刷新的应该由
     */
    public LocalCacheBuilder<T> refreshAfterAccess(long duration, TimeUnit timeUnit) {
        // TODO implement this
        return this;
    }

    /**
     * 指定在创建多久之后，数据需要被刷新
     */
    public LocalCacheBuilder<T> refreshAfterWrite(long duration, TimeUnit timeUnit) {
        // TODO implement this
        return this;
    }

    public LocalCache<T> build() {
        // TODO implement this
        return null;
    }

}
