package com.hotdog.designpattern.observer;

import org.junit.Test;

/**
 * @Author: hecy
 * @Date: 2019/3/25 14:18
 * @Version 1.0
 * 观察者模式
 * 定义了一系列对象之间的一对多关系。
 * 当一个对象改变状态，他的所有依赖着都会受到通知。
 * 观察者模式提供了一种对象设计，让主题和观察者之间松耦合。
 *
 */
public class MainObserver {

    @Test
    public void observer(){
        WeatherData weatherData = new WeatherData();
        ObserverImpl  observer = new ObserverImpl(weatherData);
        weatherData.setMeasurements(21.312f);
        observer.display();
     }


}
