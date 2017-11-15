package cn.hylexus.webcore.mapper;

import cn.hylexus.webcore.dto.NearLocationSearchParam;
import cn.hylexus.webcore.po.StationPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hylexus
 * createdAt 2017/11/15 下午3:30
 */

@Mapper
public interface StationMapper {

    int insert(StationPO station);

    List<StationPO> getNearStation(NearLocationSearchParam param);
}
