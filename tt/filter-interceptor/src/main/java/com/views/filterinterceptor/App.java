package com.views.filterinterceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@SpringBootApplication

public class App {
	public static void main(String[] args) throws Throwable {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public FilterRegistrationBean dawsonApiFilters() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new DawsonApiFilter());
		// In case you want the filter to apply to specific URL patterns only
		registration.addUrlPatterns("/student/*");
		return registration;
	}
}
