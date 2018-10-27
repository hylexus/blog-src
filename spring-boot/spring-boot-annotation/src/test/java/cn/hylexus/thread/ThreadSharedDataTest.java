package cn.hylexus.thread;

import java.util.concurrent.Executors;

/**
 * @author hylexus
 * createdAt 2018/4/7
 **/
public class ThreadSharedDataTest {
    static class SharedData {
        private int val = 0;

        synchronized void incr() {
            val++;
            System.out.println(val);
        }

        synchronized void decr() {
            val--;
            System.out.println(val);
        }
    }


    public static void main(String[] args) {
        SharedData data = new SharedData();

        new Thread(() -> {
            for (int i = 0; i < 10; i++)
                data.incr();
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++)
                data.decr();
        }).start();

    }
}
