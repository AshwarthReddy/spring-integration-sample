package com.anr.channels;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class FestivalWishHandler {

    public void handleWishes(Message<?> message) {
        System.out.println("Happy = " + message);

    }
}
