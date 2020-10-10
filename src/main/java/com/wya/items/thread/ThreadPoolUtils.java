package com.wya.items.thread;

import java.util.concurrent.*;

public class ThreadPoolUtils {
    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
    }

    /*public static ExecutorService newSingleThreadExecutor() {
        return new FinalizableDelegatedExecutorService(new ThreadPoolExecutor(1, 1, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()));
    }*/

    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, 30, 60L,
                TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
    }
}
