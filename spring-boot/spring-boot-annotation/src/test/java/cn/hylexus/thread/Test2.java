package cn.hylexus.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author hylexus
 * createdAt 2018/4/7
 **/
public class Test2 {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch=new CountDownLatch(2);

        new Thread(() -> {
            System.out.println("t1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            System.out.println("t2");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();
        System.out.println("main ... ");
    }

}
