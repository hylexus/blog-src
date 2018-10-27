package cn.hylexus.thread.lock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author hylexus
 * createdAt 2018/4/8
 **/
public class ReadWriteLockTest {
    public static void main(String[] args) {
        MyContainer container = new MyContainer();
        new Thread(() -> {
            try {
                while (true) {
                    container.pop();
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                while (true) {
                    container.push();
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    static class MyContainer {

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        void pop() throws InterruptedException {
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "------ 01");
            Thread.sleep(new Random().nextInt(2000));
            System.out.println(Thread.currentThread().getName() + "------ 02");
            readWriteLock.readLock().unlock();
        }

        void push() throws InterruptedException {
            readWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "++++++ 01");
            Thread.sleep(new Random().nextInt(10));
            System.out.println(Thread.currentThread().getName() + "++++++ 02");
            readWriteLock.writeLock().unlock();
        }
    }

}
