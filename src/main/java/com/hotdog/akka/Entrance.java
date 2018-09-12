package com.hotdog.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.hotdog.akka.di.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static akka.pattern.PatternsCS.ask;
@Component
public class Entrance {
     private ActorRef receiveRequestActor ;

    @Autowired
    private ActorSystem actorSystem;

    @Autowired
    private SpringExtension springExtension;

    public ActorRef getActorRef(String workerActorName){
        if (receiveRequestActor == null) {
            receiveRequestActor  = actorSystem.actorOf(springExtension.props(workerActorName), "ReceiveRequestActor" );
        }
        return receiveRequestActor;
    }

    public String main(int i) {
         //#create-actors
//        receiveRequestActor.tell(new RequestParam("getCode"), ActorRef.noSender());// 这个是发送消息没有返回值的。
        // using 1000ms timeout
        CompletableFuture<Object> future1 = ask(getActorRef("workerActor"), new RequestParam(i + ""), 2000).toCompletableFuture();
        try {
            Future<Object> f = future1.whenComplete((v, e) -> {
                System.out.println(v);
                System.out.println(e);
            });
            return (String) f.get();
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
