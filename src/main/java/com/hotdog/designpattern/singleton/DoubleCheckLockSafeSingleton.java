package com.hotdog.designpattern.singleton;

/**
 * @Author: hecy
 * @Date: 2019/5/6 16:38
 * @Version 1.0
 */
public class DoubleCheckLockSafeSingleton {
    /**
     * volatile 确保当多个线程同时初始化doubleCheckLockSafeSingleton变量时，能够正确的处理doubleCheckLockSafeSingleton变量。
     */
    private volatile static DoubleCheckLockSafeSingleton doubleCheckLockSafeSingleton;

    private DoubleCheckLockSafeSingleton() {
    }

    /**
     * synchronized 加在代码块中，确保的线程安全
     * <p>
     *      只在第一次的时候才需要同步。
     * </p>
     *
     * @return
     */
    public static DoubleCheckLockSafeSingleton getInstance() {
        if (doubleCheckLockSafeSingleton == null) {
            synchronized (DoubleCheckLockSafeSingleton.class) {
                if (doubleCheckLockSafeSingleton == null) {
                    doubleCheckLockSafeSingleton = new DoubleCheckLockSafeSingleton();
                }
            }
        }
        return doubleCheckLockSafeSingleton;
    }

}
