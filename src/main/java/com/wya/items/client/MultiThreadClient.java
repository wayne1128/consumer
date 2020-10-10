package com.wya.items.client;

import com.wya.items.thread.ThreadPoolUtils;
import com.wya.items.utils.HttpClient;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * 使用CountdownLatch计数器模拟多线程并发：调用await()方法阻塞当前线程，当计数完成后，唤醒所有线程并发执行。
 */
public class MultiThreadClient {
    public static void main(String[] args) {

        ExecutorService exec = ThreadPoolUtils.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        for (int i = 0; i < 5; i++) {
            System.out.println(sdf.format(new Date()));
            exec.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
                        countDownLatch.await();
                        System.out.println(sdf.format(new Date()));
                        String result = HttpClient.doPost("http://localhost:8080/warfalcon/anno/testAnnotation", "");
                        System.out.println(URLDecoder.decode(result));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "sub_thread_" + i);
        }
        countDownLatch.countDown();
        exec.shutdown();
    }
}