package com.hotdog.designpattern.singleton;

/**
 * @Author: hecy
 * @Date: 2019/5/6 16:22
 * @Version 1.0
 * 线程不安全的单例模式实现
 * 多个线程并发请求实例时，有可能会创建多个实例出来。
 */
public class UnsafeSingleton {
    private static UnsafeSingleton unsafeSingleton;

    private UnsafeSingleton() {
    }

    public static UnsafeSingleton getInstance() {
        if (unsafeSingleton == null) {
            unsafeSingleton = new UnsafeSingleton();
        }
        return unsafeSingleton;
    }
}
