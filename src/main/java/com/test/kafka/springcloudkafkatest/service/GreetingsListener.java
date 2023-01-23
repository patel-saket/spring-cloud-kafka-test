package com.test.kafka.springcloudkafkatest.service;

import lombok.extern.slf4j.Slf4j;
import com.test.kafka.springcloudkafkatest.model.Greetings;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.test.kafka.springcloudkafkatest.stream.GreetingsStreams;


@Slf4j
public class GreetingsListener {
    @StreamListener(GreetingsStreams.INPUT)
    public void handleGreetings(@Payload Greetings greetings) {
        log.info("Received greetings: {}", greetings);
    }
}
