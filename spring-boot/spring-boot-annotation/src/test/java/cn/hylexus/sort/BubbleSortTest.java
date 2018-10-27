package cn.hylexus.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hylexus
 * createdAt 2018/4/4
 **/
public class BubbleSortTest {

    @Test
    public void test1() {
        int[] data = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(data));
        bubbleSort(data);
        System.out.println(Arrays.toString(data));
    }

    private void bubbleSort(int[] data) {

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] < data[j]) {
                    swap(data, i, j);
                }
            }
        }
    }

    private void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
