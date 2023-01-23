package com.test.kafka.springcloudkafkatest.service;

import lombok.extern.slf4j.Slf4j;
import com.test.kafka.springcloudkafkatest.model.Greetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import com.test.kafka.springcloudkafkatest.stream.GreetingsStreams;


@Slf4j
public class GreetingsService {

    @Autowired
    private GreetingsStreams greetingsStreams;

    public void sendGreeting(final Greetings greetings) {
        log.info("Sending greetings {}", greetings);

        MessageChannel messageChannel = greetingsStreams.outboundGreetings();
        messageChannel.send(MessageBuilder
                .withPayload(greetings)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
}
