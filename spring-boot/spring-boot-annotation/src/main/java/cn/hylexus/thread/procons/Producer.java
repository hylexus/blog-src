package cn.hylexus.thread.procons;

import java.util.Random;

/**
 * @author hylexus
 * createdAt 2018/3/31
 **/
public class Producer implements Runnable {

    private Container container;

    public Producer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String name = Thread.currentThread().getName();
            Element element = new Element("Element-" + name + "-" + i);
            this.container.push(element);
            System.out.println("生产者[" + name + "] +++++++" + element.getName() + " " + container);
            try {
                Random random = new Random();
                Thread.sleep(random.nextInt(200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
