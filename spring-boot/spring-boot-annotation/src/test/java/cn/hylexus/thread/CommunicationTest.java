package cn.hylexus.thread;

/**
 * @author hylexus
 * createdAt 2018/4/7
 **/
public class CommunicationTest {

    static class Runner {

        private boolean shouldSubRunning = true;

        synchronized void subTask(int i) throws InterruptedException {
            while (!shouldSubRunning) {
                this.wait();
            }
            for (int j = 1; j <= 5; j++) {
                System.out.println("shouldSubRunning seq : " + i + "/" + j);
            }
            shouldSubRunning = false;
            this.notifyAll();
        }

        synchronized void mainTask(int i) throws InterruptedException {
            while (shouldSubRunning) {
                this.wait();
            }
            for (int j = 1; j <= 3; j++) {
                System.out.println("main seq : " + i + "/" + j);
            }

            shouldSubRunning = true;
            this.notifyAll();
        }
    }

    public static void main(String[] args) throws Exception {
        Runner runner = new Runner();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    runner.subTask(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        for (int i = 1; i <= 10; i++) {
            runner.mainTask(i);
        }
    }
}
