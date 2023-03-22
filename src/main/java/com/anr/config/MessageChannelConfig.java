package com.anr.config;

import com.anr.channels.EveryDayWishesHandler;
import com.anr.channels.FestivalWishHandler;
import com.anr.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.MessageChannel;

@Configuration
public class MessageChannelConfig {

    @Autowired
    private EveryDayWishesHandler everyDayWishesHandler;

    @Autowired
    private FestivalWishHandler festivalWishHandler;

    @Bean
    public MessageChannel wishes() {
        return MessageChannels.direct().get();
    }


    @Bean
    public DirectChannel thanksForWishes() {
        DirectChannel channel = new DirectChannel();
        channel.subscribe(mes -> System.out.println("mes = " + mes));
        return channel;
    }

    @Bean
    public IntegrationFlow wishesFlow(){
        return IntegrationFlow.from(wishes())
                .filter(Message.class, messsage -> messsage.message().equalsIgnoreCase("good"))
                .handle(message -> everyDayWishesHandler.handleWishes(message))
                .channel(thanksForWishes())
//                .filter(Message.class, messsage -> !messsage.message().equalsIgnoreCase("good"))
//                .handle(message -> festivalWishHandler.handleWishes(message))

                .get();
    }
}
