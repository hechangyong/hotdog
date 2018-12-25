package com.hotdog.designpattern.decorator;

/**
 * @Author: hecy
 * @Date: 2018/12/25 18:01
 * @Version 1.0
 */
public class MeatFloss extends Condiment {

    private Pancake pancake;

    public MeatFloss(Pancake pancake) {
        this.pancake = pancake;
    }

    @Override
    public String getDesc() {
        return pancake.getDesc() + ", 肉松";
    }

    @Override
    public double price() {
        return pancake.price() + 2;
    }

}
