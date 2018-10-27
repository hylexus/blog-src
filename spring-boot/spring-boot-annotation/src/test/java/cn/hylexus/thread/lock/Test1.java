package cn.hylexus.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hylexus
 * createdAt 2018/4/8
 **/
public class Test1 {
    public static void main(String[] args) {

        Printer printer = new Printer();

        new Thread(() -> {
            while (true)
                printer.print("123");
        }).start();
        new Thread(() -> {
            while (true)
                printer.print("abc");
        }).start();
    }

    static class Printer {

        Lock lock = new ReentrantLock(false);

        void print(String str) {
            lock.lock();
            try {
                for (char c : str.toCharArray()) {
                    System.out.print(c);
                }
                System.out.println();
            } finally {
                lock.unlock();
            }
        }
    }
}
