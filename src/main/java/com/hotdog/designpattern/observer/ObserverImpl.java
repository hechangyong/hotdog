package com.hotdog.designpattern.observer;

import java.util.Observable;

/**
 * @Author: hecy
 * @Date: 2019/3/25 16:02
 * @Version 1.0
 */
public class ObserverImpl  extends Observable implements Observer, DisplayElement {
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
