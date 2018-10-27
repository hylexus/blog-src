package cn.hylexus.thread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author hylexus
 * createdAt 2018/4/8
 **/
public class CacheSystem {

    private Map<String, Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    Object get(String key) {
        readLock.lock();

        Object data;
        try {
            data = map.get(key);
            if (data == null) {
                readLock.unlock();
                writeLock.lock();
                try {
                    if (data == null) {
                        data = loadFromDB(key);
                    }
                } finally {
                    writeLock.unlock();
                }
                readLock.lock();
            }
        } finally {
            readLock.unlock();
        }

        return data;
    }

    private Object loadFromDB(String key) {
        return "data-" + key;
    }
}
