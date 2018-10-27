package cn.hylexus.thread.lock;

import cn.hylexus.thread.CommunicationTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hylexus
 * createdAt 2018/4/8
 **/
public class ConditionTest {

    static class Runner {
        private Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        private boolean shouldSubRunning = true;


        void subTask(int seq) throws InterruptedException {
            this.lock.lock();

            while (!shouldSubRunning) {
                this.condition.await();
            }
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("sub " + seq + "/" + i);
                }
                shouldSubRunning = false;
                this.condition.signalAll();
            } finally {
                this.lock.unlock();
            }
        }

        void mainTask(int seq) throws InterruptedException {
            this.lock.lock();

            while (shouldSubRunning) {
                this.condition.await();
            }
            try {
                for (int i = 1; i <= 3; i++) {
                    System.out.println("main " + seq + "/" + i);
                }
                shouldSubRunning = true;
                this.condition.signalAll();
            } finally {
                this.lock.unlock();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    runner.subTask(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        for (int i = 1; i <= 10; i++) {
            runner.mainTask(i);
        }
    }
}
