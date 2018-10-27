package cn.hylexus.cloud.dao;

import cn.hylexus.cloud.entity.DeptEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hylexus
 * createdAt 2018/10/21
 **/
@Mapper
public interface DeptDao {

    List<DeptEntity> findAll();

    DeptEntity findById(@Param("id") Long id);
}
