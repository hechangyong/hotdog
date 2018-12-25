package com.hotdog.designpattern.decorator;

/**
 * @Author: hecy
 * @Date: 2018/12/25 18:00
 * @Version 1.0
 * @desc 装饰者模式
 *
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