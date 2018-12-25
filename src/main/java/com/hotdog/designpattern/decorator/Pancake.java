package com.hotdog.designpattern.decorator;

/**
 * @Author: hecy
 * @Date: 2018/12/25 17:56
 * @Version 1.0
 */
public abstract class Pancake {

    public String desc = "我不是一个具体的煎饼";

    public String getDesc() {
        return desc;
    }

    public abstract double price();

}