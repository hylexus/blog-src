package cn.hylexus.factory;

import cn.hylexus.entity.UserEntity;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author hylexus
 * createdAt 2018/3/17
 **/
public class UserFactoryBean implements FactoryBean<UserEntity> {
    @Override
    public UserEntity getObject() throws Exception {
        System.out.println("UserFactoryBean.getObject()...");
        return new UserEntity(111, "陆云");
    }

    @Override
    public Class<?> getObjectType() {
        return UserEntity.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
