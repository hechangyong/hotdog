package com.hotdog.designpattern.singleton;

/**
 * @Author: hecy
 * @Date: 2019/5/6 16:53
 * @Version 1.0
 */
public class JVMSafeSingleton {

    /**
     * 依赖JVM 在加载这个类时马上创建此唯一单例实例。
     * JVM 确保在任何线程访问 jvmSingleton 静态变量之前，一定先创建此实例。
     */
    private static JVMSafeSingleton jvmSingleton = new JVMSafeSingleton();

    private JVMSafeSingleton() {
    }

    public static JVMSafeSingleton getInstance() {
        return jvmSingleton;
    }

}
