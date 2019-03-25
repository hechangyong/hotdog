package com.hotdog.designpattern.observer;

import java.util.ArrayList;

/**
 * @Author: hecy
 * @Date: 2019/3/25 15:26
 * @Version 1.0
 */
public class WeatherData implements Subject {
    private ArrayList<Observer> observers = new ArrayList<>();


    private WeatherDataParam weatherDataParam ;

    public WeatherData(){
        weatherDataParam = new WeatherDataParam();

    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(weatherDataParam);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature) {
        this.weatherDataParam.setTemperature(temperature);
        measurementsChanged();
    }


}

class WeatherDataParam {
    private float temperature;
    private float humidity;
    private float pressure;


    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return "WeatherDataParam{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                '}';
    }
}
