package cn.hylexus.thread.procons;

/**
 * @author hylexus
 * createdAt 2018/3/31
 **/
public class Main {
    public static void main(String[] args) {
        Container container=new Container(10);

        new Thread(new Producer(container)).start();
        new Thread(new Producer(container)).start();
        new Thread(new Producer(container)).start();
        new Thread(new Producer(container)).start();
        new Thread(new Producer(container)).start();
        new Thread(new Consumer(container)).start();
        new Thread(new Consumer(container)).start();
        new Thread(new Consumer(container)).start();
        new Thread(new Consumer(container)).start();
        new Thread(new Consumer(container)).start();
        new Thread(new Consumer(container)).start();
        new Thread(new Consumer(container)).start();
    }
}
