package org.example.StartStopExample;

import org.apache.pekko.actor.typed.ActorRef;
import org.apache.pekko.actor.typed.ActorSystem;

public class StartStop {
    public static void main(String[] args) {
        ActorRef<String> testSystem = ActorSystem.create(StartStopActor1.create(), "testSystem");
        testSystem.tell("stop");
    }
}
