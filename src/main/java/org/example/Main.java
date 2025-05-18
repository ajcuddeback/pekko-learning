package org.example;

import org.apache.pekko.actor.typed.ActorRef;
import org.apache.pekko.actor.typed.ActorSystem;
import org.apache.pekko.actor.typed.Behavior;
import org.apache.pekko.actor.typed.javadsl.AbstractBehavior;
import org.apache.pekko.actor.typed.javadsl.ActorContext;
import org.apache.pekko.actor.typed.javadsl.Behaviors;
import org.apache.pekko.actor.typed.javadsl.Receive;

class Main extends AbstractBehavior<String> {

    static Behavior<String> create() {
        return Behaviors.setup(Main::new);
    }

    private Main(ActorContext<String> context) {
        super(context);
    }

    @Override
    public Receive<String> createReceive() {
        return newReceiveBuilder().onMessageEquals("start", this::start).build();
    }

    private Behavior<String> start() {
        ActorRef<String> firstRef = getContext().spawn(PrintMyActorRefActor.create(), "first-actor");

        System.out.println("First: " + firstRef);
        firstRef.tell("printit");
        return Behaviors.same();
    }
}