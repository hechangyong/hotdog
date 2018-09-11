package com.hotdog.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static akka.pattern.PatternsCS.ask;

public class Entrance {
    private static final ActorSystem system = ActorSystem.create("helloakka");
    final ActorRef receiveRequestActor = system.actorOf(ReceiveRequestActor.props(), "ReceiveRequestActor" );

    public String main(int i) {

        //#create-actors
//        receiveRequestActor.tell(new RequestParam("getCode"), ActorRef.noSender());// 这个是发送消息没有返回值的。
        // using 1000ms timeout
        CompletableFuture<Object> future1 = ask(receiveRequestActor, new RequestParam(i + ""), 10000).toCompletableFuture();
        try {
            return (String) future1.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
// using timeout from above
//        CompletableFuture<Object> future2 =  ask(actorB, "another request", t).toCompletableFuture();

        return "";
    }
}
