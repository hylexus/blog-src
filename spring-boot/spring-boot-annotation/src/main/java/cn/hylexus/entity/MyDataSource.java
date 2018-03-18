package cn.hylexus.entity;

/**
 * @author hylexus
 * createdAt 2018/3/17
 **/
public class MyDataSource {

    public MyDataSource() {
        System.out.println("MyDataSource Constructor ...");
    }

    public void init() {
        System.out.println("MyDataSource init ...");
    }

    public void destroy() {
        System.out.println("MyDataSource destroy ...");
    }
}
