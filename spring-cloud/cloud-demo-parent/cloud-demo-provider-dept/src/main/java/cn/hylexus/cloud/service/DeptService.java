package cn.hylexus.cloud.service;

import cn.hylexus.cloud.entity.DeptEntity;

import java.util.List;

/**
 * @author hylexus
 * createdAt 2018/10/21
 **/
public interface DeptService {

    List<DeptEntity> findAll();

    DeptEntity findById(Long id);
}
