package cn.hylexus.webcore.common;


import cn.hylexus.webcore.mapper.StationMapper;
import cn.hylexus.webcore.po.StationPO;
import cn.hylexus.webcore.utils.Tupple2;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.nio.charset.Charset;

/**
 * 地铁站信息初始化工具
 *
 * @author hylexus
 * createdAt 2017/11/15
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StationInfoInitializer {

    private Logger logger = LoggerFactory.getLogger(StationInfoInitializer.class);


    private static final String STATION_INFO_FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/stations-shanghai.txt";

    @Autowired
    private StationMapper mapper;

    @Test
    public void initStationInfo() throws Exception {
        FileUtils
                .readLines(new File(STATION_INFO_FILE_PATH), Charset.forName("UTF-8"))
                .stream()
                .filter(StringUtils::isNotBlank)
                .map(line -> {
                    String[] arr = line.split(":");
                    return new Tupple2<>(arr[0], arr[1]);
                })
                .map(pair -> {
                    String[] latAndLng = pair.get_2().split(",");
                    StationPO po = new StationPO();
                    po.setName(pair.get_1());
                    po.setLat(Double.valueOf(latAndLng[0]));
                    po.setLng(Double.valueOf(latAndLng[1]));
                    return po;
                }).forEach(this.mapper::insert);

        logger.info("done");
    }


}
