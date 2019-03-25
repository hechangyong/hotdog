package com.hotdog.designpattern.strategy.behaviorImpl;

import com.hotdog.designpattern.strategy.FlyBehavior;

/**
 * @Author: hecy
 * @Date: 2019/3/22 10:39
 * @Version 1.0
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("i`m flying!!");

    }
}
