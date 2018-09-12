package com.hotdog.akka;

import java.util.HashMap;
import java.util.Map;

public class Test {

    private static Map<Integer, Integer> data = new HashMap<Integer, Integer>(){{
            put(1, 1);
            put(2, 1);
            put(3, 1);
            put(4, 1);
            put(5, 1);
            put(6, 1);
            put(7, 1);
            put(8, 1);
    }};


    public static void mai1n(String[] args) {
        Entrance entrance = new Entrance();


        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 10; i++) {
            int da = i;
            new Thread("" + da) {
                public void run() {
                    System.out.println("Thread: " + getName() + "running  " + getRedemption(da));
                 }

            }.start();
        }

    }


    public static String getRedemption(int param) {
        for (Integer i : data.keySet()) {
            int d = data.get(i);
            if (d == 1) {
                data.put(i, 0);
                return i + "";
            }
        }
        return "取完了";
    }
    public static void main(String[] args) {
        Entrance entrance = new Entrance();


        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 50; i++) {

            int da = i;
            new Thread("" + da) {
                public void run() {
                    System.out.println("Thread: " + getName() + " running  " + entrance.main(da));
                 }

            }.start();
        }



    }
}
