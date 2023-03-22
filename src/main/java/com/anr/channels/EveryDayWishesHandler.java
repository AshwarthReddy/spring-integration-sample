package com.anr.channels;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class EveryDayWishesHandler {
    public void handleWishes(Message<?> message) {
        System.out.println("Very = " + message);

    }
}
