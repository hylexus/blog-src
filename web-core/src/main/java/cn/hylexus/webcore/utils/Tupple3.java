package cn.hylexus.webcore.utils;

/**
 * @author hylexus
 * createdAt 2017/11/15 下午3:10
 */
public class Tupple3<T, R, U> {
    private T _1;
    private R _2;
    private U _3;

    public Tupple3() {
    }

    public Tupple3(T _1, R _2, U _3) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
    }

    public T get_1() {
        return _1;
    }

    public void set_1(T _1) {
        this._1 = _1;
    }

    public R get_2() {
        return _2;
    }

    public void set_2(R _2) {
        this._2 = _2;
    }

    public U get_3() {
        return _3;
    }

    public void set_3(U _3) {
        this._3 = _3;
    }

    @Override
    public String toString() {
        return "Tupple3{" +
                "_1=" + _1 +
                ", _2=" + _2 +
                ", _3=" + _3 +
                '}';
    }
}
