package com.hotdog.designpattern.factory;

/**
 * @Author: hecy
 * @Date: 2019/4/23 16:22
 * @Version 1.0
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        return pizza;
    }

    abstract Pizza createPizza(String type);


}
