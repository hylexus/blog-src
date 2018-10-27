package cn.hylexus.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hylexus
 * createdAt 2018/4/4
 **/
public class HeapSortTest {

    @Test
    public void test1() {
        int[] data = {87, 45, 78, 32, 17, 65, 53, 9, 122};
        System.out.println(Arrays.toString(data));
        this.buildHeap(data);
        System.out.println(Arrays.toString(data));

        for (int i = data.length - 1; i > 1; i--) {
            swap(data, 0, i);
            this.adjust(data, 0,i);
        }

        System.out.println(Arrays.toString(data));
    }

    private void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    private void buildHeap(int[] data) {
        for (int i = (data.length - 2) / 2; i >= 0; i--) {
            adjust(data, i, data.length);
        }
    }

    private void adjust(int[] data, int parentIndex, int len) {

        int parent = data[parentIndex];
        for (int i = 2 * parentIndex + 1; i < len - 1; i = 2 * i + 1) {

            if (data[i] < data[i + 1]) {
                i++;
            }

            if (parent > data[i]) {
                break;
            }

            data[parentIndex] = data[i];
            parentIndex = i;
        }

        data[parentIndex] = parent;
    }

}
