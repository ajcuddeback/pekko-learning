package org.example.SupervisedFailure;

import org.apache.pekko.actor.typed.ActorRef;
import org.apache.pekko.actor.typed.ActorSystem;

public class SupervisingMain {
    public static void main(String[] args) {
        ActorRef<String> supervisingActor = ActorSystem.create(SupervisingActor.create(), "supervising-actor");
        supervisingActor.tell("failChild");
    }
}
