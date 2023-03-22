package com.anr.controller;

import com.anr.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wish")
public class WisherController {



    @Autowired
    private MessageChannel wishes;

    @GetMapping("/{message}")
    public boolean doWish(@PathVariable String message) {
        return wishes.send(MessageBuilder.withPayload(new Message(Math.random(), message)).build());
    }
}
