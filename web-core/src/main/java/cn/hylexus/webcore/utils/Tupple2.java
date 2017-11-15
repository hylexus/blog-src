package cn.hylexus.webcore.utils;

/**
 * @author hylexus
 * createdAt 2017/11/15 下午3:09
 */
public class Tupple2<T, R> {
    private T _1;
    private R _2;

    public Tupple2() {
    }

    public Tupple2(T _1, R _2) {
        this._1 = _1;
        this._2 = _2;
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

    @Override
    public String toString() {
        return "Tupple2{" +
                "_1=" + _1 +
                ", _2=" + _2 +
                '}';
    }
}
