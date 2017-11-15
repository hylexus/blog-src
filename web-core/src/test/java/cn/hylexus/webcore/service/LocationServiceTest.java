package cn.hylexus.webcore.service;

import cn.hylexus.webcore.po.StationPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author hylexus
 * createdAt 2017/11/15 下午4:54
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationServiceTest {

    @Autowired
    private LocationService locationService;

    @Test
    public void testGetNearStations() {

//        121.496107,31.264149
        Double lng = 121.496107D;
        Double lat = 31.264149;
        Integer radius = 5;
        this.locationService.getNearStations(lng, lat, radius, 1, 5)
                .forEach(System.out::println);
    }
}
