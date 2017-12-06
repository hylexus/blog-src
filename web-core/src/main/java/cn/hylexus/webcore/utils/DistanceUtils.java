package cn.hylexus.webcore.utils;

import com.spatial4j.core.context.SpatialContext;
import com.spatial4j.core.shape.Rectangle;

/**
 * @author hylexus
 * createdAt 2017/11/13
 */
public class DistanceUtils {
    /**
     * 获取距离指定经纬度的点{@code radius} KM 的外接四边形(严格来说应该是外接立方体)四个顶点的经纬度
     *
     * @param lng    经度
     * @param lat    纬度
     * @param radius 半径,单位:KM
     * @return <lng1,lng2,lat1,lat2>
     */
    public static Tuple4<Double> calcBoxByDistFromPt(double lng, double lat, double radius) {
        SpatialContext context = SpatialContext.GEO;
        Rectangle rectangle = context.getDistCalc()//
                .calcBoxByDistFromPt(//
                        context.makePoint(lng, lat), //
                        radius * com.spatial4j.core.distance.DistanceUtils.KM_TO_DEG, context, null//
                );
        return new Tuple4<>(rectangle.getMinX(), rectangle.getMaxX(), rectangle.getMinY(), rectangle.getMaxY());
    }

    public static double getDistance(
            double lng1, double lng2,
            double lat1, double lat2) {
        SpatialContext geo = SpatialContext.GEO;
        double distance =
                geo.calcDistance(
                        geo.makePoint(lng1, lat1),
                        geo.makePoint(lng2, lat2));
        return distance * com.spatial4j.core.distance.DistanceUtils.DEG_TO_KM;
    }

    /**
     * 地球半径:赤道半径 = 6378.140 KM <br>
     * 极半径 = 6356.755 KM <br>
     * 平均半径 = 6371.004 KM <br>
     */
    public static final double EARTH_MEAN_RADIUS_KM = 6371.0087714;
    public static final double EARTH_EQUATORIAL_RADIUS_KM = 6378.1370;


    /**
     * https://en.wikipedia.org/wiki/Haversine_formula
     */
    public static double getDistance2(double long1, double lat1, double long2, double lat2) {
        lat1 = rad(lat1);
        lat2 = rad(lat2);
        double a = lat1 - lat2;
        double b = rad(long1 - long2);
        double sa2 = Math.sin(a / 2.0);
        double sb2 = Math.sin(b / 2.0);
        return 2 * EARTH_MEAN_RADIUS_KM * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2));
    }

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }
}
