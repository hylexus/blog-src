package cn.hylexus.app.controller;

import cn.hylexus.app.entity.UserPO;
import cn.hylexus.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CacheConfig(cacheNames = "demo-03", keyGenerator = "keyGenerator-02")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public UserPO getUserInfo(@PathVariable("userId") Integer userId) {
        return this.userService.findById(userId);
    }

    @GetMapping("/user1/{userId}")
    @Cacheable()
    public UserPO getUserInfo1(@PathVariable("userId") Integer userId) {
        LOGGER.info("repository ...");
        return new UserPO().id(userId).name("user-" + userId);
    }

    @GetMapping("/user2/{userId}")
    @Cacheable(key = "'getUserInfo2_'+#userId",value = "demo-03#500")
    public UserPO getUserInfo2(
            @PathVariable("userId") Integer userId,
            @RequestParam("date") String date) {
        LOGGER.info("repository ...");
        return new UserPO().id(userId).name("user-" + userId);
    }

    @GetMapping("/user3/{userId}")
    @Cacheable()
    public UserPO getUserInfo3(
            @PathVariable("userId") Integer userId,
            @RequestParam("p") String p,
            @RequestParam("p1") String p1,
            @RequestParam("p2") String p2) {
        LOGGER.info("repository ...");
        return new UserPO().id(userId).name("user-" + userId);
    }
}
