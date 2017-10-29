package cn.hylexus.app.service;

import cn.hylexus.app.entity.UserPO;

public interface UserService {
    UserPO findById(Integer id);
}
