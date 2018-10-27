package cn.hylexus.thread;

/**
 * @author hylexus
 * createdAt 2018/4/7
 **/
public class Test5 {

    public static void main(String[] args) throws InterruptedException {
        Runner r1 = new Runner(null);
        Runner r2 = new Runner(r1);
        Runner r3 = new Runner(r2);


        r2.start();
        r3.start();
        r1.start();

        r3.join();

    }

    static class Runner extends Thread{

        Thread prev;

        public Runner(Thread prev) {
            this.prev = prev;
        }

        @Override
        public void run() {
            try {
                if(prev!=null) {
                    prev.join();
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " done");
        }
    }
}
