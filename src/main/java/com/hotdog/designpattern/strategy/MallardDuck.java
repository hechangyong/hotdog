package com.hotdog.designpattern.strategy;

import com.hotdog.designpattern.strategy.behaviorImpl.FlyWithWings;
import com.hotdog.designpattern.strategy.behaviorImpl.Quack;

/**
 * @Author: hecy
 * @Date: 2019/3/22 10:48
 * @Version 1.0
 */
public class MallardDuck extends Duck {
    public MallardDuck(){
        quarkBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("MallardDuck display ....");
    }
}
