package cn.hylexus.thread.procons;

/**
 * @author hylexus
 * createdAt 2018/3/31
 **/
public class Container {
    private final int capacity;
    private final Element[] elements;
    private int currentIndex = 0;

    public Container(int capacity) {
        this.capacity = capacity <= 100 ? capacity : 100;
        this.elements = new Element[capacity];
    }

    public void push(Element e) {
        synchronized (elements) {

            while (currentIndex >= capacity) {
                try {
                    this.elements.wait();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }

            this.elements[currentIndex++] = e;
            this.elements.notifyAll();
        }
    }

    public Element pop() {
        synchronized (elements) {
            while (currentIndex <= 0) {
                try {
                    this.elements.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            this.elements.notifyAll();
            return this.elements[--currentIndex];
        }
    }

    @Override
    public String toString() {
        return "container :" + this.currentIndex;
    }
}
