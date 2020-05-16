package com.springbootlearnings.app.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDirectConfig {

	@Bean
	@Qualifier("directMarketingQueue")
	Queue directMarketingQueue() {
		return new Queue("marketingQueue", false);
	}

	@Bean
	@Qualifier("directFinanceQueue")
	Queue directFinanceQueue() {
		return new Queue("financeQueue", false);
	}

	@Bean
	@Qualifier("directAdminQueue")
	Queue directAdminQueue() {
		return new Queue("adminQueue", false);
	}

	@Bean
	DirectExchange directExchange() {
		return new DirectExchange("direct-exchange");
	}

	@Bean
	Binding marketingBinding(Queue directMarketingQueue, DirectExchange directExchange) {
		return BindingBuilder.bind(directMarketingQueue).to(directExchange).with("marketing");
	}

	@Bean
	Binding financeBinding(Queue directFinanceQueue, DirectExchange directExchange) {
		return BindingBuilder.bind(directFinanceQueue).to(directExchange).with("finance");
	}

	@Bean
	Binding adminBinding(Queue directAdminQueue, DirectExchange directExchange) {
		return BindingBuilder.bind(directAdminQueue).to(directExchange).with("admin");
	}

}