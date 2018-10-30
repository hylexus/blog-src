package cn.hylexus.cloud.service;

import cn.hylexus.cloud.entity.DeptEntity;
import com.google.common.collect.Lists;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hylexus
 * createdAt 2018/10/29
 **/
@Component
public class FeignDeptServiceFallbackFactory implements FallbackFactory<FeignDeptService> {
    @Override
    public FeignDeptService create(Throwable throwable) {
        return new FeignDeptService() {
            @Override
            public List<DeptEntity> getAll() {
                return Lists.newArrayList();
            }

            @Override
            public DeptEntity getById(Long id) {
                return new DeptEntity().setId(id).setName("fallback factory");
            }
        };
    }
}
