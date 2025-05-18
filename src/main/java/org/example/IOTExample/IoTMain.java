package org.example.IOTExample;

import org.apache.pekko.actor.typed.ActorSystem;

public class IoTMain {

    public static void main(String[] args) {
        // Create ActorSystem and top level supervisor
        ActorSystem.create(IotSupervisor.create(), "iot-system");
    }
}
