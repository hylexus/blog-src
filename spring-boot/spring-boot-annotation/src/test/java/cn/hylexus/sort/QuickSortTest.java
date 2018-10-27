package cn.hylexus.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hylexus
 * createdAt 2018/4/4
 **/
public class QuickSortTest {

    private void quickSort(int[] data, int left, int right) {
        if (left > right) {
            return;
        }

        int i = left;
        int j = right;
        int key = data[left];

        while (i < j) {
            while (data[j] >= key && i < j) {
                j--;
            }

            while (data[i] <= key && i < j) {
                i++;
            }

            if (i < j) {
                swap(data, i, j);
            }
        }

        swap(data, left, i);

        quickSort(data, left, i - 1);
        quickSort(data, j + 1, right);
    }

    @Test
    public void test1() {
        int[] arr = {1,1,2,2,3,2,2,6,6,6,2,2,1};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
