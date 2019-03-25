package com.hotdog.designpattern.observer;

/**
 * @Author: hecy
 * @Date: 2019/3/25 15:32
 * @Version 1.0
 * 观察者模式 之 主题者/ 可观察者
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    /**
     * 当主题中某状态发生改变时，这个方法会被调用，以通知所有观察者。
     */
    void notifyObservers();


}
