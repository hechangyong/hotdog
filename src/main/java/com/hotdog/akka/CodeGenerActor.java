package com.hotdog.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class CodeGenerActor extends AbstractActor {

    //#greeter-messages
    static public Props props(String message, ActorRef printerActor) {
        return Props.create(CodeGenerActor.class, () -> new CodeGenerActor(message, printerActor));
    }

    private final String message;
    private final ActorRef printerActor;

    public CodeGenerActor(String message, ActorRef printerActor) {
        this.message = message;
        this.printerActor = printerActor;
    }


    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(RedemptionCode.class, rc -> {
                    String code =  getRedemption(rc.param);
                    printerActor.tell(code, getSelf());
                })
                .build();
    }

    private String getRedemption(String param) {
        return "这是一个兑换码";
    }
}
