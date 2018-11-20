package em.parqueadero.backend.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.domain.exception.preconditionexception.TrmException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(value = { PreconditionException.class })
	protected ResponseEntity<Object> preconditionException(PreconditionException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { TrmException.class })
	protected ResponseEntity<Object> trmException(TrmException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	protected ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
		return new ResponseEntity<>(exception.getBindingResult().getFieldError().getDefaultMessage() , HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { InvalidFormatException.class })
	protected ResponseEntity<Object> constraintDefinitionException(InvalidFormatException exception) {
		return new ResponseEntity<>("Valor " + exception.getValue() + " es invalido para el campo actual", HttpStatus.BAD_REQUEST);
	}	
	
}
