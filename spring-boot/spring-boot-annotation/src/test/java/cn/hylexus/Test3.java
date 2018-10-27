package cn.hylexus;

import org.junit.Test;

/**
 * @author hylexus
 * createdAt 2018/3/27
 **/
public class Test3 {

    @Test
    public void test1() {
        short s1 = 1;
        s1 += 1;

        short s2 = (short) (s1 + 1);
    }

    @Test
    public void test2() {
        Integer a = new Integer(3);
        Integer b = 3;                  // 将3自动装箱成Integer类型
        int c = 3;
        Integer d = new Integer(3);
        Integer e = 3;
        System.out.println(a == b);     // false
        System.out.println(a == c);     // true a自动拆箱成int类型再和c比较
        System.out.println(a == d);     // false
        System.out.println(new Integer(3) == 3); // true
        System.out.println(b == e);     // true valueOf
    }


    @Test
    public void test3() {
        System.out.println(2 >> 3);
        System.out.println(2 << 3);
    }

    @Test
    public void test4() {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2); // false
        System.out.println(s1 == s3); // true
        System.out.println(s1 == s1.intern()); // true
    }

    @Test
    public void test5() {
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(String.class.getClassLoader());
        System.out.println(this.getClass().getClassLoader());
    }


    @Test
    public void test6() {
        A ab = new B();
        ab = new B();
    }

    @Test
    public void test7() {
        System.out.println(reverse("1234"));
    }

    private String reverse(String str) {
        if (str.length() == 1) {
            return str;
        }

        return reverse(str.substring(1)) + str.charAt(0);
    }

    @Test
    public void test8() {
        int a = 1<<1;
        assert a > 1 : "a is not gt 1";
    }

    @Test
    public void test9(){
        System.out.println("--> "+testFinal());
    }
    private int testFinal(){
        try{
            System.out.println(1);
            return 1;
        }finally {
            System.out.println(2);
            return 2;
        }
    }
}

class A {

    static {
        System.out.print("1");
    }

    public A() {
        System.out.print("2");
    }
}

class B extends A {

    static {
        System.out.print("a");
    }

    public B() {
        System.out.print("b");
    }
}
