package cn.hylexus.webcore.service.impl;

import cn.hylexus.webcore.dto.NearLocationSearchParam;
import cn.hylexus.webcore.mapper.StationMapper;
import cn.hylexus.webcore.po.StationPO;
import cn.hylexus.webcore.service.LocationService;
import cn.hylexus.webcore.utils.DistanceUtils;
import cn.hylexus.webcore.utils.NumberUtils;
import cn.hylexus.webcore.utils.Tuple4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author hylexus
 * createdAt 2017/11/15 下午4:29
 */

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private StationMapper stationMapper;

    @Override
    public List<StationPO> getNearStations(Double lng, Double lat, Integer radius, Integer page, Integer pageSize) {

        NearLocationSearchParam param = this.convert2SearchParam(lng, lat, radius, page, pageSize);
        return this.stationMapper.getNearStation(param);
    }

    private NearLocationSearchParam convert2SearchParam( Double lng, Double lat, Integer radius, Integer page, Integer pageSize) {
        Assert.notNull(lng, "经度不能为空");
        Assert.notNull(lat, "纬度不能为空");
        Assert.notNull(radius, "半径不能为空");

        if (!NumberUtils.isPositive(page)) {
            page = 1;
        }
        if (!NumberUtils.isPositive(pageSize)) {
            pageSize = 5;
        }

        Tuple4<Double> tuple4 = DistanceUtils.calcBoxByDistFromPt(lng, lat, radius);

        NearLocationSearchParam param = new NearLocationSearchParam();
        param.setLng1(tuple4.get_1());
        param.setLng2(tuple4.get_2());
        param.setLat1(tuple4.get_3());
        param.setLat2(tuple4.get_4());
        param.setLimit(pageSize);
        param.setStart((page - 1) * pageSize);
        param.setTargetLng(lng);
        param.setTargetLat(lat);
        return param;
    }
}
