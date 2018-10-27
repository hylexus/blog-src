package cn.hylexus.thread;

import java.util.concurrent.Semaphore;

/**
 * @author hylexus
 * createdAt 2018/4/7
 **/
public class Test4 {

    public static void main(String[] args) {
        int count = 4;
        int workerCount = 10;

        Semaphore semaphore = new Semaphore(count);
        for (int i = 0; i < workerCount; i++) {
            new Worker(i, semaphore).start();
        }
    }

    static class Worker extends Thread {
        private int seq;
        private Semaphore semaphore;

        public Worker(int seq, Semaphore semaphore) {
            this.seq = seq;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                this.semaphore.acquire();

                System.out.println("worker " + seq + " get a chance");
                Thread.sleep(3000);
                System.out.println("worker " + seq + " done");
                this.semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
