package com.hotdog.designpattern.strategy;


import org.junit.Test;
/**
 * @Author: hecy
 * @Date: 2019/3/22 10:44
 * @Version 1.0
 * 策咯模式 测试类
 * 鸭子的行为封装在一组类里面
 * 可以轻易的扩充和改变如果需要在运行时改变也可以
 *
 * 策咯模式 定义了算法族， 分别封装起来，就像一个谋士一样，可以提供各种各样的策略给你。
 * 这些策略独立于使用者存在。
 */
public class MainStrategy {

    @Test
    public  void strategy(){
        Duck duck = new MallardDuck();
        duck.performFly();
        duck.performQuack();

    }


}
