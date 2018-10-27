package cn.hylexus.thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author hylexus
 * createdAt 2018/4/8
 **/
public class CompletionServiceTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletionService<Integer> service = new ExecutorCompletionService<>(executor);

        for (int i = 0; i < 10; i++) {
            service.submit(() -> {
                int random = new Random().nextInt(3000);
                Thread.sleep(random);
                return random;
            });
        }

        for (int i = 0; i < 10; i++) {
            Integer integer = service.take().get();
            System.out.println(integer);
        }

        executor.shutdown();
    }

}
