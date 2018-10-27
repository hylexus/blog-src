package cn.hylexus.cloud.consumer.dept.controller;

import cn.hylexus.cloud.entity.DeptEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author hylexus
 * createdAt 2018/10/21
 **/
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public DeptEntity getById(@PathVariable("id") Long id) throws Exception {
        return restTemplate.getForEntity("http://localhost:8001/dept/" + id, DeptEntity.class, id).getBody();
    }

    @GetMapping("/all")
    public List<DeptEntity> getAll(){
        return restTemplate.getForEntity("http://localhost:8001/dept/all",List.class).getBody();
    }
}
