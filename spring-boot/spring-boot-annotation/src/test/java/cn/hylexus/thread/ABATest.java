package cn.hylexus.thread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author hylexus
 * createdAt 2018/4/6
 **/
public class ABATest {

    static class ConcurrentStack1 {
        AtomicReference<Node> atomic = new AtomicReference<>();

        void push(String item) {
            Node newVal = new Node(item);
            Node oldVal;

            do {
                oldVal = atomic.get();
                newVal.next = oldVal;
            } while (!atomic.compareAndSet(oldVal, newVal));

        }

        String pop() {
            Node newVal, oldVal;

            do {
                oldVal = atomic.get();
                if (oldVal == null) {
                    return null;
                }

                newVal = oldVal.next;
            } while (!atomic.compareAndSet(oldVal, newVal));

            return oldVal.item;
        }
    }

    static class Node {
        String item;
        Node next;

        public Node(String item) {
            this.item = item;
        }

        public Node(String item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

}
