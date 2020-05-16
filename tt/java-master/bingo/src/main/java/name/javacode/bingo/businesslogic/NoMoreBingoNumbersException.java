package name.javacode.bingo.businesslogic;

/**
 * Exception that gets thrown when all Bingo numbers in the pool have been
 * called
 * 
 * @author Author
 */
public class NoMoreBingoNumbersException extends Exception {
	private static final long serialVersionUID = 213218548664089789L;

	public NoMoreBingoNumbersException() {
	}

	public NoMoreBingoNumbersException(String message) {
		super(message);
	}

	public NoMoreBingoNumbersException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoMoreBingoNumbersException(Throwable cause) {
		super(cause);
	}
}
