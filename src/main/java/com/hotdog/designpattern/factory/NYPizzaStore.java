package com.hotdog.designpattern.factory;

/**
 * @Author: hecy
 * @Date: 2019/4/23 16:39
 * @Version 1.0
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        }
        return null;
    }
}
