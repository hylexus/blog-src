package cn.hylexus.thread;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author hylexus
 * createdAt 2018/4/6
 **/
public class ThreadLocalTest {

    private static final int LOOP_SIZE = 500;
    private static final int DATA_SIZE = 10000;
    private static ThreadLocal<List<Person>> threadLocal = new ThreadLocal<>();

    @Test
    public void test1() {
        ExecutorService service = Executors.newFixedThreadPool(LOOP_SIZE);
        for (int i = 0; i < LOOP_SIZE; i++) {
            service.execute(() -> {
                threadLocal.set(new ThreadLocalTest().generateUser());
                System.out.println(Thread.currentThread().getName());
                threadLocal.remove();
            });
        }
        service.shutdown();
    }

    private List<Person> generateUser() {
        return IntStream.range(0, DATA_SIZE)
                .boxed()
                .map(i -> new Person("name" + i, i + 1))
                .collect(Collectors.toList());
    }

    static class Person {
        Person(String name, Integer id) {
            this.name = name;
            this.id = id;
        }

        private String name;
        private Integer id;
    }
}
