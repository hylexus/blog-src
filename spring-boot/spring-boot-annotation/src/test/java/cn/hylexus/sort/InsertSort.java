package cn.hylexus.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hylexus
 * createdAt 2018/4/4
 **/
public class InsertSort {
    @Test
    public void test1() {
        int[] data = {7, 6, 4, 5, 3, 2, 1};
        System.out.println(Arrays.toString(data));
        insertSort(data);
        System.out.println(Arrays.toString(data));
    }

    private void insertSort(int[] data) {

        for (int i = 1; i < data.length; i++) {
            int j = i - 1;
            int e = data[j + 1];
            while (j >= 0 && data[j] > e) {
                data[j + 1] = data[j];
                j--;
            }

            data[j + 1] = e;
        }
    }
}
