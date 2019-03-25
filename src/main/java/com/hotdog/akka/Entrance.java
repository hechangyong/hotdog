package com.hotdog.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.pattern.Patterns;
import com.hotdog.akka.di.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static akka.pattern.PatternsCS.ask;

@Component
public class Entrance {
    private ActorRef receiveRequestActor;

    @Autowired
    private ActorSystem actorSystem;

    @Autowired
    private SpringExtension springExtension;

    public ActorRef getActorRef(String workerActorName) {
        receiveRequestActor = actorSystem.actorOf(springExtension.props(workerActorName), "ReceiveRequestActor");
        return receiveRequestActor;
    }

    {

    }

    public String main(int i) {
        //#create-actors
//        receiveRequestActor.tell(new RequestParam("getCode"), ActorRef.noSender());// 这个是发送消息没有返回值的。
        // using 1000ms timeout
        Long s = System.currentTimeMillis();
//        CompletableFuture<Object> future1 = ask(getActorRef("workerActor"), new RequestParam(i + ""), 1000).toCompletableFuture();
        getActorRef("workerActor").tell(new RequestParam(i + ""), null);
        Long ee = System.currentTimeMillis();
        System.out.println("ask 耗时： " + (ee-s));

//                if (future1.isDone()) {
//                    return (String) future1.get();
//                }
//            }
////            Future<Object> f = future1.whenComplete((v, e) -> {
//                System.out.println(v);
//                System.out.println(e);
//            });
//            return (String) f.get();

// using timeout from above
//        CompletableFuture<Object> future2 =  ask(actorB, "another request", t).toCompletableFuture();

        return "";
    }
}
