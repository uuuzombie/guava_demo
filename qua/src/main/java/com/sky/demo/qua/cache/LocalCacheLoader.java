package com.sky.demo.qua.cache;

import com.google.common.util.concurrent.ListenableFuture;

/**
 * 为构建{@link qua.cache.LocalCache}提供必要的构造方法,由使用者提供实现
 *
 * @author sy
 */
public interface LocalCacheLoader<T> {

    T load() throws Exception;

    /**
     * 提供默认的数据，如果调用{@link #load()}时发生错误
     *
     * @throws UnsupportedOperationException 如果不支持默认数据
     */
    T defaultData();

    /**
     * 刷新数据, 当切仅当存在旧数据时会调用. 应该提供异步的实现，来防止阻塞其他过程
     *
     * @param oldData 旧数据
     * @throws Exception
     */
    ListenableFuture<T> refresh(T oldData) throws Exception;

    /**
     * reload后，以及调用{@link LocalCache#destroy()}后会调用用以提供对象的销毁工作
     * @param data
     */
    void destroy(T data);
}
