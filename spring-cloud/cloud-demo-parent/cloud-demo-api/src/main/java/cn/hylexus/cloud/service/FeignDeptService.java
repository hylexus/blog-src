package cn.hylexus.cloud.service;

import cn.hylexus.cloud.entity.DeptEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author hylexus
 * createdAt 2018/10/29
 **/
//@FeignClient(value = "CLOUD-DEMO-PROVIDER-DEPT")
@FeignClient(value = "CLOUD-DEMO-PROVIDER-DEPT", fallbackFactory = FeignDeptServiceFallbackFactory.class)
public interface FeignDeptService {

    @GetMapping("/dept/list")
    List<DeptEntity> getAll();

    @GetMapping("/dept/{id}")
    DeptEntity getById(@PathVariable("id") Long id);

}
