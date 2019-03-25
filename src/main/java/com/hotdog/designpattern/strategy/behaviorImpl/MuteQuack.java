package com.hotdog.designpattern.strategy.behaviorImpl;

import com.hotdog.designpattern.strategy.QuackBehavior;

/**
 * @Author: hecy
 * @Date: 2019/3/22 10:43
 * @Version 1.0
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("MuteQuack !! ");

    }
}
