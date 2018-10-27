package cn.hylexus.datastructure;

import org.junit.Test;

/**
 * @author hylexus
 * createdAt 2018/4/2
 **/
public class NodeReverseTest {
    private static <T> Node<T> reverseByIterate(Node<T> node) {
        Node<T> prev = null;
        Node<T> now = node;
        while (now != null) {
            Node<T> next = now.getNext();
            now.setNext(prev);
            prev = now;
            now = next;
        }
        return prev;
    }

    public static <T> Node<T> reverseByRecursive(Node<T> node, Node<T> prev) {
        if (node.getNext() == null) {
            node.setNext(prev);
            return node;
        }
        Node<T> tmp = reverseByRecursive(node.getNext(), node);
        tmp.setNext(prev);
        return tmp;
    }

    static <T> Node<T> reverse3(Node<T> node) {
        if (node.getNext() == null) return node;
        Node<T> next = node.getNext();
        node.setNext(null);
        Node<T> re = reverse3(next);
        next.setNext(node);
        return re;
    }

    @Test
    public void test2() {
        Node<Integer> header = getIntegerNode();

        System.out.println(header);
        Node<Integer> reverse = reverse3(header);
        System.out.println(reverse);
    }

    @Test
    public void test1() {
        Node<Integer> header = getIntegerNode();

        System.out.println(header);
        Node<Integer> reverse = reverseByIterate(header);
        System.out.println(reverse);
    }

    private Node<Integer> getIntegerNode() {
        return new Node<>(
                1,
                new Node<>(2,
                        new Node<>(3,
                                new Node<>(4,
                                        new Node<>(5, null)
                                )
                        )
                )
        );
    }
}
