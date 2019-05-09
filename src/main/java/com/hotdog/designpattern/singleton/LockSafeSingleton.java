package com.hotdog.designpattern.singleton;

/**
 * @Author: hecy
 * @Date: 2019/5/6 16:31
 * @Version 1.0
 * <p>
 *     线程安全的单例模式实现
 * </p>
 */
public class LockSafeSingleton {

    private static LockSafeSingleton lockSafeSingleton;

    private LockSafeSingleton() {
    }
    /**
     * 通过增加synchronized 关键字，确保不会有多个线程同时进入到这个方法。
     * 确保的线程安全
     *
     * 问题：单例模式只有在第一次的时候才需要同步，这种实现使得每次获取实例对象的时候都要获得锁，
     *       性能会比较差。后面获取实例这种同步就变的比较累赘了。
     * @return
     */
    public static synchronized LockSafeSingleton getInstance() {
        if (lockSafeSingleton == null) {
            lockSafeSingleton = new LockSafeSingleton();
        }
        return lockSafeSingleton;
    }

}
