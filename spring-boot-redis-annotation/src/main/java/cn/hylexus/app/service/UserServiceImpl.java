package cn.hylexus.app.service;

import cn.hylexus.app.entity.UserPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * The type User service.
 *
 * @author hylexus
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Cacheable(value = "cache-demo", key = "'user_info_'+#id")
    @Override
    public UserPO findById(Integer id) {
        logger.info("load from repository : {}", id);
        return new UserPO().id(id).name("user-" + id);
    }
}
