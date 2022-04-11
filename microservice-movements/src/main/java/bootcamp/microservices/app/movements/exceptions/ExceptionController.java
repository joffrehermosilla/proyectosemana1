package bootcamp.microservices.app.movements.exceptions;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;

/**
 * Exception controller.
 */
@ControllerAdvice
public class ExceptionController {
  /**
   * Return a list of required params when they are empty.
   */
  @ExceptionHandler(WebExchangeBindException.class)
  public ResponseEntity<List<String>> handleException(WebExchangeBindException e) {
    List<String> errors = e.getBindingResult()
        .getAllErrors()
        .stream()
        .map(DefaultMessageSourceResolvable::getDefaultMessage)
        .collect(Collectors.toList());
    return ResponseEntity.badRequest().body(errors);
  }
}
