package com.springbootlearnings.app.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQHeaderConfig {

	@Bean
	@Qualifier("headermarketingQueue")
	Queue headermarketingQueue() {
		return new Queue("marketingQueue", false);
	}

	@Bean
	@Qualifier("headerfinanceQueue")
	Queue headerfinanceQueue() {
		return new Queue("financeQueue", false);
	}

	@Bean
	@Qualifier("headeradminQueue")
	Queue headeradminQueue() {
		return new Queue("adminQueue", false);
	}

	@Bean
	HeadersExchange headerExchange() {
		return new HeadersExchange("header-exchange");
	}

	@Bean
	Binding marketingBinding(Queue headermarketingQueue, HeadersExchange headerExchange) {
		return BindingBuilder.bind(headermarketingQueue).to(headerExchange).where("department").matches("marketing");
	}

	@Bean
	Binding financeBinding(Queue headerfinanceQueue, HeadersExchange headerExchange) {
		return BindingBuilder.bind(headerfinanceQueue).to(headerExchange).where("department").matches("finance");
	}

	@Bean
	Binding adminBinding(Queue headeradminQueue, HeadersExchange headerExchange) {
		return BindingBuilder.bind(headeradminQueue).to(headerExchange).where("department").matches("admin");
	}

}
