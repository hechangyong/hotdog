/**
 * hecy
 *
 * <p>
 * 单例模式: 确保类只有一个实例，并提供全局访问。
 * 有一些类在整个系统中只需要一个，比如线程池，缓存，日志对象等
 * </p>
 *
 * <p>
 * 1、 线程不安全的单例实现 {@linkplain com.hotdog.designpattern.singleton.UnsafeSingleton}
 * 2、 线程安全但很消耗性能的单例实现 {@linkplain com.hotdog.designpattern.singleton.LockSafeSingleton}
 * 3、 线程安全的单例实现 {@linkplain com.hotdog.designpattern.singleton.JVMSafeSingleton}
 * 4、 线程安全且性能消耗低单例实现 {@linkplain com.hotdog.designpattern.singleton.DoubleCheckLockSafeSingleton}
 * </p>
 */
package com.hotdog.designpattern.singleton;
