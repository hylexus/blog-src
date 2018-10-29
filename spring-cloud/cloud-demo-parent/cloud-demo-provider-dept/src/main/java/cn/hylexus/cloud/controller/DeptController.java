package cn.hylexus.cloud.controller;

import cn.hylexus.cloud.entity.DeptEntity;
import cn.hylexus.cloud.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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


    private static Logger logger = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private DeptService deptService;

    @GetMapping("/discovery")
    public DiscoveryClient discoveryClient() {
//        List<String> services = this.discoveryClient.getServices();
        return this.discoveryClient;
    }

    @GetMapping("/all")
    public List<DeptEntity> getAll() {
        return deptService.findAll();
    }

    @GetMapping("/{id}")
    public DeptEntity get(@PathVariable("id") Long id) {
        logger.info("receive request...");
        return deptService.findById(id);
    }

}
