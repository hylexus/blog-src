package cn.hylexus.future;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author hylexus
 * createdAt 2018/1/1
 **/
public class FutureTest1 {

    static class Shop {
        Double getPrice(Integer id) {
            return calcPrice(id);
        }

        Future<Double> getPriceAsync(Integer id) {
            final CompletableFuture<Double> future = new CompletableFuture<>();

            new Thread(() -> {
                try {
                    Double price = this.calcPrice(id);
                    future.complete(price);
                } catch (Exception e) {
                    future.completeExceptionally(e);
                }
            }).start();

            return future;
        }

        Future<Double> getPriceAsync2(Integer id) {
            return CompletableFuture.supplyAsync(() -> calcPrice(id));
        }

        private Double calcPrice(Integer id) {
            delay();
            return new Random().nextDouble() * 10 * id;
        }
    }

    static void delay() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test1() {
        Shop shop = new Shop();
        long start = System.nanoTime();

        Future<Double> future = shop.getPriceAsync(111);
        long end1 = (System.nanoTime() - start) / 1_000_000;
        System.out.println("timeAsync =" + end1);

        this.doSomethingElse();

        try {
            Double priceVal = future.get();
            System.out.println("price = " + priceVal);
        } catch (Exception e) {
            e.printStackTrace();
        }

        long end2 = (System.nanoTime() - start) / 1_000_000;
        System.out.println("totalTime = " + end2);
    }

    private void doSomethingElse() {
        System.out.println("doSomethingElse");
    }
}
