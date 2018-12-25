package com.hotdog.designpattern.decorator;

/**
 * @Author: hecy
 * @Date: 2018/12/25 17:56
 * @Version 1.0
 */
public class TornCake extends Pancake {

    public TornCake() {
        desc = "手抓饼";
    }

    @Override
    public double price() {
        return 4;
    }

}
