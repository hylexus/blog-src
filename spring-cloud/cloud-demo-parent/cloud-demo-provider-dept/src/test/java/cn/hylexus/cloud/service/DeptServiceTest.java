package cn.hylexus.cloud.service;

import cn.hylexus.cloud.BaseTest;
import cn.hylexus.cloud.entity.DeptEntity;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author hylexus
 * createdAt 2018/10/21
 **/
public class DeptServiceTest extends BaseTest {

    @Autowired
    private DeptService service;

    @Test
    public void findAllTest() {
        List<DeptEntity> list = this.service.findAll();
        System.out.println(JSON.toJSONString(list, true));
    }
}