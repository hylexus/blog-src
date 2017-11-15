package cn.hylexus.webcore.utils;

/**
 * @author hylexus
 */
public class Tuple4<T> {

    T _1;
    T _2;
    T _3;
    T _4;

    public Tuple4() {
    }

    public Tuple4(T _1, T _2, T _3, T _4) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
    }

    public T get_1() {
        return _1;
    }

    public void set_1(T _1) {
        this._1 = _1;
    }

    public T get_2() {
        return _2;
    }

    public void set_2(T _2) {
        this._2 = _2;
    }

    public T get_3() {
        return _3;
    }

    public void set_3(T _3) {
        this._3 = _3;
    }

    public T get_4() {
        return _4;
    }

    public void set_4(T _4) {
        this._4 = _4;
    }

    @Override
    public String toString() {
        return "Tuple4 [_1=" + _1 + ", _2=" + _2 + ", _3=" + _3 + ", _4=" + _4 + "]";
    }

}