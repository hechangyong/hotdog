package com.hotdog.designpattern.decorator;

/**
 * @Author: hecy
 * @Date: 2018/12/25 17:57
 * @Version 1.0
 */
public class Roujiamo extends Pancake {

    public Roujiamo() {
        desc = "肉夹馍";
    }

    @Override
    public double price() {
        return 6;
    }

}
