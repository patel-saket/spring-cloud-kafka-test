package com.test.kafka.springcloudkafkatest.web;

import com.test.kafka.springcloudkafkatest.model.Greetings;
import com.test.kafka.springcloudkafkatest.service.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @Autowired
    GreetingsService greetingsService;

    @RequestMapping("/greeting")
    public void greetings() {

        Greetings greetings = Greetings.builder()
                .message("Sending message")
                .timestamp(System.currentTimeMillis())
                .build();

        greetingsService.sendGreeting(greetings);
    }
}
