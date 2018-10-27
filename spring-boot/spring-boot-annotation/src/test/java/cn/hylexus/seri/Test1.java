package cn.hylexus.seri;

import org.junit.Test;

import java.io.*;

/**
 * @author hylexus
 * createdAt 2018/4/5
 **/
public class Test1 {
    @Test
    public void test1() throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.seri"));
        Person adapterBean = new Person("tom", 123);
        oos.writeObject(adapterBean);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.seri"));
//        AdapterBean bean = (AdapterBean) ois.readObject();
//        System.out.println(bean);

        AdapterBean person = (AdapterBean) ois.readObject();
        System.out.println(person);
    }
}

class AdapterBean implements Serializable {
    private String name;
    private int age;

    public AdapterBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        System.out.println("AdapterBean.writeObject");
    }

    private void readObject(ObjectInputStream in) throws Exception {
        in.defaultReadObject();
        System.out.println("AdapterBean.readObject");
    }

    @Override
    public String toString() {
        return "AdapterBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        System.out.println("Person.writeObject");
    }

    private void readObject(ObjectInputStream in) throws Exception {
        in.defaultReadObject();
        System.out.println("Person.readObject");
    }

    private Object writeReplace() throws ObjectStreamException {
        System.out.println("Person.writeReplace");
        return new AdapterBean(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}