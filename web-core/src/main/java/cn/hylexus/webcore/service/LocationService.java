package cn.hylexus.webcore.service;

import cn.hylexus.webcore.po.StationPO;

import java.util.List;

/**
 * @author hylexus
 * createdAt 2017/11/15 下午4:26
 */
public interface LocationService {

    /**
     * 获取附近地铁站信息
     *
     * @param lng    经度
     * @param lat    维度
     * @param radius 半径，附近 @code{radius} KM左右范围内查找
     * @param page   第几页 从1开始 默认为1
     * @param pageSize   每页大小 默认为5
     * @return 附近地铁站信息
     */
    List<StationPO> getNearStations(Double lng, Double lat, Integer radius, Integer page, Integer pageSize);
}
