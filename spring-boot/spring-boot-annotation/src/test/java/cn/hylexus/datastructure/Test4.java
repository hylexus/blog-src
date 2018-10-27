package cn.hylexus.datastructure;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hylexus
 * createdAt 2018/4/3
 **/
public class Test4 {
    String[] gernerateData() {
        return new String[]{
                "a1", "a2", "a3", "a4", "a5","a6","a7","a8","a9",
                "b1", "b2", "b3", "b4", "b5","b6","b7","b8","b9"
                // a1,  b1,   a2   b2    a3   b3   a4   b4   a5
                // b5,  a6,   b6   a7    b7   a8   b8   a9   b9

                // 0   1     2     3     4    5    6    7    8
                // 9   10    11    12    13   14   15   16   17

                // 0   9     4     6     8    10   12   14   16
                // 1   3     5     7     9    11   13   15   17
        };
    }

    @Test
    public void test1() {
        String[] data = this.gernerateData();
        System.out.println(Arrays.toString(data));
        int step = data.length / 2;
        for (int i = 0; i < step; i++) {
            swp(data, i, i + step);
        }
        System.out.println(Arrays.toString(data));
    }

    private void swp(String[] data, int i, int j) {
        String tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
