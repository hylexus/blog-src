package cn.hylexus.cloud.service.impl;

import cn.hylexus.cloud.dao.DeptDao;
import cn.hylexus.cloud.entity.DeptEntity;
import cn.hylexus.cloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hylexus
 * createdAt 2018/10/21
 **/
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public List<DeptEntity> findAll() {
        return deptDao.findAll();
    }

    @Override
    public DeptEntity findById(Long id) {
        return deptDao.findById(id);
    }
}
