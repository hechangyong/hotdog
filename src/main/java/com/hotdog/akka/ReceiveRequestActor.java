package com.hotdog.akka;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.actor.Status;

import java.util.HashMap;
import java.util.Map;

public class ReceiveRequestActor extends AbstractActor {
    //#greeter-messages

    static public Props props() {
        return Props.create(ReceiveRequestActor.class, () -> new ReceiveRequestActor());
    }

    private Map<Integer, Integer> data = new HashMap<>();

    {
        data.put(1, 1);
        data.put(2, 1);
        data.put(3, 1);
        data.put(4, 1);
        data.put(5, 1);
        data.put(6, 1);
        data.put(7, 1);
        data.put(8, 1);

    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(RequestParam.class, rc -> {
                    try {
                        System.out.println("rc.param: " + rc.param);
                        String code = getRedemption(Integer.parseInt(rc.param));
                        getSender().tell(code, getSelf());
                    } catch (Exception e) {
                        getSender().tell(new Status.Failure(e), getSelf());
                        throw e;
                    }
                })
                .build();
    }


    public String getRedemption(int param) {
        if(param == 1) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Integer i : data.keySet()) {
            int d = data.get(i);
            if (d == 1) {
                data.put(i, 0);
                return i + "";
            }
        }
        return "取完了";
    }
}
