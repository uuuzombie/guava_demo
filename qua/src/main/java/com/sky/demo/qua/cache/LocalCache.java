package com.sky.demo.qua.cache;

import com.google.common.util.concurrent.ListenableFuture;

/**
 * @author sy
 */
public interface LocalCache<T> {

    /** 
     * <p>
     * get the data from the cache or load it from the corresponding loader
     * </p>
     * <p>
     * if the loader throw an exception, return its default value
     * </p>
     * 
     * @throws IllegalStateException if the cache is destroyed
     * @return the value in the cache
     */
    T get();

    /**
     * reload the cache, possibly asynchronously. The original value, if exists, should be available for others to
     * retrieve through {@link #get()}
     */
    ListenableFuture<T> reload();

    /**
     * destroy the cache and release all the resources
     *
     * @throws IllegalStateException if the cache is destroyed
     */
    void destroy();
}
