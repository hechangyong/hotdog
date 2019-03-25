package com.hotdog.designpattern.strategy;

/**
 * @Author: hecy
 * @Date: 2019/3/22 10:33
 * @Version 1.0
 */
public abstract class Duck {
    FlyBehavior flyBehavior;

    QuackBehavior quarkBehavior;

    public Duck() {
    }

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quarkBehavior.quack();
    }

    /** 可提供在运行时 修改fly 的行为 */
    public void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }

    public void swim() {
        System.out.println("all ducks can swim, even decoys");
    }


}
