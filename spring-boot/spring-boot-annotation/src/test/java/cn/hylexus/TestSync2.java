package cn.hylexus;

import org.junit.Test;

public class TestSync2 implements Runnable {
    int b = 100;

    synchronized void m1() throws InterruptedException {
        b = 1000;
        Thread.sleep(500);
        System.out.println(b);
    }

    synchronized void m2() throws InterruptedException {
        Thread.sleep(250);
        b = 2000;
    }

    @Override
    public void run() {
        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestSync2 sync2 = new TestSync2();
        Thread thread = new Thread(sync2);

        thread.start();
        sync2.m2();
        System.out.println("m->"+sync2.b);

//        Thread.sleep(5000);
    }
}