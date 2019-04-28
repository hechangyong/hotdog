package com.hotdog.designpattern.decorator;

/**
 * @Author: hecy
 * @Date: 2018/12/25 18:00
 * @Version 1.0
 * @desc 装饰者模式
 *  装饰者该做的事，就是增加行为到被包装对象上，
 *  当需要窥视装饰链中的每一个装饰者时，这就超出他们的天赋了。
 */
public class MyTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Pancake tornCake = new TornCake();
        //手抓饼基础价
        System.out.println(String.format("%s ￥%s", tornCake.getDesc(), tornCake.price()));

        Pancake roujiamo = new Roujiamo();
        roujiamo = new FiredEgg(roujiamo);
        roujiamo = new FiredEgg(roujiamo);
        roujiamo = new Ham(roujiamo);
        roujiamo = new MeatFloss(roujiamo);
//        roujiamo = new Cucumber(roujiamo);
        System.out.println(String.format("%s ￥%s", roujiamo.getDesc(), roujiamo.price()));
    }

}