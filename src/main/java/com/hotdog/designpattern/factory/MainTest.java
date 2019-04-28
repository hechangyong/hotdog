package com.hotdog.designpattern.factory;

/**
 * @Author: hecy
 * @Date: 2019/4/23 17:18
 * @Version 1.0
 */
public class MainTest {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYPizzaStore();
        Pizza pizza = pizzaStore.orderPizza("cheese");
    }
}
