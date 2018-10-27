package cn.hylexus.thread.procons;

import java.util.Random;

/**
 * @author hylexus
 * createdAt 2018/3/31
 **/
public class Consumer implements Runnable {

    private Container container;

    public Consumer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Element element = this.container.pop();
            String name = Thread.currentThread().getName();
            System.out.println("消费者[" + name + "] -------" + element.getName() + " " + container);

            try {
                Random random = new Random();
                Thread.sleep(random.nextInt(300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
