package com.hotdog.designpattern.strategy.behaviorImpl;

import com.hotdog.designpattern.strategy.QuackBehavior;

/**
 * @Author: hecy
 * @Date: 2019/3/22 10:42
 * @Version 1.0
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack !!");

    }
}
