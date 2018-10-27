package cn.hylexus.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

/**
 * @author hylexus
 * createdAt 2018/4/7
 **/
public class Test3 {

    public static void main(String[] args) {
        int limit = 4;
        CyclicBarrier barrier = new CyclicBarrier(limit);

        for (int i = 0; i < limit; i++) {
            new Writer(barrier).start();
        }
    }

    static class Writer extends Thread {
        private CyclicBarrier barrier;

        public Writer(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + "op-1...");
                barrier.await();

                System.out.println(Thread.currentThread().getName() + "op-02...");
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "op-03 ...");
        }
    }

}
