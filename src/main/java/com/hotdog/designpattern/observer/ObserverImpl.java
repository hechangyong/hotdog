package com.hotdog.designpattern.observer;

import java.util.Observable;

/**
 * @Author: hecy
 * @Date: 2019/3/25 16:02
 * @Version 1.0
 * 观察数据是否有变化的类， 具体的任务类
 */
public class ObserverImpl   implements Observer, DisplayElement {
    private WeatherDataParam weatherDataParam ;

    private Subject webtherData;

    public ObserverImpl(Subject webtherData){
        weatherDataParam = new WeatherDataParam();
        this.webtherData = webtherData;
        webtherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("weatherDataParam: " + weatherDataParam);
    }


    @Override
    public void update(WeatherDataParam weatherDataParam) {
        this.weatherDataParam.setTemperature(weatherDataParam.getTemperature());
    }
}
