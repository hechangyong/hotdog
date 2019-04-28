package com.hotdog.designpattern.factory;

/**
 * @Author: hecy
 * @Date: 2019/4/23 16:26
 * @Version 1.0
 */
public abstract class Pizza {

    String name;

    /**
     * 面团
     */
    String dough;


    void prepare() {
        System.out.println("prepare name: " + name);
        System.out.println("prepare dough: " + dough);
    }


}
