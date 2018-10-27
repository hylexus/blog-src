package cn.hylexus.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hylexus
 * createdAt 2018/4/4
 **/
public class SelectSortTest {

    @Test
    public void test1() {
        int[] data = {1, 2, 5, 5, 6, 1, 0, -1, 4, 2, 3};
        System.out.println(Arrays.toString(data));
        selectSort(data);
        System.out.println(Arrays.toString(data));
    }

    private void selectSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int index = i;
            int value = data[i];

            for (int j = i; j < data.length; j++) {
                if (data[j] < value) {
                    index = j;
                    value = data[j];
                }
            }

            data[index] = data[i];
            data[i] = value;
        }
    }
}
