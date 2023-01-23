package com.test.kafka.springcloudkafkatest.config;

import com.test.kafka.springcloudkafkatest.service.GreetingsService;
import com.test.kafka.springcloudkafkatest.stream.GreetingsStreams;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import com.test.kafka.springcloudkafkatest.web.GreetingsController;

@AutoConfiguration
@EnableBinding(GreetingsStreams.class)
public class GreetingConfig {

	@Bean
	public GreetingsController greetingsController() {
		return new GreetingsController();
	}

	@Bean
	public GreetingsService greetingsService() {
		return new GreetingsService();
	}

}
