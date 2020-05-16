package name.javacode.codinginterview.algorithm.expression;

import static java.lang.Character.isLetterOrDigit;
import static java.lang.Character.isWhitespace;
import static name.javacode.codinginterview.algorithm.expression.ArithmeticOperatorToken.isArithmeticOperator;
import static name.javacode.codinginterview.algorithm.expression.OperatorTokenFactory.getArithmeticOperatorTokenInstance;
import static name.javacode.codinginterview.algorithm.expression.OperatorTokenFactory.getParenthesisTokenInstance;
import static name.javacode.codinginterview.algorithm.expression.ParenthesisToken.isParenthesis;

public class TokenFactory {
	public static Token getTokenInstance(Character symbol) {
		if (isWhitespace(symbol)) {
			return new WhitespaceToken(symbol);
		} else if (isLetterOrDigit(symbol)) {
			return new LetterOrDigitToken(symbol);
		} else if (isParenthesis(symbol)) {
			return getParenthesisTokenInstance(symbol);
		} else if (isArithmeticOperator(symbol)) {
			return getArithmeticOperatorTokenInstance(symbol);
		}

		throw new IllegalArgumentException("Unknown token: " + symbol);
	}
}
