package bootcamp.microservices.app.movements.exceptions.customs;

/**
 * Object that returns a message in case an exception occurs.
 */
public class CustomNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8299533233042901359L;

public CustomNotFoundException(String message) {
    super(message);
  }
}
