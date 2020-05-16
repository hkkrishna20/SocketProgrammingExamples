package com.springbootlearnings.app.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.springbootlearnings.app.model.Employee;

@Service
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate rabbTemplate;

	@Value("${springbootex.rabbitmq.exchange}")
	private String exchange;

	@Value("${springbootex.rabbitmq.routingkey}")
	private String routingkey;

	public void send(Employee company) {
		rabbTemplate.convertAndSend(exchange, routingkey, company);
		System.out.println("Send msg = " + company);

	}
}