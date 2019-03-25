package com.hotdog.designpattern.strategy.behaviorImpl;

import com.hotdog.designpattern.strategy.FlyBehavior;

/**
 * @Author: hecy
 * @Date: 2019/3/22 10:41
 * @Version 1.0
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("i can`t fly !! ");
    }
}
