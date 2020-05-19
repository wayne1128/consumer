package com.wya.items;

import com.wya.items.utils.HttpClient;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        for (int i = 0; i < 5; i++) {
            System.out.println(sdf.format(new Date()));
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    String result = HttpClient.doPost("http://localhost:8080/warfalcon/anno/testAnnotation", "");
                    System.out.println(result);
                }
            }, "sub_thread_" + i);
            thread.start();
        }
    }
}
