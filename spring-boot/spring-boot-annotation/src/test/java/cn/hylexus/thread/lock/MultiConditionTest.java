package cn.hylexus.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hylexus
 * createdAt 2018/4/8
 **/
public class MultiConditionTest {

    public static void main(String[] args) {
        Runner runner = new Runner();

        new Thread(() -> {
            for (int i = 0; i < 3; i++)
                try {
                    runner.subTask1(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 3; i++)
                try {
                    runner.subTask2(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 3; i++)
                try {
                    runner.subTask3(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }).start();
    }

    static class Runner {
        private Lock lock = new ReentrantLock();
        Condition condition1 = this.lock.newCondition();
        Condition condition2 = this.lock.newCondition();
        Condition condition3 = this.lock.newCondition();

        private volatile int taskNo = 1;

        void subTask1(int seq) throws InterruptedException {
            this.lock.lock();

            while (taskNo != 1) {
                this.condition1.await();
            }
            try {
                for (int i = 1; i <= 3; i++) {
                    System.out.println("sub1 " + seq + "/" + i);
                }
                this.taskNo = 2;
                this.condition2.signalAll();
            } finally {
                this.lock.unlock();
            }
        }

        void subTask2(int seq) throws InterruptedException {
            this.lock.lock();

            while (taskNo != 2) {
                this.condition2.await();
            }
            try {
                for (int i = 1; i <= 3; i++) {
                    System.out.println("sub2 " + seq + "/" + i);
                }
                this.taskNo = 3;
                this.condition3.signalAll();
            } finally {
                this.lock.unlock();
            }
        }

        void subTask3(int seq) throws InterruptedException {
            this.lock.lock();

            while (taskNo != 3) {
                this.condition3.await();
            }
            try {
                for (int i = 1; i <= 3; i++) {
                    System.out.println("sub3 " + seq + "/" + i);
                }
                this.taskNo = 1;
                this.condition1.signalAll();
            } finally {
                this.lock.unlock();
            }
        }
    }
}
