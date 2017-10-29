package cn.hylexus.app.entity;

import java.io.Serializable;

/**
 * The type User po.
 *
 * @author hylexus
 */
public class UserPO implements Serializable{

    private Integer id;
    private String name;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserPO id(Integer id) {
        this.id = id;
        return this;
    }

    public UserPO name(String name) {
        this.name = name;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UserPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
