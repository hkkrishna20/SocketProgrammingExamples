package com.springbootlearnings.app.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {

	@Bean
	@Qualifier("topicmarketingQueue")
	Queue topicmarketingQueue() {
		return new Queue("marketingQueue", false);
	}

	@Bean
	@Qualifier("topicfinanceQueue")
	Queue topicfinanceQueue() {
		return new Queue("financeQueue", false);
	}

	@Bean
	@Qualifier("topicadminQueue")
	Queue topicadminQueue() {
		return new Queue("adminQueue", false);
	}

	@Bean
	@Qualifier("allQueue")
	Queue allQueue() {
		return new Queue("allQueue", false);
	}

	@Bean
	TopicExchange topicExchange() {
		return new TopicExchange("topic-exchange");
	}

	@Bean
	Binding marketingBinding(Queue topicmarketingQueue, TopicExchange topicExchange) {
		return BindingBuilder.bind(topicmarketingQueue).to(topicExchange).with("queue.marketing");
	}

	@Bean
	Binding financeBinding(Queue topicfinanceQueue, TopicExchange topicExchange) {
		return BindingBuilder.bind(topicfinanceQueue).to(topicExchange).with("queue.finance");
	}

	@Bean
	Binding adminBinding(Queue topicadminQueue, TopicExchange topicExchange) {
		return BindingBuilder.bind(topicadminQueue).to(topicExchange).with("queue.admin");
	}

	@Bean
	Binding allBinding(Queue allQueue, TopicExchange topicExchange) {
		return BindingBuilder.bind(allQueue).to(topicExchange).with("queue.*");
	}

}