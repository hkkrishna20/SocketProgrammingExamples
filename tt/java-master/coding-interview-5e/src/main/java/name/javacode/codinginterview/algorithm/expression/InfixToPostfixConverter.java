package name.javacode.codinginterview.algorithm.expression;

import static name.javacode.codinginterview.algorithm.expression.TokenFactory.getTokenInstance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InfixToPostfixConverter {
	public static final Logger LOGGER = LoggerFactory.getLogger(InfixToPostfixConverter.class);

	public String convert(String input) {
		final TokenHandler handler = new ShuntingYard();

		input.chars().mapToObj(i -> (char) i).forEach(i -> {
			Token t = getTokenInstance(i);

			LOGGER.debug("Token: {}", t.toString());

			t.visit(handler);
		});

		return handler.getOutput();
	}
}
