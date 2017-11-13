package cn.hylexus.utils;


import org.junit.Test;

import static cn.hylexus.utils.DistanceUtils.getDistance;
import static cn.hylexus.utils.DistanceUtils.getDistance2;

/**
 * @author hylexus
 * createdAt 2017/11/13
 */
public class Spatial4jTest {


    @Test
    public void test1() {
        double lng1 = 121.53212765629D;
        double lat1 = 31.246990597528D;
        double lng2 = 121.46975999983681D;
        double lat2 = 31.23293386676632D;
        double distance = getDistance(lng1, lng2, lat1, lat2);
        System.out.println(distance);

        distance = getDistance2(lng1, lat1, lng2, lat2);
        System.out.println(distance);
    }

}
