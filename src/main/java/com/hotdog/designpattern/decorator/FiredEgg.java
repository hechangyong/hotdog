package com.hotdog.designpattern.decorator;

/**
 * @Author: hecy
 * @Date: 2018/12/25 18:00
 * @Version 1.0
 */
public class FiredEgg extends Condiment {
    private Pancake pancake;

    public FiredEgg(Pancake pancake) {
        this.pancake = pancake;
    }

    @Override
    public String getDesc() {
        return pancake.getDesc() + ", 煎蛋";
    }

    @Override
    public double price() {
        return pancake.price() + 2;
    }

}