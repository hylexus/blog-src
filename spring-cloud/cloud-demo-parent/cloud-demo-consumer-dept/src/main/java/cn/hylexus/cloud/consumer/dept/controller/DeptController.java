package cn.hylexus.cloud.consumer.dept.controller;

import cn.hylexus.cloud.entity.DeptEntity;
import cn.hylexus.cloud.service.FeignDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hylexus
 * createdAt 2018/10/21
 **/
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private FeignDeptService deptService;

    @GetMapping("/{id}")
    public DeptEntity getById(@PathVariable("id") Long id) throws Exception {
        return this.deptService.getById(id);
    }

    @GetMapping("/all")
    public List<DeptEntity> getAll() {
        return this.deptService.getAll();
    }
}
