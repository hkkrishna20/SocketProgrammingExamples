package com.springbootlearnings.app.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQFanoutConfig {

	@Bean
	@Qualifier("fanoutMarketingQueue")
	Queue fanoutMarketingQueue() {
		return new Queue("marketingQueue", false);
	}

	@Bean
	@Qualifier("fanoutFinanceQueue")
	Queue fanoutFinanceQueue() {
		return new Queue("financeQueue", false);
	}

	@Bean
	@Qualifier("fanoutAdminQueue")
	Queue fanoutAdminQueue() {
		return new Queue("adminQueue", false);
	}

	@Bean
	FanoutExchange fanoutExchange() {
		return new FanoutExchange("fanout-exchange");
	}

	@Bean
	Binding marketingBinding(Queue fanoutMarketingQueue, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(fanoutMarketingQueue).to(fanoutExchange);
	}

	@Bean
	Binding financeBinding(Queue fanoutFinanceQueue, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(fanoutFinanceQueue).to(fanoutExchange);
	}

	@Bean
	Binding adminBinding(Queue fanoutAdminQueue, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(fanoutAdminQueue).to(fanoutExchange);
	}

}